package com.fahstats.core.repo;

import com.fahstats.core.entity.ScoreList;
import com.fahstats.core.entity.Totals;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

@Repository
public class UserStatsRestRepo implements UserStatsRepo {

    private WebClient webClient;

    public UserStatsRestRepo() {
        webClient = WebClient.create();
    }

    @Override
    public Totals GetTotals() {
        return webClient.get()
                .uri("https://fah-stats.herokuapp.com/api/total")
                .retrieve()
                .bodyToMono(Totals.class).block();

    }

    @Override
    public ScoreList AllData() {
        return webClient.get()
                .uri("https://fah-stats.herokuapp.com/api/stats/scores")
                .retrieve()
                .bodyToMono(ScoreList.class).block();

    }
}
