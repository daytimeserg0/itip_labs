import java.util.Arrays;
import java.util.LinkedList;

public class HashTable<K, V> {
    private static final int TABLE_SIZE = 16;
    private LinkedList<Entry<K, V>>[] table;

    public HashTable() {
        table = new LinkedList[TABLE_SIZE];
    }


    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }


    public void put(K key, V value) {
        int index = key.hashCode() % TABLE_SIZE;

        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }


        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }


        table[index].add(new Entry<>(key, value));
        System.out.println(Arrays.toString(table));
    }


    public V get(K key) {
        int index = key.hashCode() % TABLE_SIZE;

        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
        }

        return (V) ("Работник с ключом " + key + " не найден");
    }


    public void remove(K key) {
        int index = key.hashCode() % TABLE_SIZE;

        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.key.equals(key)) {
                    table[index].remove(entry);
                    System.out.println("Объект с ключом " + key + " удален");
                    return;
                }
            }
        }
    }

    public int size() {
        int size = 0;
        for (LinkedList<Entry<K, V>> bucket : table) {
            if (bucket != null) {
                size += bucket.size();
            }
        }
        return size;
    }


    public boolean isEmpty() {
        for (LinkedList<Entry<K, V>> bucket : table) {
            if (bucket != null && !bucket.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        HashTable<String, String > myTable = new HashTable<>();
        myTable.put("Aa", "banana");
        myTable.put("BB", "apple");
        myTable.put("3", "pineapple");
        myTable.put("4", "cherry");

        String key1 = "dino";
        String key2 = "BB";
        System.out.println(key1.hashCode() % 6);
        System.out.println(key2.hashCode());

        System.out.println(myTable.get("Aa"));
        System.out.println(myTable.get("BB"));
        System.out.println(myTable.get("3"));
        System.out.println(myTable.get("5"));
        System.out.println("Размер таблицы: " + myTable.size());
        myTable.remove("4");
        System.out.println("Размер таблицы: " + myTable.size());
        System.out.println("Пуста ли таблица: " + myTable.isEmpty());
    }
}