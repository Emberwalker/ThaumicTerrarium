package io.drakon.tterrarium

import io.drakon.tterrarium.common.block.initBlocks
import io.drakon.tterrarium.common.lib.Const
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import org.apache.logging.log4j.LogManager

/**
 * Flux and taint meets environmentalism.
 *
 * @author Arkan <arkan@drakon.io>
 */
@Mod(modid = Const.MOD_ID, name = Const.MOD_NAME, version = Const.VERSION,
        dependencies = "required-after:Thaumcraft@[5.1.0.0,)",
        modLanguageAdapter = "io.drakon.forgelin.KotlinAdapter")
object ThaumicTerrarium {

    private val logger = LogManager.getLogger()

    @EventHandler
    fun preinit(evt:FMLPreInitializationEvent) {
        logger.info("Preinit.")
        initBlocks()
    }

    @EventHandler
    fun init(evt:FMLInitializationEvent) {
        logger.info("Init.")
    }

    @EventHandler
    fun postinit(evt:FMLPostInitializationEvent) {
        logger.info("Postinit.")
    }

}