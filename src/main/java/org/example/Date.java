package org.example;

/**
 * @author Danil on 22.11.2022
 * @project CSSTableGenerator
 */
public class Date {
    private int day, month, year;

    Date(int day, int month, int year){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return "<td>" + day+"." + (month<10?"0"+month:month) + "." + year + "</td>";
    }
}
