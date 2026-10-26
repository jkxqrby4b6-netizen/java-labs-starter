package edu.course.lab02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProjectTaskTest {

    @Test
    void shouldCreateValidTask() {
        ProjectTask task = new ProjectTask("TASK-1", "амамам", 10);
        assertEquals("TASK-1", task.getId());
        assertEquals(TaskStatus.NEW, task.getStatus());
        assertFalse(task.isCompleted());
    }

    @Test
    void shouldThrowExceptionWhenIdIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ProjectTask("  ", "Title", 5);
        });
    }

    @Test
    void shouldChangeStatusAndCheckCompletion() {
        ProjectTask task = new ProjectTask("TASK-2", "Тест", 5);
        task.changeStatus(TaskStatus.DONE);
        assertTrue(task.isCompleted());
    }
}