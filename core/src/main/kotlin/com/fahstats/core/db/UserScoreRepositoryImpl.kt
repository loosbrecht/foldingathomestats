package com.fahstats.core.db

import com.fahstats.core.entity.Score
import com.fahstats.core.entity.User
import com.fahstats.core.repository.UserScoreRepository

class UserScoreRepositoryImpl : UserScoreRepository {
    override fun CreateScore(user: User, score: Score) {
        TODO("Not yet implemented")
    }

    override fun GetAllScoresForUser(user: User): List<Score> {
        TODO("Not yet implemented")
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

    override fun GetTotal(user: User): Long {
        TODO("Not yet implemented")
    }
}