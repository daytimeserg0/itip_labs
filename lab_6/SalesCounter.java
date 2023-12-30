import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SalesCounter {
    private ConcurrentHashMap<String, Integer> sales;

    public SalesCounter() {
        this.sales = new ConcurrentHashMap<>();
    }

    public void addSale(String product, int cost) {
        if (sales.containsKey(product)) {
            int currentCost = sales.get(product);
            sales.put(product, currentCost + cost);
        } else {
            sales.put(product, cost);
        }
    }

    public void displaySales() {
        if (sales.isEmpty()) {
            System.out.println("Проданных товаров не найдено");
        } else {
            System.out.println("Проданные товары:");
            for (Map.Entry<String, Integer> entry : sales.entrySet()) {
                String product = entry.getKey();
                int cost = entry.getValue();
                System.out.println(product + ": $" + cost);
            }
        }
    }

    public int getTotalSales() {
        int allCost = 0;
        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
            allCost += entry.getValue();
        }
        return allCost;
    }

    public String getMostPopularProduct() {
        int max = 0;
        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
            int cost = entry.getValue();
            if (cost > max) {
                max = cost;
            }
        }

        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
            int cost = entry.getValue();
            if (cost == max) {
                return "Самый прибыльный товар: " + entry.getKey() + ". Прибыль с продаж этого товара: $" + entry.getValue();
            }
        }
        return "Проданных товаров не найдено";
    }

    public static void main(String[] args) {
        SalesCounter allSales = new SalesCounter();

        // Добавление продаж
        allSales.addSale("Яблоко", 5);
        allSales.addSale("Банан", 8);
        allSales.addSale("Черешня", 3);
        allSales.addSale("Яблоко", 12);

        allSales.displaySales();
        System.out.println();

        System.out.println(allSales.getMostPopularProduct());
        System.out.println();

        System.out.println("Общая сумма продаж: $" + allSales.getTotalSales());

    }
}