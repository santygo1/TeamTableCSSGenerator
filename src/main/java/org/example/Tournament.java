package org.example;

/**
 * @author Danil on 22.11.2022
 * @project CSSTableGenerator
 */
public class Tournament {

    private String imageName;

    Tournament(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public String toString() {
        return "<td>\n" + "\t\t\t\t\t\t" + "\t<img class=\"tournament\" src=\"assets/img/tournaments/" + imageName + "\">\n" + "\t\t\t\t\t\t"
                + "</td>";
    }
}
