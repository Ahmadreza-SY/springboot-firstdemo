package ir.tapsell.firstdemo.controllers

import ir.tapsell.firstdemo.entities.AppStatistics
import ir.tapsell.firstdemo.services.ApplicationStatService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ApplicationStatController {

    @Autowired
    lateinit var appStatService: ApplicationStatService

//    var logger = LoggerFactory.getLogger(ApplicationStatController::class.java)

    @GetMapping("/apps")
    fun getAllApps(): List<AppStatistics> = appStatService.getAllApps()
}