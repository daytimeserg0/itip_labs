public class Programm {
    public static void main(String[] args) {
        Table table = new Table("Стол", "Дерево", 115, false, "Круглый", 8, 6);
        Chair chair = new Chair("Стул", "Металл", 7, true, true, true, 89);
        Bed bed = new Bed("Кровать", "Ткань", 120, false, 2, "Красный", true);
        Bed bed2 = new Bed("Кровать", "Ткань", 120, false, 2, "Красный", true);

        table.displayInfo(1);
        System.out.println();
        chair.displayInfo(1);
        System.out.println();
        bed.displayInfo(1);
        System.out.println();
        System.out.println("Создано объектов (стол): " + Table.getObjectCount());
        System.out.println("Создано объектов (стул): " + Chair.getObjectCount());
        System.out.println("Создано объектов (кровать): " + Bed.getObjectCount());


        String word1 = "Ключ1";
        String word2 = "Ключ5";
        System.out.println(word1.hashCode() % 16);
        System.out.println(word2.hashCode() % 16);
    }
}
