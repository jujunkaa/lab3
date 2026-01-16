
import java.util.LinkedList;

class HashTable <K, V> {

    private static class Entry<K, V> {
        private final K key;
        private V value;
        
        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey(){
            return key;
        }

        public V getValue(){
            return value;
        }

        public void setValue(V value){
            this.value = value;
        }

    }

    private LinkedList<Entry<K,V>>[] table;
    private int size;

    public HashTable(int capacity) {
        table = new LinkedList[capacity];
        size = 0;
    }

    private int hash(K key){
        return Math.abs(
            key.hashCode()
        ) % table.length;
    }

    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<Entry<K, V>>();
        }
        for (Entry<K, V> entry: table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        table[index].add(new Entry<K, V>(key, value));
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        if (table[index] == null) {return null;}

        for (Entry<K, V> entry: table[index]) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public void remove(K key){
        int index = hash(key);
        if (table[index] == null) {return;}

        Entry<K, V> rem = null;
        for (Entry<K, V> entry: table[index]) {
            if (entry.getKey().equals(key)) {
                rem = entry;
                break;
            }
        }
        if (rem != null){
            table[index].remove(rem);
            size--;
        }
    }
    public int size(){
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}


public class Main {
    public static void main(String[] args) {
        HashTable<String, Integer> table = new HashTable<>(12);
        System.out.println(table.isEmpty());
        table.put("Julie", 19);
        table.put("Eleonora", 20);
        table.put("Dasha", 19);
        table.put("Masha", 27);
        System.out.println(table.isEmpty());
        System.out.println(table.size());

        System.out.println("Julie: " + table.get("Julie"));
        table.put("Julie", 20);
        System.out.println("Julie: " + table.get("Julie"));

        table.remove("Masha");
        System.out.println("Masha: " + table.get("Masha"));
        System.out.println(table.size());
    }
}