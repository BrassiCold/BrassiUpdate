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

    fun parseGithubURL(url: String): Pair<String, String>? {
        val pattern = Regex("https://github.com/(.*?)/(.*?)/?")
        val matchResult = pattern.find(url)
        return if (matchResult != null) {
            Pair(matchResult.groupValues[1], matchResult.groupValues[2])
        } else {
            null
        }
    }
}