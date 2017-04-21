package net.lermex.inaction.model.entity;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Random;

@Component
public class Statistics {
    private ArrayList<Integer> statisticsList;

    public Statistics() {}

    public ArrayList<Integer> getStatisticsList() {
        return statisticsList;
    }

    public void setStatisticsList (ArrayList<Integer> statisticList) {
        this.statisticsList = statisticList;
    }

    public void generateStatistics() {
        this.statisticsList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            statisticsList.add(new Random().nextInt(500));
        }
    }
}
