package `fun`.brassicold.server.update.util

import org.bukkit.Bukkit
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
        val web = url.replace("[", "").replace("]", "")
        val prefix = "https://github.com/"
        if (!web.startsWith(prefix)) {
            console().sendMessage("字符串不以${prefix} 开头")
            return null
        }
        val parts = web.substring(prefix.length).split("/")
        console().sendMessage("parts: $parts")
        if (parts.size < 2) return null
        return Pair(parts[0], parts[parts.size - 1])
    }

    fun pluginVersion(id: String): String? {
        val serverPlugins by lazy { Bukkit.getPluginManager().plugins.toMutableList() as ArrayList<*> }
        val pluginList by lazy { serverPlugins.clone() as ArrayList<*> }
        for (plugin in pluginList) {
            if (plugin.toString().startsWith(id)) {
                return plugin.toString().split(" ").toMutableList()[1]
            }
        }
        return null
    }
}