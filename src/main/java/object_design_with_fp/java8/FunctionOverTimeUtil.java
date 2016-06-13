package object_design_with_fp.java8;

public class FunctionOverTimeUtil {

    public static FunctionOverTime monthByMonth(final double[] array) {
        return new FunctionOverTime() {
            @Override
            public Double valueAt(final Integer time) {
                return array[time - 1];
            }
        };
    }

    static FunctionOverTime constant(final double value) {
        return polynomial(new double[] { value });
    }

    static FunctionOverTime line(final double intercept, final double slope) {
        return polynomial(new double[] { intercept, slope });
    }

    static FunctionOverTime polynomial(final double[] coefficients) {
        return new FunctionOverTime() {
            @Override
            public Double valueAt(final Integer time) {
                double sum = 0.0;
                for (int i = 0; i < coefficients.length; i++) {
                    sum +=  Math.pow(time, i) * coefficients[i];
                }
                return sum;
            }
        };
    }
}
