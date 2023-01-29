package `fun`.brassicold.server.update.internal

import taboolib.common.io.newFile
import taboolib.common.platform.function.console
import taboolib.common.platform.function.pluginId
import taboolib.module.lang.sendLang
import taboolib.platform.util.bukkitPlugin

object BrassiUpdateLoader {
    fun load() {
        console().sendLang("plugin-load", pluginId)
    }

    fun enable() {
        console().sendMessage("")
        console().sendMessage("§b▄▄▄▄· ▄▄▄   ▄▄▄· .▄▄ · .▄▄ · ▪  ▄• ▄▌ ▄▄▄··▄▄▄▄   ▄▄▄· ▄▄▄▄▄▄▄▄ .")
        console().sendMessage("§b▐█ ▀█▪▀▄ █·▐█ ▀█ ▐█ ▀. ▐█ ▀. ██ █▪██▌▐█ ▄███▪ ██ ▐█ ▀█ •██  ▀▄.▀·")
        console().sendMessage("§b▐█▀▀█▄▐▀▀▄ ▄█▀▀█ ▄▀▀▀█▄▄▀▀▀█▄▐█·█▌▐█▌ ██▀·▐█· ▐█▌▄█▀▀█  ▐█.▪▐▀▀▪▄")
        console().sendMessage("§b██▄▪▐█▐█•█▌▐█ ▪▐▌▐█▄▪▐█▐█▄▪▐█▐█▌▐█▄█▌▐█▪·•██. ██ ▐█ ▪▐▌ ▐█▌·▐█▄▄▌")
        console().sendMessage("§b·▀▀▀▀ .▀  ▀ ▀  ▀  ▀▀▀▀  ▀▀▀▀ ▀▀▀ ▀▀▀ .▀   ▀▀▀▀▀•  ▀  ▀  ▀▀▀  ▀▀▀ ")
        console().sendMessage("")

        val pluginFolder by lazy { bukkitPlugin.dataFolder }
        val pluginsFile by lazy { newFile(pluginFolder, "plugins/") }
        pluginsFile.createNewFile()
        console().sendLang("plugin-enable", pluginId)
    }

    fun disable() {
        console().sendLang("plugin-disable", pluginId)
    }
}