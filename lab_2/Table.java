class Table extends MovingObjects {
    private static int objectCount = 0;
    private String shape;
    private int numberOfSeats;
    private int numberOfLegs;

    public Table(String name, String material, int mass,boolean isMove, String shape, int numberOfSeats,  int numberOfLegs) {
        super(name, material, mass, isMove);
        this.shape = shape;
        this.numberOfSeats = numberOfSeats;
        this.numberOfLegs = numberOfLegs;
        objectCount++;
    }

    public String getShape() {
        return shape;
    }
    public int getNumberOfSeats() {
        return numberOfSeats;
    }
    public int getNumberOfLegs() {
        return numberOfLegs;
    }
    public static int getObjectCount() {
        return objectCount;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }
    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public void setNumberOfLegs(int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }


    public void displayInfo() {
        super.displayInfo();
        System.out.println("Количество ножек: " + numberOfLegs);
        System.out.println("Форма: " + shape);
        System.out.println("Количество мест: " + numberOfSeats);
    }
    public void displayInfo(int x) {
        super.displayInfo();
        System.out.println("У данного стола имеется " + numberOfLegs + " ножки");
        System.out.println("Этот стол " + shape);
        System.out.println("У данного стола  " + numberOfSeats + " места");
    }
}