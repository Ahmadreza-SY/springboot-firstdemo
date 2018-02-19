package ir.tapsell.firstdemo.repositories

import ir.tapsell.firstdemo.entities.AppStatistics
import org.springframework.data.mongodb.repository.MongoRepository

interface ApplicationStatRepository : MongoRepository<AppStatistics, String>