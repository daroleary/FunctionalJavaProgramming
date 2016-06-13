package object_design_with_fp.java8;

public class Sales {

    private final FunctionOverTime valueFunction;

    public Sales(FunctionOverTime valueFunction) {
        this.valueFunction = valueFunction;
    }

    public String getName() {
        return "Sales";
    }

    public double valueAt(final int time) {
        return valueFunction.valueAt(time);
    }
}
