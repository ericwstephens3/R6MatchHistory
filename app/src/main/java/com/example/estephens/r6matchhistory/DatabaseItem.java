package com.example.estephens.r6matchhistory;

import java.util.ArrayList;
import java.util.Objects;

public class DatabaseItem {
    private int id;
    private String date;
    private String mapName;
    private ArrayList<String> attackOperators = new ArrayList<>();
    private ArrayList<String> defenseOperators = new ArrayList<>();
    private String score;
    private boolean winLoss;
    private String comments;
    private String playerScore;

    public DatabaseItem (){}

    public void setId(int id){
        this.id = id;
    }

    public void setDate(String date){
        this.date = date;
    }

    public void setMapName(String mapName){
        this.mapName = mapName;
    }

    public void setAttackOperators(String attackOperators){
        String[] ops = attackOperators.split(" ");

        for(String op : ops){
            this.attackOperators.add(op);
        }
    }

    public void setDefenseOperators(String defenseOperators){
        String[] ops = defenseOperators.split(" ");

        for(String op : ops){
            this.defenseOperators.add(op);
        }
    }

    public void setScore(String score){
        this.score = score;
    }

    public void setwinLoss(boolean winLoss){
        this.winLoss = winLoss;
    }

    public void setPlayerScore(String score){
        this.playerScore = score;
    }

    public void setComments(String comments){
        this.comments = comments;
    }

    public int getId(){
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getMapName() {
        return mapName;
    }

    public ArrayList<String> getAttackOperators() {
        return attackOperators;
    }

    public ArrayList<String> getDefenseOperators() {
        return defenseOperators;
    }

    public String getScore() {
        return score;
    }

    public boolean getWinLoss() {
        return winLoss;
    }

    public String getComments() {
        return comments;
    }

    public String getPlayerScore(){
        return playerScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DatabaseItem that = (DatabaseItem) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "DatabaseItem{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", mapName='" + mapName + '\'' +
                ", attackOperators=" + attackOperators +
                ", defenseOperators=" + defenseOperators +
                ", score='" + score + '\'' +
                ", winLoss=" + winLoss +
                ", comments='" + comments + '\'' +
                '}';
    }
}
