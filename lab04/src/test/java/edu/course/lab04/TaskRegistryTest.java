package edu.course.lab04;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class TaskRegistryTest {

    @Test
    void shouldAddAndGetDescription() {
        TaskRegistry registry = new TaskRegistry();
        ProjectTask task1 = new ProjectTask("1", "Сделать задачу", 10);
        registry.addOrReplace(task1, "Важная задача");
        assertEquals("Важная задача", registry.getDescription(task1));
    }
    @Test
    void shouldFindTaskByDifferentInstanceWithSameId() {
        TaskRegistry registry = new TaskRegistry();
        ProjectTask task1 = new ProjectTask("1", "Оригинал", 10);
        registry.addOrReplace(task1, "Описание");
        ProjectTask task2 = new ProjectTask("1", "Другое название", 20);
        assertEquals("Описание", registry.getDescription(task2));
    }

    @Test
    void shouldNotFindTaskWithDifferentId() {
        TaskRegistry registry = new TaskRegistry();
        ProjectTask task1 = new ProjectTask("1", "Задача 1", 5);
        ProjectTask task2 = new ProjectTask("2", "Задача 2", 5);
        registry.addOrReplace(task1, "Описание 1");
        assertNull(registry.getDescription(task2));
    }

    @Test
    void shouldContainTaskByDifferentInstanceWithSameId() {
        TaskRegistry registry = new TaskRegistry();
        ProjectTask task1 = new ProjectTask("1", "Задача", 5);
        registry.addOrReplace(task1, "Описание");
        ProjectTask task2 = new ProjectTask("1", "Другая", 10);
        assertTrue(registry.containsTask(task2));
    }

    @Test
    void repeatedAddShouldReplaceValueAndNotIncreaseSize() {
        TaskRegistry registry = new TaskRegistry();
        ProjectTask task1 = new ProjectTask("1", "Оригинал", 10);
        registry.addOrReplace(task1, "Старое описание");
        registry.addOrReplace(new ProjectTask("1", "Другое", 5), "Новое описание");
        assertEquals(1, registry.size());
        assertEquals("Новое описание", registry.getDescription(task1));
    }

    @Test
    void collisionShouldNotMixKeys() {
        Map<CollisionKey, String> map = new HashMap<>();
        CollisionKey key1 = new CollisionKey("1");
        CollisionKey key2 = new CollisionKey("2");
        map.put(key1, "Значение 1");
        map.put(key2, "Значение 2");
        assertEquals("Значение 1", map.get(key1));
        assertEquals("Значение 2", map.get(key2));
        assertEquals(2, map.size());
    }
    @Test
    void equalsShouldReturnFalseForNullAndOtherType() {
        ProjectTask task = new ProjectTask("1", "Задача", 5);
        assertFalse(task.equals(null));
        assertFalse(task.equals("Строка"));
    }

    @Test
    void mutableKeyShouldBreakSearchAfterModification() {
        Map<MutableKey, String> map = new HashMap<>();
        MutableKey key = new MutableKey("1");
        map.put(key, "Секретное значение");
        assertEquals("Секретное значение", map.get(key));
        key.id = "2";
        assertNull(map.get(key));
    }
}
class CollisionKey {
    private final String id;
    public CollisionKey(String id) {
        this.id = id;
    }
    @Override 
    public int hashCode() { 
        return 67; 
    }
    @Override 
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        return id.equals(((CollisionKey) object).id);
    }
}
class MutableKey {
    public String id;
    public MutableKey(String id) {
        this.id = id;
    }
    @Override 
    public int hashCode() { 
        return id.hashCode(); 
    }
    @Override 
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        return id.equals(((MutableKey) object).id);
    }
}