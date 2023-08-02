package ru.netology.statistic;

import java.util.Arrays;

public class Epic extends Task {
    protected String subtasks;

    public Epic(int id, String[] subtasks) {
        super(id);                                                  // вызов родительского конструктора
        this.subtasks = Arrays.toString(subtasks);
    }


    public String getSubtasks() {
        return subtasks;
    }

    @Override
    public boolean matches(String query) {
        for (int i = 0; i < subtasks.length(); i++) {
            if (subtasks.contains(query)) {
                return true;
            }
        }
        return false;
    }
}
