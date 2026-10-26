package edu.course.lab02;

import java.util.Objects;

public final class TaskId {
    private final String value;

    public TaskId(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("ID задачи не может быть null или пустым");
        }
        this.value = value.trim();
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskId taskId = (TaskId) o;
        return Objects.equals(value, taskId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}