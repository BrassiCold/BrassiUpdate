package `fun`.brassicold.server.update.util

import taboolib.common.platform.function.console
import taboolib.common.platform.function.pluginId
import taboolib.module.lang.sendLang

object ToolsUtil {
    fun tell(message: String) {
        if (SettingManager.Setting_Debug) {
            return console().sendLang("debug-format", pluginId, message)
        }
    }

    fun timing(t: String): Int? {
        val timing by lazy { t.split(" ").toMutableList() }
        val type by lazy { timing[1] }
        val intime by lazy { timing[0].toInt() }
        when (type) {
            "min" -> {
                return intime * 60 * 20
            }
            "h" -> {
                return intime * 60 * 60 * 20
            }
            "s" -> {
                return intime * 20
            }
        }
        return null
    }

    fun upType(web: String): String? {
        val webTest by lazy { web.split("://").toMutableList() }
        console().sendMessage("webTest: ${webTest[0]}")
        if ("https" != webTest[0].removePrefix("[")) {
            return null
        }
        val webTest1 by lazy { webTest[1].split("/").toMutableList()[0] }
        when (webTest1) {
            "www.spigotmc.org" -> {
                console().sendMessage("spigot")
                return "spigot"
            }

            "github.com" -> {
                console().sendMessage("github")
                return "github"
            }
        }
        return null
    }
}