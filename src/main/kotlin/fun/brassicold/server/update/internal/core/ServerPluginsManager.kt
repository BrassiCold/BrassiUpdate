package `fun`.brassicold.server.update.internal.core

import org.bukkit.Bukkit


object ServerPluginsManager {
    fun obtainPluginList(): java.util.ArrayList<*> {
        val serverPlugins by lazy { Bukkit.getPluginManager().plugins.toMutableList() as ArrayList<*> }
        val pluginList by lazy { serverPlugins.clone() as ArrayList<*> }
        val serverPluginNameList = ArrayList<String>()
        for (plugin in pluginList) {
            val test = plugin.toString().split(" ").toMutableList()[0]
            serverPluginNameList.add(test)
        }
        return serverPluginNameList
    }
}