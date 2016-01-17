package io.drakon.tterrarium.common.tile

import io.drakon.tterrarium.common.tile.base.TileInventory
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import thaumcraft.api.items.ItemsTC

/**
 * The destroyer of auras. - TE
 *
 * @author Arkan <arkan@drakon.io>
 */
class TilePanicSiphon: TileInventory("tterrarium:panic_siphon.name", 1, 64) {
    override fun isItemValidForSlot(index: Int, stack: ItemStack?): Boolean {
        return stack == null || stack.item == ItemsTC.shard
    }

    override fun isUseableByPlayer(player: EntityPlayer?): Boolean {
        return true
    }
}