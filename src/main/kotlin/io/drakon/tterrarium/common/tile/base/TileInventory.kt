package io.drakon.tterrarium.common.tile.base

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.inventory.IInventory
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.nbt.NBTTagList
import net.minecraft.util.ChatComponentText
import net.minecraft.util.ChatComponentTranslation
import net.minecraft.util.IChatComponent
import org.apache.logging.log4j.LogManager

/**
 * Base TE with inventory.
 *
 * Based on the Mantle implementation.
 */
abstract class TileInventory(val _name:String, val size:Int, val stackSizeLimit:Int): TileTT(), IInventory {

    protected var inventory = arrayOfNulls<ItemStack>(size)
    private var customName: String? = null

    /* IInventory */
    override fun setInventorySlotContents(index: Int, stack: ItemStack?) {
        if (index >= size) return // out of bounds
        val count = if (stack != null) stack.stackSize else 0
        if (count < stackSizeLimit && isItemValidForSlot(index, stack)) {
            inventory[index] = stack
        }
    }

    override fun getStackInSlot(index: Int): ItemStack? {
        if (index >= size) return null
        return inventory[index]
    }

    override fun clear() {
        inventory = arrayOfNulls(size)
    }

    override fun getInventoryStackLimit(): Int {
        return stackSizeLimit
    }

    override fun openInventory(player: EntityPlayer?) {}

    override fun setField(id: Int, value: Int) {}

    override fun removeStackFromSlot(index: Int): ItemStack? {
        if (index >= size) return null
        val elem = inventory[index]
        inventory[index] = null
        return elem
    }

    override fun getFieldCount(): Int {
        return 0
    }

    override fun getField(id: Int): Int {
        return 0
    }

    override fun decrStackSize(index: Int, count: Int): ItemStack? {
        val stack = getStackInSlot(index) ?: return null
        if (stack.stackSize <= count) {
            setInventorySlotContents(index, null)
            markDirty()
            return stack
        }

        val retStack = stack.splitStack(count)
        if (stack.stackSize <= 0) setInventorySlotContents(index, null)

        markDirty()
        return retStack
    }

    override fun getSizeInventory(): Int {
        return size
    }

    override abstract fun isItemValidForSlot(index: Int, stack: ItemStack?): Boolean

    override abstract fun isUseableByPlayer(player: EntityPlayer?): Boolean

    override fun closeInventory(player: EntityPlayer?) {}

    /* IWorldNameable */
    override fun getName(): String? {
        if (customName == null) return _name else return customName
    }

    override fun hasCustomName(): Boolean {
        return customName != null
    }

    override fun getDisplayName(): IChatComponent? {
        if (hasCustomName()) return ChatComponentText(name)
        return ChatComponentTranslation(name)
    }

    /* TileEntity */
    override fun readFromNBT(compound: NBTTagCompound) {
        super.readFromNBT(compound)
        deserialiseFromNBT(compound.getCompoundTag("inventory"))
    }

    override fun writeToNBT(compound: NBTTagCompound) {
        super.writeToNBT(compound)
        compound.setTag("inventory", serialiseToNBT())
    }

    /* TileInventory */
    public fun serialiseToNBT(): NBTTagCompound {
        val tags = NBTTagCompound()
        tags.setInteger("size", size)

        val nbtSlots = NBTTagList()
        for (i in 0..size) {
            val stack = getStackInSlot(i) ?: continue
            val tag = NBTTagCompound()
            tag.setInteger("slot", i)
            stack.writeToNBT(tag)
            nbtSlots.appendTag(tag)
        }

        tags.setTag("items", nbtSlots)
        return tags
    }

    public fun deserialiseFromNBT(tag:NBTTagCompound) {
        val recordedSize = tag.getInteger("size")
        if (recordedSize != size) LogManager.getLogger().warn("Deserialising an inventory tag with size $recordedSize to an inventory of size $size - may lose items.")

        val tagList = tag.getTagList("items", 10)
        for (i in 0..tagList.tagCount()) {
            val currTag = tagList.getCompoundTagAt(i)
            val slot = currTag.getInteger("slot")
            if (slot >= 0 && slot < size) {
                setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(currTag))
            }
        }
    }

}