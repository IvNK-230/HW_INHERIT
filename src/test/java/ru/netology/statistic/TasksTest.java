package ru.netology.statistic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void shouldFindQueryInTitleSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(6, "Позвонить родителям");
        boolean expected = true;
        boolean actual = simpleTask.matches("Позвонить родителям");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindQueryInTitleSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(7, "Позвонить родителям");
        boolean expected = false;
        boolean actual = simpleTask.matches("Набрать корешу");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInMeetingForTopic() {
        Meeting meeting = new Meeting(
                442,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean expected = true;
        boolean actual = meeting.matches("Выкатка 3й версии приложения");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInMeetingForProject() {
        Meeting meeting = new Meeting(
                443,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean expected = true;
        boolean actual = meeting.matches("Приложение НетоБанка");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInMeetingForStart() {
                Meeting meeting = new Meeting(
                444,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean expected = true;
        boolean actual = meeting.matches("Во вторник после обеда");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldNotFindQueryInMeetingForTopic() {
        Meeting meeting = new Meeting(
                445,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean expected = false;
        boolean actual = meeting.matches("Выкатка 2й версии приложения");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldNotFindQueryInMeetingForProject() {
        Meeting meeting = new Meeting(
                446,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean expected = false;
        boolean actual = meeting.matches("Приложение Альфа-банка");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindQueryInMeetingForStart() {
        Meeting meeting = new Meeting(
                447,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean expected = false;
        boolean actual = meeting.matches("Во вторник до обеда");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldFindQueryInEpic() {
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("Яйца");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldNotFindQueryInEpic() {
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        boolean expected = false;
        boolean actual = epic.matches("Курица");
        Assertions.assertEquals(expected, actual);
    }
}

