package ir.tapsell.firstdemo.entities

import java.io.Serializable

data class AppStatisticsModel (val weekNum: Int = 0,
                               val year: Int = 0,
                               val requests: Int = 0,
                               val clicks: Int = 0,
                               val installs: Int = 0) : Serializable