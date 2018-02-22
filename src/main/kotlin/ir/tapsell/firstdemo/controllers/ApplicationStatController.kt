package ir.tapsell.firstdemo.controllers

import ir.tapsell.firstdemo.entities.AppStatistics
import ir.tapsell.firstdemo.entities.AppStatisticsModel
import ir.tapsell.firstdemo.entities.AppType
import ir.tapsell.firstdemo.services.ApplicationStatService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class ApplicationStatController {

    @Autowired
    lateinit var appStatService: ApplicationStatService

//    var logger = LoggerFactory.getLogger(ApplicationStatController::class.java)

    @GetMapping("/apps")
    fun getAllApps(): List<AppStatistics> = appStatService.getAllApps()

    @PostMapping("/apps")
    fun addAppStatus(@RequestBody appStatistics: AppStatistics) {
        appStatService.addAppStats(appStatistics)
    }

    @GetMapping("apps/getStats")
    fun getStats(@RequestParam("start") startDate: Long,
                 @RequestParam("end") endDate: Long,
                 @RequestParam("type") type: AppType) : List<AppStatisticsModel> {
        return appStatService.getStats(Date(startDate), Date(endDate), type)
    }
}