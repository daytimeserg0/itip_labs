class Chair extends MovingObjects {
    private static int objectCount = 0;
    private boolean hasBackrest;
    private boolean hasCovering;
    private int seatHeight;


    public Chair(String name, String material, int mass, boolean isMove, boolean hasBackrest, boolean hasCovering, int seatHeight) {
        super(name, material, mass, isMove);
        this.hasBackrest = hasBackrest;
        this.hasCovering = hasCovering;
        this.seatHeight = seatHeight;
        objectCount++;
    }

    public boolean getHasBackrest() {
        return hasBackrest;
    }
    public boolean getHasCovering() {
        return hasCovering;
    }

    public int getSeatHeight() {
        return seatHeight;
    }
    public static int getObjectCount() {
        return objectCount;
    }
    public void setHasBackrest(boolean hasBackrest) {
        this.hasBackrest = hasBackrest;
    }
    public void setHasCovering(boolean hasCovering) {
        this.hasCovering = hasCovering;
    }
    public void setSeatHeight(int seatHeight) {
        this.seatHeight = seatHeight;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Наличие спинки: " + (hasBackrest ? "Есть" : "Нет"));
        System.out.println("Наличие обшивки: " + (hasCovering ? "Есть" : "Нет"));
        System.out.println("Высота сиденья в см: " + seatHeight);
    }

    public void displayInfo(int x) {
        super.displayInfo();
        System.out.println("У данного стула " + (hasBackrest ? "присутсвует" : "отсутсвует") + " спинка");
        System.out.println("У данного стула " + (hasCovering ? "присутсвует" : "отсутсвует") + " обшивка");
        System.out.println("Высота сиденья " + seatHeight + " см");
    }
}