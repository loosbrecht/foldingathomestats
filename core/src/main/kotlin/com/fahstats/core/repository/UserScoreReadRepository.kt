package com.fahstats.core.repository

import com.fahstats.core.entity.Score
import com.fahstats.core.entity.User
import org.springframework.stereotype.Repository

@Repository
interface UserScoreReadRepository {
    //Every user will only hold at a maxi
    fun GetScore(user: User): Score
    fun GetDailyTotal(user: User): Long
    fun GetMonthlyTotal(user: User): Long
    fun GetYearlyTotal(user: User): Long
    fun GetCompleteTotal(user: User): Long
}