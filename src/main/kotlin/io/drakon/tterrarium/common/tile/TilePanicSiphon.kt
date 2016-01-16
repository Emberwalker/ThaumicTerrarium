package io.drakon.tterrarium.common.tile

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.inventory.ISidedInventory
import net.minecraft.item.ItemStack
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.EnumFacing
import net.minecraft.util.IChatComponent

/**
 * The destroyer of auras. - TE
 *
 * @author Arkan <arkan@drakon.io>
 */
class TilePanicSiphon: TileEntity(), ISidedInventory {
    override fun getStackInSlot(index: Int): ItemStack? {
        throw UnsupportedOperationException()
    }

    override fun clear() {
        throw UnsupportedOperationException()
    }

    override fun getInventoryStackLimit(): Int {
        throw UnsupportedOperationException()
    }

    override fun openInventory(player: EntityPlayer?) {
        throw UnsupportedOperationException()
    }

    override fun setField(id: Int, value: Int) {
        throw UnsupportedOperationException()
    }

    override fun removeStackFromSlot(index: Int): ItemStack? {
        throw UnsupportedOperationException()
    }

    override fun getFieldCount(): Int {
        throw UnsupportedOperationException()
    }

    override fun getField(id: Int): Int {
        throw UnsupportedOperationException()
    }

    override fun decrStackSize(index: Int, count: Int): ItemStack? {
        throw UnsupportedOperationException()
    }

    override fun getSizeInventory(): Int {
        throw UnsupportedOperationException()
    }

    override fun isItemValidForSlot(index: Int, stack: ItemStack?): Boolean {
        throw UnsupportedOperationException()
    }

    override fun isUseableByPlayer(player: EntityPlayer?): Boolean {
        throw UnsupportedOperationException()
    }

    override fun closeInventory(player: EntityPlayer?) {
        throw UnsupportedOperationException()
    }

    override fun setInventorySlotContents(index: Int, stack: ItemStack?) {
        throw UnsupportedOperationException()
    }

    override fun getName(): String? {
        throw UnsupportedOperationException()
    }

    override fun hasCustomName(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun getDisplayName(): IChatComponent? {
        throw UnsupportedOperationException()
    }

    override fun getSlotsForFace(side: EnumFacing?): IntArray? {
        throw UnsupportedOperationException()
    }

    override fun canInsertItem(index: Int, itemStackIn: ItemStack?, direction: EnumFacing?): Boolean {
        throw UnsupportedOperationException()
    }

    override fun canExtractItem(index: Int, stack: ItemStack?, direction: EnumFacing?): Boolean {
        throw UnsupportedOperationException()
    }
}