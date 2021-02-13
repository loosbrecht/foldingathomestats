package com.fahstats.core.worker

import com.fahstats.core.entity.Team
import com.fahstats.core.entity.User
import com.fahstats.core.worker.foh.FoldingAtHome
import org.springframework.boot.autoconfigure.SpringBootApplication

import org.springframework.boot.runApplication
@SpringBootApplication
class Application
fun main(args: Array<String>) {
  val response =  FoldingAtHome().fetchLatestScoreForUser(User("Arallyd","73107961", Team("CureCoin","224497")))
    println(response)
}