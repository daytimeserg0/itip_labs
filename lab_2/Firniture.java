abstract class Furniture {
    private String name;
    private String material;
    private  String mass;

    public Furniture(String name, String material, int mass) {
        this.name = name;
        this.material = material;
        this.mass = String.valueOf(mass);
    }

    public String getName() {
        return name;
    }

    public String getMaterial() {
        return material;
    }

    public String getMass() {
        return mass;
    }

    public void displayInfo() {
        System.out.println("Тип мебели: " + name);
        System.out.println("Материал: " + material);
        System.out.println("Вес в кг: " + mass);
    }
}