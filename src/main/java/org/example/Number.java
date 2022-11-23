package org.example;

/**
 * @author Danil on 22.11.2022
 * @project CSSTableGenerator
 */
public class Number {
    private int number;

    Number(int number){
        this.number = number;
    }

    @Override
    public String toString() {
        return "<td>" + number + "</td>";
    }
}
