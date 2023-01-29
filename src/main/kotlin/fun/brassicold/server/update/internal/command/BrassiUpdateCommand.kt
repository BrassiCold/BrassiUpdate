package `fun`.brassicold.server.update.internal.command

import `fun`.brassicold.server.update.internal.core.CheckUpdate
import `fun`.brassicold.server.update.internal.event.PluginDisableEvent
import `fun`.brassicold.server.update.internal.event.PluginReloadEvent
import `fun`.brassicold.server.update.util.SettingManager
import `fun`.brassicold.server.update.util.ToolsUtil
import taboolib.common.platform.ProxyCommandSender
import taboolib.common.platform.command.*
import taboolib.common.platform.function.pluginId
import taboolib.expansion.createHelper
import taboolib.module.lang.sendLang

@CommandHeader(
    name = "brassiupdate",
    aliases = ["bu", "up"],
    permission = "brassiupdate.command",
    permissionDefault = PermissionDefault.OP,
    description = "BrassiUpdate Main Command"
)
object BrassiUpdateCommand {
    @CommandBody(aliases = ["help"], permission = "brassiupdate.command.help", permissionDefault = PermissionDefault.OP)
    val main = mainCommand {
        createHelper()
    }
    @CommandBody(permission = "brassiupdate.command.reload", permissionDefault = PermissionDefault.OP)
    val reload = subCommand {
        execute<ProxyCommandSender> { sender, _, _ ->
            PluginReloadEvent.call()
            ToolsUtil.tell("Debug: ${SettingManager.Setting_Debug}")
            ToolsUtil.tell("Debug模式已开启!")
            sender.sendLang("command-reload", pluginId)
        }
    }

    @CommandBody(permission = "brassiupdate.command.disable", permissionDefault = PermissionDefault.OP)
    val disable = subCommand {
        execute<ProxyCommandSender> { sender, _, _ ->
            sender.sendLang("command-disable", pluginId)
            PluginDisableEvent.call()
        }
    }

    @CommandBody(permission = "brassiupdate.command.check", permissionDefault = PermissionDefault.OP)
    val check = subCommand {
        execute<ProxyCommandSender> { sender, _, _ ->
            sender.sendMessage("正在检查更新中......")
            CheckUpdate.checkUpdate()
        }
    }
}