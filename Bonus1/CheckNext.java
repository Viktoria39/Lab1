package Bonus1;

class CheckNext {
    private int originX;
    private int originY;
    private int positionX;
    private int positionY;

    public CheckNext(int originX, int originY) {
        this.originX = originX;
        this.originY = originY;
    }

    public CheckNext(int originX, int originY, int positionX, int positionY) {
        this.originX = originX;
        this.originY = originY;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public void printCoordinates() {
        System.out.println("Origin: (" + originX + ", " + originY + ")");
        System.out.println("Position: (" + positionX + ", " + positionY + ")");
    }
}