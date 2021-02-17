package com.fahstats.worker.foh

import com.fahstats.core.repository.UserScoreCommandRepository
import com.fahstats.core.worker.observer.Observer

class AddTotals(val commandRepo: UserScoreCommandRepository) : Observer<NewAndOldScore> {
    override fun update(t: NewAndOldScore) {
        commandRepo.AddToAllTotals(t.user, t.newScore.score - t.oldScore.score)
    }
}