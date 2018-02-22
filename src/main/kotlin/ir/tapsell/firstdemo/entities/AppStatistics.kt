package ir.tapsell.firstdemo.entities

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*


@Document(collection = "AppStatistics")
data class AppStatistics(
        val reportTime: Date? = null,
        val type: AppType? = AppType.Android,
        val videoRequests: Int = 0,
        val webViewRequests: Int = 0,
        val videoClicks: Int = 0,
        val webViewClicks: Int = 0,
        val videoInstalls: Int = 0,
        val webViewInstalls: Int = 0,
        @Id
        val id: String? = null)