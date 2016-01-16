package io.drakon.tterrarium.common.block

import io.drakon.tterrarium.common.tile.TilePanicSiphon
import net.minecraft.block.BlockContainer
import net.minecraft.block.material.Material
import net.minecraft.tileentity.TileEntity
import net.minecraft.world.World

/**
 * The destroyer of auras. - Block
 *
 * @author Arkan <arkan@drakon.io>
 */
class BlockPanicSiphon: BlockContainer(Material.circuits) {

    override fun createNewTileEntity(worldIn: World?, meta: Int): TileEntity? {
        return TilePanicSiphon()
    }

}