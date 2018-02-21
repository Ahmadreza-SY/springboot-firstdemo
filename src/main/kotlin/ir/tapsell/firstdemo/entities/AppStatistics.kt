package ir.tapsell.firstdemo.entities

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*


@Document(collection = "AppStatistics")
data class AppStatistics(
        val reportTime: Date? = null,
        val type: AppType? = AppType.ANDROID,
        val videoRequests: Int? = null,
        val webViewRequests: Int? = null,
        val videoClicks: Int? = null,
        val webViewClicks: Int? = null,
        val videoInstalls: Int? = null,
        val webViewInstalls: Int? = null,
        @Id
        val id: String? = null)