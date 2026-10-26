package edu.course.lab02;

public class ProjectTask {
    private String id;
    private String title;
    private TaskStatus status;
    private int estimatedHours;
    private int actualHours;
    public ProjectTask(String id, String title, int estimatedHours) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID не может быть null или пустым");
        }
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Название не может быть null или пустым");
        }
        if (estimatedHours < 0) {
            throw new IllegalArgumentException("Оценка трудоемкости не может быть отрицательной");
        }

        this.id = id.trim();
        this.title = title.trim();
        this.estimatedHours = estimatedHours;
        this.status = TaskStatus.NEW; 
        this.actualHours = 0;         
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public TaskStatus getStatus() { return status; }
    public int getEstimatedHours() { return estimatedHours; }
    public int getActualHours() { return actualHours; }
    public void changeStatus(TaskStatus newStatus) {
        if (newStatus == null) {
            throw new IllegalArgumentException("Статус не может быть null");
        }
        this.status = newStatus;
    }
    public boolean isCompleted() {
        return this.status == TaskStatus.DONE;
    }
    public void increaseEstimate(int hours) {
        if (hours <= 0) {
            throw new IllegalArgumentException("Количество часов для добавления должно быть положительным");
        }
        this.estimatedHours += hours;
    }
    public void logWork(int hours) {
        if (hours <= 0) {
            throw new IllegalArgumentException("Количество часов работы должно быть положительным");
        }
        this.actualHours += hours;
    }
}