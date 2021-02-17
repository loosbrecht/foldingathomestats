package com.fahstats.worker.foh

import com.fahstats.core.entity.Score
import com.fahstats.core.entity.User

data class NewAndOldScore(val user: User, val newScore: Score, val oldScore: Score)
