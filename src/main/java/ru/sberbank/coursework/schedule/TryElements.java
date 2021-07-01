package ru.sberbank.coursework.schedule;

import ru.sberbank.coursework.schedule.model.Schedule;

import java.math.BigDecimal;

public class TryElements {
    public static void main(String[] args){

        Schedule schedule = new Schedule(
                new BigDecimal(1000000),
                30,
                new BigDecimal(7),
                true
        );
        schedule.getCreditAmount();

        System.out.println(schedule);
    }
}
