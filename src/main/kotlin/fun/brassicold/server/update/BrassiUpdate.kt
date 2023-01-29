package `fun`.brassicold.server.update

import `fun`.brassicold.server.update.internal.BrassiUpdateLoader
import `fun`.brassicold.server.update.util.ToolsUtil
import taboolib.common.platform.Plugin
import taboolib.module.configuration.Config
import taboolib.module.configuration.ConfigFile

object BrassiUpdate : Plugin() {


    @Config("setting.yml", migrate = true)
    lateinit var setting: ConfigFile

    override fun onLoad() {
        BrassiUpdateLoader.load()
    }

    override fun onEnable() {
        BrassiUpdateLoader.enable()
        ToolsUtil.tell("Debug模式已开启!")
    }

    override fun onDisable() {
        BrassiUpdateLoader.disable()
    }
}