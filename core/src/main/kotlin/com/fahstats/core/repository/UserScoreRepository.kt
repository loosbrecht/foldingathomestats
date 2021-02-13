package com.fahstats.core.repository

import com.fahstats.core.entity.Score
import com.fahstats.core.entity.User

interface UserScoreRepository {
    fun CreateScore(user: User, score: Score)
    fun GetAllScoresForUser(user: User): List<Score>
    fun GetDailyTotal(user: User):Long
    fun GetMonthlyTotal(user: User): Long
    fun GetYearlyTotal(user: User):Long
    fun GetTotal(user: User):Long
}