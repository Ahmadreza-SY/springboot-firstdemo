package ir.tapsell.firstdemo.repositories

import ir.tapsell.firstdemo.entities.AppStatistics
import ir.tapsell.firstdemo.entities.AppType
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface ApplicationStatRepository : MongoRepository<AppStatistics, String> {
    fun findByType(type: AppType) : AppStatistics
    fun findByTypeAndReportTimeBetween(type: AppType, start: Date, end: Date) : List<AppStatistics>
}