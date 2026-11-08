package edu.course.lab04;
import java.util.HashMap;
import java.util.Map;

public class TaskRegistry {
    private final Map<ProjectTask, String> tasks = new HashMap<>();
    public void addTask (ProjectTask task, String description) {
        if (task == null || description == null) {
            throw new IllegalArgumentException("Задача и описание не могут быть пустыми");
        }
        tasks.put(task, description);
    }
    public String getDescription(ProjectTask task) {
        if (task == null) {
            throw new IllegalArgumentException("Задача не может быть null");
        }
        return tasks.get(task);
    }
    public boolean containsTask(ProjectTask task) {
        if (task == null) return false;
        return tasks.containsKey(task);
    }
    public int size() {
        return tasks.size();
    }
}