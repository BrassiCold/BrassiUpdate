package `fun`.brassicold.server.update.util

import `fun`.brassicold.server.update.BrassiUpdate

object SettingManager {
    val Setting_Debug: Boolean
        get() = BrassiUpdate.setting.getBoolean("Options.debug")
    val Setting_Update: List<Map<*, *>>
        get() = BrassiUpdate.setting.getMapList("UpdateList")
    val Setting_AutoCheck: Boolean
        get() = BrassiUpdate.setting.getBoolean("Options.autoCheckUpdate.enable")
    val Setting_NotUpdateList: Boolean
        get() = BrassiUpdate.setting.getBoolean("Options.notUpdateListInfo")
    val Lang_new: String?
        get() = BrassiUpdate.setting.getString("Lang.update-format-new")
    val Lang_old: String?
        get() = BrassiUpdate.setting.getString("Lang.update-format-old")
    val Lang_null: String?
        get() = BrassiUpdate.setting.getString("Lang.update-format-null")
    val Download_Plugin: Boolean
        get() = BrassiUpdate.setting.getBoolean("Options.downloadPlugin")
}