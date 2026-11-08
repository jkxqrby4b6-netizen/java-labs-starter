package edu.course.lab04;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskRegistryTest {
    @Test
    void shouldAddAndGetDescription() {
        TaskRegistry registry = new TaskRegistry();
        ProjectTask task = new ProjectTask("1", "задача", 1);
        registry.addTask(task, "без описания");
        assertEquals("без описания", registry.getDescription(task));
    }
    @Test
    void shouldFindTaskByDifferentInstanceWithSameId() {
        TaskRegistry registry = new TaskRegistry();
        ProjectTask taskN1 = new ProjectTask("2", "задача_1", 4);
        registry.addTask(taskN1, "описание");
        ProjectTask taskN2 = new ProjectTask("2", "задача_2", 2);
        String description = registry.getDescription(taskN2);
        assertEquals("описание", description, 
            "Реестр должен находить задачу по ID, даже если это другой объект");
    }
    @Test
    void shouldNotFindTaskWithDifferentId() {
        TaskRegistry registry = new TaskRegistry();
        ProjectTask task1 = new ProjectTask("10", "Задача 1", 5);
        ProjectTask task2 = new ProjectTask("11", "Задача 2", 5);
        registry.addTask(task1, "Описание 1");
        String description = registry.getDescription(task2);
        assertNull(description, "Для задачи с другим ID описание не должно находиться");
    }
    @Test
    void shouldContainTaskByDifferentInstanceWithSameId() {
        TaskRegistry registry = new TaskRegistry();
        ProjectTask task1 = new ProjectTask("20", "Задача", 5);
        registry.addTask(task1, "Описание");
        ProjectTask task2 = new ProjectTask("20", "Другая", 10);
        assertTrue(registry.containsTask(task2), "Реестр должен считать, что задача с таким ID уже есть");
    }

}