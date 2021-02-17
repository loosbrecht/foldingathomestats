package com.fahstats.worker.foh

import com.fahstats.core.repository.UserScoreCommandRepository
import com.fahstats.core.worker.observer.Observer

class UpdateScore(val commandRepo: UserScoreCommandRepository) : Observer<NewAndOldScore> {
    override fun update(t: NewAndOldScore) {
        commandRepo.CreateOrUpdateScore(t.user, t.newScore)
    }
}