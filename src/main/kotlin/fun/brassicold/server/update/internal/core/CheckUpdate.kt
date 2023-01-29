package `fun`.brassicold.server.update.internal.core

import `fun`.brassicold.server.update.util.ObtainPluginVersion
import `fun`.brassicold.server.update.util.SettingManager
import `fun`.brassicold.server.update.util.ToolsUtil
import taboolib.common.platform.function.console
import taboolib.common.platform.function.pluginId
import taboolib.module.lang.sendLang
import java.util.*


object CheckUpdate {
    private fun checkUpdate(plugin: String): String? {
        val updateWeb by lazy { CentralControl.obtainUpdateWeb(plugin) }
        if (updateWeb == "不存在") {
            return SettingManager.Lang_null!!
        }
        var version: String? = null
        when (ToolsUtil.upType(updateWeb)) {
            "spigot" -> {
                version = ObtainPluginVersion.obtainVersion("spigot", plugin.lowercase(Locale.getDefault()), plugin)
                return if (ToolsUtil.pluginVersion(plugin) == version) {
                    SettingManager.Lang_new
                } else {
                    "无法获取版本"
                }
            }
            "github" -> {
                version = ObtainPluginVersion.obtainVersion("github", plugin.lowercase(Locale.getDefault()), plugin)
                return if (ToolsUtil.pluginVersion(plugin) == version) {
                    SettingManager.Lang_new
                } else {
                    "无法获取版本"
                }
            }
            null -> {
                return "无法获取版本"
            }
        }
        return SettingManager.Lang_null!!
    }

    fun checkUpdate() {
        //服务器的插件列表
        val serverPlugin by lazy { ServerPluginsManager.obtainPluginList() as ArrayList<*> }
        //更新的插件列表
        val updatePlugin by lazy { CentralControl.obtainUpdatePluginList() }
        //遍历服务器插件列表，每一个都判断一次是不是更新的列表中的之一
        for (sePlugin in serverPlugin) {
            if (sePlugin !in updatePlugin && SettingManager.Setting_NotUpdateList) {
                checkUpdate(sePlugin.toString())?.let {
                    console().sendLang("update-format", pluginId, sePlugin.toString(),
                        it
                    )
                }
            }
            if (sePlugin in updatePlugin) {
                //如果是其一，就输出如下
                checkUpdate(sePlugin.toString())?.let {
                    console().sendLang("update-format", pluginId, sePlugin.toString(),
                        it
                    )
                }
            }
        }
    }
}