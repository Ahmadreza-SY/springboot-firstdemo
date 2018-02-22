package ir.tapsell.firstdemo.services

import ir.tapsell.firstdemo.entities.AppStatistics
import ir.tapsell.firstdemo.entities.AppStatisticsModel
import ir.tapsell.firstdemo.entities.AppType
import ir.tapsell.firstdemo.repositories.ApplicationStatRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ApplicationStatService {

    @Autowired
    lateinit var appStatRepo: ApplicationStatRepository

//    var logger = LoggerFactory.getLogger(ApplicationStatService::class.java)

    fun getAllApps(): List<AppStatistics> = appStatRepo.findAll()

    fun addAppStats(appStatistics: AppStatistics) = appStatRepo.save(appStatistics)!!

    fun getStats(startDate: Date, endDate: Date, type: AppType): List<AppStatisticsModel> {
        val stats : List<AppStatistics> = appStatRepo.findByTypeAndReportTimeBetween(type ,startDate, endDate)
        val result : MutableList<AppStatisticsModel> = mutableListOf()
        stats.iterator().forEach {
            val cal : Calendar = Calendar.getInstance()
            cal.time = it.reportTime
            result.add(AppStatisticsModel(
                weekNum = cal.get(Calendar.WEEK_OF_YEAR),
                year = cal.get(Calendar.YEAR),
                requests = it.videoRequests + it.webViewRequests,
                clicks = it.videoClicks + it.webViewClicks,
                installs = it.videoInstalls + it.webViewInstalls)
            )
        }
        return result
    }

}