package com.loos.fahstats.entity;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ScoreList {

    public List<Score> data;

    public ScoreList() {
    }

    public List<Score> getListWithEmptyValues() {
        List<Score> scores = new ArrayList<>();
        scores.add(data.get(0));
        var previous = data.get(0).Date;
        for (int i = 1; i < data.size(); i++) {
            Score currentScore = data.get(i);
            long days = Duration.between(previous, currentScore.Date).toDays();
            if (days == 1) {
                previous = currentScore.Date;
                scores.add(currentScore);
            } else {
                for (int j = 0; j < days ; j++) {
                    previous = previous.plusDays(1);
                    scores.add(new Score(0, previous));
                }
            }
        }
        return scores;
    }
}
