package io.drakon.tterrarium.common.block

import io.drakon.tterrarium.common.tile.TilePanicSiphon
import net.minecraftforge.fml.common.registry.GameRegistry
import kotlin.*

/**
 * Package-level stuff
 */

private var blockInit = false

public fun initBlocks() {
    if (blockInit) return

    GameRegistry.registerBlock(BlockPanicSiphon(), "panic_siphon")
    GameRegistry.registerTileEntity(TilePanicSiphon::class.java, "tterrarium:panic_siphon.tile")

    blockInit = true
}
