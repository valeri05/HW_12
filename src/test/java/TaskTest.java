import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test

    public void taskIdCodeSearch() {

        Task task = new Task(1);

        int expected = 1;
        int actual = task.getId();

        Assertions.assertEquals(expected,actual);
    }

    @Test

    public void searchSimpleTask() {

        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String expected = "Позвонить родителям";
        String actual = simpleTask.getTitle();

        Assertions.assertEquals(expected,actual);
    }

    @Test

    public void searchEpic() {

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        String[] expected = {"Молоко", "Яйца", "Хлеб"};
        String[] actual = epic.getSubtasks();

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test

    public void searchMeetingTopic() {

        Meeting meeting = new Meeting(
                222,
                "Бета тестирование приложения НетоБанк",
                "Приложение НетоБанк",
                "Во вторник после обеда"
        );

        String expected = "Бета тестирование приложения НетоБанк";
        String actual = meeting.getTopic();

        Assertions.assertEquals(expected,actual);
    }

    @Test

    public void searchMeetingProject() {

        Meeting meeting = new Meeting(
                222,
                "Бета тестирование приложения НетоБанк",
                "Приложение НетоБанк",
                "Во вторник после обеда"
        );

        String expected = "Приложение НетоБанк";
        String actual = meeting.getProject();

        Assertions.assertEquals(expected,actual);
    }

    @Test

    public void searchMeetingStart() {

        Meeting meeting = new Meeting(
                222,
                "Бета тестирование приложения НетоБанк",
                "Приложение НетоБанк",
                "Во вторник после обеда"
        );

        String expected = "Во вторник после обеда";
        String actual = meeting.getStart();

        Assertions.assertEquals(expected,actual);
    }

    @Test

    public void simpleTaskMatchesTestingFalse() {

       Task simpleTask = new SimpleTask(5, "Позвонить родителям");

       boolean expected = false;
       boolean actual = simpleTask.matches("Банк");

       Assertions.assertEquals(expected, actual);
    }

    @Test

    public void simpleTaskMatchesTestingTrue() {

        Task simpleTask = new SimpleTask(5, "Позвонить менеджеру в Банк");

        boolean expected = true;
        boolean actual = simpleTask.matches("Банк");

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void epicMatchesTestingFalse() {

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Task epic = new Epic(55, subtasks);

        boolean expected = false;
        boolean actual = epic.matches("Банк");

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void epicMatchesTestingTrue() {

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Task epic = new Epic(55, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("Хлеб");

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void meetingMatchesTestingFalse() {

        Task meeting = new Meeting(
                222,
                "Бета тестирование приложения НетоБанк",
                "Приложение НетоБанк",
                "Во вторник после обеда"
        );

        boolean expected = false;
        boolean actual = meeting.matches("Хлеб");

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void meetingTaskMatchesTestingTrue() {

        Task meeting = new Meeting(
                222,
                "Бета тестирование приложения НетоБанк",
                "Приложение НетоБанк",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches("Банк");

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void matchesTestingFalse() {

        Task task = new Task(1);

        boolean expected = false;
        boolean actual = task.matches("Банк");

        Assertions.assertEquals(expected, actual);
    }
}
