package ir.tapsell.firstdemo.entities

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class AppStatistics(
                         val reportTime: Date? = null,
                         val type: Int? = null,
                         val videoRequests: Int? = null,
                         val webViewRequests: Int? = null,
                         val videoClicks: Int? = null,
                         val webviewClicks: Int? = null,
                         val videoInstalls: Int? = null,
                         val webviewInstalls: Int? = null,
                         @Id @GeneratedValue
                         val id: String? = null)