package org.example;

/**
 * @author Danil on 22.11.2022
 * @project CSSTableGenerator
 */
public class Score {

    private int firstTeamScore, secondTeamScore;

    Score(int firstTeamScore, int secondTeamScore){
        this.firstTeamScore = firstTeamScore;
        this.secondTeamScore = secondTeamScore;
    }

    @Override
    public String toString() {
        return "<td><span class=\"" + (firstTeamScore<secondTeamScore?"lost":"won") + "\">" + firstTeamScore + "</span></td>" + "\n"
                +"\t\t\t\t\t\t"+"<td><span class=\"" + (firstTeamScore>secondTeamScore?"lost":"won") + "\">" + secondTeamScore + "</span></td>" + "\n";
    }
}
