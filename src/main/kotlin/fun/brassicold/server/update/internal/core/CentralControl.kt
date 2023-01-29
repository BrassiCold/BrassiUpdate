package `fun`.brassicold.server.update.internal.core

import `fun`.brassicold.server.update.util.SettingManager


object CentralControl {
    fun obtainUpdateWeb(plugin: String): String {
        //获取指定插件对应的web
        //第一步获取update列表 => SettingManager.Setting_Update
        //第二步循环遍历
        val updatePluginList by lazy { SettingManager.Setting_Update }
        for (updatePlugin in updatePluginList) {
            val updatePluginValue by lazy { updatePlugin.keys.toString().replace("[", "").replace("]", "") }
            when (updatePluginValue) {
                plugin -> {
                    return updatePlugin.values.toString()
                }
            }
        }
        return "不存在"
    }

    fun obtainUpdatePluginList(): ArrayList<String> {
        val nameList by lazy { ArrayList<String>() }
        for (pluginInfo in SettingManager.Setting_Update) {
            val pluginName by lazy { pluginInfo.keys.toString().removePrefix("[]") }
            val pluginName1 by lazy { pluginName.replace("[", "").replace("]", "") }
            nameList.add(pluginName1)
        }
        return nameList
    }
}