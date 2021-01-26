package entity;

public class Result {
    public int min;
    public int max;
    public int med;
    public int avg;
    public DynamicArr inc;
    public DynamicArr dec;

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getMed() {
        return med;
    }

    public int getAvg() {
        return avg;
    }

    public DynamicArr getInc() {
        return inc;
    }

    public DynamicArr getDec() {
        return dec;
    }

    public Result(){
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
    }

    @Override
    public String toString() {
        return "Result{\n" +
                "\tmin=" + min + ",\n" +
                "\tmax=" + max + ",\n" +
                "\tmed=" + med + ",\n" +
                "\tavg=" + avg + ",\n" +
                "\tinc=" + inc + ",\n" +
                "\tdec=" + dec + ",\n" +
                '}';
    }
}
