package com.fahstats.core.repository

import com.fahstats.core.entity.Score
import com.fahstats.core.entity.User
import org.springframework.stereotype.Repository

@Repository
interface UserScoreCommandRepository {
    //Keep the score so that we have the latest total
    fun CreateOrUpdateScore(user: User, score: Score)

    //Add this to the daily score
    fun AddToDailyScore(user: User, score: Score)

    //Add to every total that we are keeping
    fun AddToAllTotals(user: User, addScore: Long)

}