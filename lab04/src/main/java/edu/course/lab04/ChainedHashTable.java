package edu.course.lab04;
import java.util.LinkedList;
public class ChainedHashTable {
    private static class Entry {
        ProjectTask key;
        String value;

        Entry(ProjectTask key, String value) {
            this.key = key;
            this.value = value;
        }
    }
    private final LinkedList<Entry>[] buckets;
    private int size;
    @SuppressWarnings("unchecked")
    public ChainedHashTable(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Емкость должна быть больше нуля");
        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
        size = 0;
    }
    public void put(ProjectTask key, String value) {
        if (key == null) throw new IllegalArgumentException("Ключ не может быть null");
        int index = Math.abs(key.hashCode()) % buckets.length;
        LinkedList<Entry> bucket = buckets[index];

        for (Entry entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        bucket.add(new Entry(key, value));
        size++;
    }
    public String get(ProjectTask key) {
        if (key == null) return null;
        int index = Math.abs(key.hashCode()) % buckets.length;
        LinkedList<Entry> bucket = buckets[index];
        for (Entry entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }
    public boolean remove(ProjectTask key) {
        if (key == null) return false;
        int index = Math.abs(key.hashCode()) % buckets.length;
        LinkedList<Entry> bucket = buckets[index];
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i).key.equals(key)) {
                bucket.remove(i);
                size--;
                return true;
            }
        }
        return false;
    }
    public int size() {
        return size;
    }
}