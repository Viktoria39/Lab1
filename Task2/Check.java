package Task2;

class Check {
    private double x = 3.0;
    private double y = 4.0;

    public double Dist() {
        return Math.sqrt(x * x + y * y);
    }

    public void setRandomData() {
        x = Math.random();
        y = Math.random();
    }

    public void setData(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}