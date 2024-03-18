package Task3;

class TestClass {
    public double evaluate(double a) {
        return Math.exp(-Math.abs(a) * 1) * Math.sin(1);
    }

    public double evaluate(double a, int x) {
        return Math.exp(-Math.abs(a) * x) * Math.sin(x);
    }
}