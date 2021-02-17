package com.fahstats.core.db

import com.fahstats.core.entity.Score
import com.fahstats.core.entity.User
import com.fahstats.core.repository.UserScoreReadRepository
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
open class UserScoreReadRepositoryImpl : UserScoreReadRepository {
    override fun GetScore(user: User): Score {
        return Score(20, LocalDateTime.now())
    }

    override fun GetDailyTotal(user: User): Long {
        TODO("Not yet implemented")
    }

    override fun GetMonthlyTotal(user: User): Long {
        TODO("Not yet implemented")
    }

    override fun GetYearlyTotal(user: User): Long {
        TODO("Not yet implemented")
    }

    override fun GetCompleteTotal(user: User): Long {
        TODO("Not yet implemented")
    }

}
