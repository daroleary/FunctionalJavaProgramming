package object_design_with_fp.java6;

public interface QuantityOfInterest {

    String getName();

    /*
     * expected value for a particular month
     * @param time month, 1-12
     * @return expected value
     */
    double valueAt(final int time);
}
