package `fun`.brassicold.server.update.util

import `fun`.brassicold.server.update.internal.core.CentralControl
import taboolib.common.platform.function.console
import java.net.HttpURLConnection
import java.net.URL

object ObtainPluginVersion {
    fun obtainVersion(type: String, pluginId: String, plugin: String): String? {
        var version: String? = null
        when (type) {
            "spigot" -> {

                //还没想到办法实现
                console().sendMessage("暂不支持Spigot！")
                return  null

                /**
                try {
                    // 构造获取插件信息的URL
                    val url = URL("https://api.spigotmc.org/legacy/update.php?resource=$pluginId")
                    // 打开URL连接
                    val connection = url.openConnection() as HttpURLConnection

                    // 设置请求方法为GET
                    connection.requestMethod = "GET"
                    // 设置连接超时时间为5秒
                    connection.connectTimeout = 5000
                    // 设置读取超时时间为5秒
                    connection.readTimeout = 5000
                    // 发送请求并获取返回数据
                    connection.inputStream.bufferedReader().use {
                        version = it.readLine()
                    }
                }catch (e: Exception) {
                    println("Error: ${e.message}")
                    e.printStackTrace()
                }
                return if (version == null || version!!.isEmpty()) null
                else version
                */
            }
            "github" -> {
                try {
                    val result = ToolsUtil.parseGithubURL(CentralControl.obtainUpdateWeb(plugin))
                    val owner = result?.first
                    val repo= result?.second
                    val url = URL("https://api.github.com/repos/$owner/$repo/releases/latest")
                    val connection = url.openConnection() as HttpURLConnection
                    connection.setRequestProperty("Accept", "application/vnd.github+json")
                    connection.connect()
                    val response = connection.inputStream.bufferedReader().readText()
                    return if (connection.responseCode == 200) {
                        val startIndex = response.indexOf("tag_name") + 11
                        val endIndex = response.indexOf("\"", startIndex)
                        response.substring(startIndex, endIndex)
                    } else {
                        null
                    }
                } catch (e: Exception) {
                    println("Error: ${e.message}")
                    e.printStackTrace()
                }
            }
        }
        return null
    }
}