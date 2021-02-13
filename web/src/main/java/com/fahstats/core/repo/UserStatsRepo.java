package com.fahstats.core.repo;

import com.fahstats.core.entity.ScoreList;
import com.fahstats.core.entity.Totals;

public interface UserStatsRepo {

    Totals GetTotals();

    ScoreList AllData();

}
