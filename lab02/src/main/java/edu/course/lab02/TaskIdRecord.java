package edu.course.lab02;
public record TaskIdRecord(String value) {
    public TaskIdRecord {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("ID задачи не может быть null или пустым");
        }
        value = value.trim();
    }
}