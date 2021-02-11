package com.loos.fahstats.entity;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class Score {

    public long Score;
    public OffsetDateTime Date;

    public Score(long score, OffsetDateTime date) {
        Score = score;
        Date = date;
    }

    public Score(){

    }

    public long getScore() {
        return Score;
    }

    public OffsetDateTime getTime() {
        return Date;
    }

    public String getDateText(){
        return Date.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
