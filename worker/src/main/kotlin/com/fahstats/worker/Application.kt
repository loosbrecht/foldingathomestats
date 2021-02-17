package com.fahstats.worker

import com.fahstats.core.entity.Team
import com.fahstats.core.entity.User
import com.fahstats.core.worker.observer.Observer
import com.fahstats.worker.foh.FoldingAtHome
import com.fahstats.worker.foh.NewAndOldScore
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan


@SpringBootApplication
@ComponentScan(value = ["com.fahstats"])
class Application(private val foh: FoldingAtHome) : CommandLineRunner {

    @Override
    override fun run(args: Array<String>) {
        println("Extract data at folding at home")
        val user = User("Arallyd", "73107961", Team("CureCoin", "224497"))

        foh.addObserver(LogNewAndOld())
        foh.fetchAndUpdateData(user)

    }
}

class LogNewAndOld : Observer<NewAndOldScore> {
    override fun update(t: NewAndOldScore) {
        println("${t.user.name} ${t.oldScore.score} ${t.newScore.score}")
    }

}


fun main(args: Array<String>) {
    var app = runApplication<Application>(*args)
    app.close()
}

