package com.fahstats.core.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;

@Entity
public class DailyStats {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotNull
    private OffsetDateTime time;
    @NotNull
    private String userID;
    @NotNull
    private String teamID;
    @NotNull
    private Long score;
    @NotNull
    private Long wu;

    public DailyStats() {
    }

    public DailyStats(Long id, @NotNull OffsetDateTime time, @NotNull String userID, @NotNull String teamID, @NotNull Long score, @NotNull Long wu) {
        this.id = id;
        this.time = time;
        this.userID = userID;
        this.teamID = teamID;
        this.score = score;
        this.wu = wu;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTime(OffsetDateTime time) {
        this.time = time;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setTeamID(String teamID) {
        this.teamID = teamID;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public void setWu(Long wu) {
        this.wu = wu;
    }

    public Long getId() {
        return id;
    }

    public OffsetDateTime getTime() {
        return time;
    }

    public String getUserID() {
        return userID;
    }

    public String getTeamID() {
        return teamID;
    }

    public Long getScore() {
        return score;
    }

    public Long getWu() {
        return wu;
    }
}
