package ru.netology.statistic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TodosTest {
    Todos todos = new Todos();
    SimpleTask simpleTask1 = new SimpleTask(5, "Позвонить родителям");
    SimpleTask simpleTask2 = new SimpleTask(4, "Позвонить в посольство");
    SimpleTask simpleTask3 = new SimpleTask(3, "Позвонить в военкомат");


    String[] subtasks1 = {"Молоко", "Яйца", "Хлеб", "Булочки", "Батон"};
    Epic epic1 = new Epic(55, subtasks1);
    String[] subtasks2 = {"Огурцы", "Помидоры", "Перец", "Лук", "Морковь"};
    Epic epic2 = new Epic(54, subtasks2);
    String[] subtasks3 = {"Сливки", "Мука", "Торт", "Сметана"};
    Epic epic3 = new Epic(52, subtasks3);
    Meeting meeting1 = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );
    Meeting meeting2 = new Meeting(
            554,
            "Обновление 5й версии",
            "Приложение Тинькоф",
            "В понедельник утром"
    );
    Meeting meeting3 = new Meeting(
            553,
            "Выкатка 2й версии приложения",
            "Приложение Госуслуги",
            "В пятницу утром"
    );

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(simpleTask3);
        todos.add(epic1);
        todos.add(epic2);
        todos.add(epic3);
        todos.add(meeting1);
        todos.add(meeting2);
        todos.add(meeting3);

        Task[] expected = {simpleTask1, simpleTask2, simpleTask3, epic1, epic2, epic3, meeting1, meeting2, meeting3};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTaskWhenAllTasks() {
        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(simpleTask3);
        todos.add(epic1);
        todos.add(epic2);
        todos.add(epic3);
        todos.add(meeting1);
        todos.add(meeting2);
        todos.add(meeting3);

        Task[] expected = {epic2};
        Task[] actual = todos.search("Лук");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTaskWhenOneTask() {
        todos.add(simpleTask1);

        Task[] expected = {simpleTask1};
        Task[] actual = todos.search("Позвонить");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTaskWhenNoTasks() {

        Task[] expected = {};
        Task[] actual = todos.search("Позвонить");
        Assertions.assertArrayEquals(expected, actual);
    }
}

