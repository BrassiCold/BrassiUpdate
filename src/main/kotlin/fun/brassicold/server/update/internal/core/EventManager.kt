package `fun`.brassicold.server.update.internal.core

import `fun`.brassicold.server.update.BrassiUpdate
import `fun`.brassicold.server.update.internal.event.PluginDisableEvent
import `fun`.brassicold.server.update.internal.event.PluginReloadEvent
import taboolib.common.platform.event.SubscribeEvent
import taboolib.common.platform.function.disablePlugin

@SubscribeEvent
fun pluginReload(event: PluginReloadEvent) {
    BrassiUpdate.setting.reload()
}

@SubscribeEvent
fun pluginDisable(event: PluginDisableEvent) {
    disablePlugin()
}
