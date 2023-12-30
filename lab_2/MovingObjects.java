class MovingObjects extends Furniture {
    private boolean isMove;
    public MovingObjects(String name, String material, int mass, boolean isMove) {
        super(name, material, mass);
        this.isMove = isMove;
    }
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Объект: " + (isMove ? "Подвижный" : "Неподвижный"));
    }
}
