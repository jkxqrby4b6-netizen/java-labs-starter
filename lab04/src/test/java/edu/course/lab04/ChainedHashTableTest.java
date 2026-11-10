package edu.course.lab04;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class ChainedHashTableTest {

    @Test
    void shouldPutAndGetValue() {
        ChainedHashTable table = new ChainedHashTable(10);
        ProjectTask task = new ProjectTask("1", "Задача 1", 5);
        table.put(task, "Описание 1");
        assertEquals("Описание 1", table.get(task));
        assertEquals(1, table.size());
    }

    @Test
    void shouldReplaceValueOnDuplicateKey() {
        ChainedHashTable table = new ChainedHashTable(10);
        ProjectTask task1 = new ProjectTask("1", "Задача 1", 5);
        ProjectTask task2 = new ProjectTask("1", "Другое название", 10);
        table.put(task1, "Старое описание");
        table.put(task2, "Новое описание");
        assertEquals(1, table.size());
        assertEquals("Новое описание", table.get(task1));
    }

    @Test
    void shouldHandleCollision() {
        ChainedHashTable table = new ChainedHashTable(1);
        ProjectTask task1 = new ProjectTask("1", "Задача 1", 5);
        ProjectTask task2 = new ProjectTask("2", "Задача 2", 5);
        table.put(task1, "Значение 1");
        table.put(task2, "Значение 2");
        assertEquals(2, table.size());
        assertEquals("Значение 1", table.get(task1));
        assertEquals("Значение 2", table.get(task2));
    }

    @Test
    void shouldRemoveValue() {
        ChainedHashTable table = new ChainedHashTable(10);
        ProjectTask task = new ProjectTask("1", "Задача 1", 5);
        table.put(task, "Описание 1");
        assertTrue(table.remove(task));
        assertNull(table.get(task));
        assertEquals(0, table.size());
    }
}