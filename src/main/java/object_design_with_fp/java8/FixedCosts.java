package object_design_with_fp.java8;

public class FixedCosts {

    private final FunctionOverTime valueFunction;

    public FixedCosts(FunctionOverTime valueFunction) {
        this.valueFunction = valueFunction;
    }

    public String getName() {
        return "Fixed Costs";
    }

    public double valueAt(final int time) {
        return valueFunction.valueAt(time);
    }
}
