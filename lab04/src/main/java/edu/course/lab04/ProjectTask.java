package edu.course.lab04;
import java.util.Objects;

public class ProjectTask {
    private final String id;
    private final String title;
    private final int hours;
    public ProjectTask(String id, String title, int hours) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID не может быть пустым");
        }
        if (title == null) {
            throw new IllegalArgumentException("Название не может быть пустым");
        }
        if (hours < 0) {
            throw new IllegalArgumentException("Число часов не может быть отрицательными");
        }
        this.id = id.trim();
        this.title = title;
        this.hours = hours;
    }
    public String getId(){return id;}
    public String getTitle(){return title;}
    public int getHours(){return hours;}
    @Override
    public boolean equals(Object object) {
        if (this==object) return true;
        if (object==null || getClass()!=object.getClass()) return false;
        ProjectTask different = (ProjectTask) object;
        return Objects.equals(id, different.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}