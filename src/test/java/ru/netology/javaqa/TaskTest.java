package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Test
    public void testSimpleTaskForTheCorrectQuery() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("родителям");

        Task[] expected = { simpleTask};
        Assertions.assertTrue(actual);
    }
    @Test
    public void testSimpleTaskForTheIncorrectQueryCapitalLetter() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Родителям");

        Task[] expected = { simpleTask};
        Assertions.assertFalse(actual);
    }

    @Test
    public void testSimpleTaskForTheIncorrectQuery() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("ролям");

        Task[] expected = { simpleTask};
        Assertions.assertFalse(actual);
    }
    @Test
    public void testEpicForTheCorrectQuery() {
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Яйца");

        Task[] expected = {epic};
        Assertions.assertTrue(actual);
    }
    @Test
    public void testEpicForTheIncorrectQueryUppercaseLetters() {
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("хлеб");

        Task[] expected = {epic};
        Assertions.assertFalse(actual);
    }

    @Test
    public void testEpicForTheIncorrectQuery() {
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("молока");

        Task[] expected = {epic};
        Assertions.assertFalse(actual);
    }
    @Test
    public void testMeetingForTheCorrectQuery() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("3й версии");

        Task[] expected = {meeting};
        Assertions.assertTrue(actual);
    }
    @Test
    public void testMeetingForTheIncorrectQueryUppercaseLetters() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("нетобанк");

        Task[] expected = {meeting};
        Assertions.assertFalse(actual);
    }


}