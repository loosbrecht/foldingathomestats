package com.loos.fahstats.repo;

import com.loos.fahstats.entity.ScoreList;
import com.loos.fahstats.entity.Totals;

public interface UserStatsRepo {

    Totals GetTotals();

    ScoreList AllData();

}
