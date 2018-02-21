package ir.tapsell.firstdemo.services

import ir.tapsell.firstdemo.entities.AppStatistics
import ir.tapsell.firstdemo.repositories.ApplicationStatRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ApplicationStatService {

    @Autowired
    lateinit var appStatRepo: ApplicationStatRepository

//    var logger = LoggerFactory.getLogger(ApplicationStatService::class.java)

    fun getAllApps(): List<AppStatistics> = appStatRepo.findAll()
}