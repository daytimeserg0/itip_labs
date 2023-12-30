import java.util.LinkedList;

public class EmployeeHashTable<K, V> {
    private static final int TABLE_SIZE = 16;
    private LinkedList<Entry<K, V>>[] table;

    public EmployeeHashTable() {
        table = new LinkedList[TABLE_SIZE];
    }


    private static class Entry<K, V> {
        K key;
        Employee employee;

        Entry(K key, V employee) {
            this.key = key;
            this.employee = (Employee) employee;
        }
    }


    public void put(K key, V employee) {
        int index = key.hashCode() % TABLE_SIZE;

        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }


        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                entry.employee = (Employee) employee;
                return;
            }
        }

        table[index].add(new Entry<>(key, employee));
    }


    public String get(K key) {
        int index = key.hashCode() % TABLE_SIZE;

        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.key.equals(key)) {
                    String new_str = "Имя работника: " + entry.employee.getName() +
                            " | Должность работника: " + entry.employee.getPosition() +
                            " | Зароботная плата: " + entry.employee.getSalary() + "р.";
                    return new_str;
                }
            }
        }

        return "Работник с ключом " + key + " не найден"; // Ключ не найден
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

    public static class Employee {
        private String name;
        private String position;
        private int salary;


        public Employee(String name, String position, int salary) {
            this.name = name;
            this.position = position;
            this.salary = salary;
        }
        public String getName() {
            return name;
        }

        public String getPosition() {
            return position;
        }

        public int getSalary() {
            return salary;
        }
    }


    public static void main(String[] args) {
        EmployeeHashTable<Integer, Employee> myTable = new EmployeeHashTable<>();
        myTable.put(1, new Employee("Егор Васильевич", "офисный менеджер", 65000));
        myTable.put(2, new Employee("Олег Витальевич", "начальник отдела продаж", 93000));
        myTable.put(3, new Employee("Сергей Викторович", "директор компании", 1000000));
        myTable.put(4, new Employee("Артем Владимирович", "руководитель отдела разработки", 100000));
        myTable.put(5, new Employee("Евгения Владиславовна", "главный секретарь", 60000));

        System.out.println(myTable.get(1));
        System.out.println(myTable.get(2));
        System.out.println(myTable.get(3));
        System.out.println(myTable.get(4));
        System.out.println(myTable.get(5));
        System.out.println(myTable.get(6));
        System.out.println("Размер таблицы: " + myTable.size());
        myTable.remove(1);
        System.out.println("Размер таблицы: " + myTable.size());
        System.out.println("Пуста ли таблица: " + myTable.isEmpty());

    }
}