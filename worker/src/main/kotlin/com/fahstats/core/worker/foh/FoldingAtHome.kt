package com.fahstats.core.worker.foh

import com.fahstats.core.entity.Score
import com.fahstats.core.entity.User
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import java.net.URI
import java.time.LocalDateTime

const val foldingAtHomeRoot = "https://api.foldingathome.org" ///uid/%s/totals?team=%s"


@Component
class FoldingAtHome() {
    val webClient: WebClient = WebClient.create()

    fun fetchLatestScoreForUser(user: User): Score? {
        val result = webClient.get().uri(createUri(user)).retrieve().bodyToMono(Response::class.java).block()
        return result?.let { Score(it.score, LocalDateTime.now()) }

    }

    private fun createUri(user: User): URI {
        return URI.create("$foldingAtHomeRoot/uid/${user.id}/totals?team=${user.team.id}")
    }
}

data class Response(var name: String, var score: Long, var wus: Int) {
    constructor() :this("",0L,0)
}
