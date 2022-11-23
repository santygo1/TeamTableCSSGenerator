package org.example;

import java.util.Objects;

/**
 * @author Danil on 22.11.2022
 * @project CSSTableGenerator
 */
public class Team {

    private String imageName;

    Team(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public String toString() {
        return "<td>" + "\n"
                + "\t\t\t\t\t\t"+"\t" + "<img class=\"team\" src=\"assets/img/teams/"+ imageName +"\">" +"\n"
                + "\t\t\t\t\t\t"+"\t" + imageName.replace(".png", "") + "\n"
                + "\t\t\t\t\t\t"+"</td>";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return imageName.equals(team.imageName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imageName);
    }
}
