package functional_remove_duplication.java6.timing;

import com.google.common.base.Supplier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

import static functional_remove_duplication.java6.timing.Timing.timed;

public class Example {

    static final Logger logger = LogManager.getLogger(Example.class.getName());

    public static void main(String[] args) {

        final Double costs = Timing.timed("Cost calculation",
                new Supplier<Double>() {
                    @Override
                    public Double get() {
                        return calculateCosts();
                    }
                });

        final Double revenue = Timing.timed("Revenue calculation",
                new Supplier<Double>() {
                    @Override
                    public Double get() {
                        return calculateRevenue();
                    }
                });

        final Double profit = Timing.timed("Profit calculation",
                LoggerFunctions.info(logger),
                new Supplier<Double>() {
                    @Override
                    public Double get() {
                        return calculateProfit(costs, revenue);
                    }
                });

        System.out.println("Profit = $" + profit);
    }

    private static Double calculateCosts() {
        pretendToWorkHard();
        return 4567.3;
    }

    private static Double calculateRevenue() {
        pretendToWorkHard();
        return 23413.2;
    }

    private static Double calculateProfit(Double costs, Double revenue) {
        pretendToWorkHard();
        return revenue - costs;
    }

    private static final Random r = new Random();
    private static final Integer MAX_WORK_TIME_MS = 2000;

    private static void pretendToWorkHard() {
        try {
            Thread.sleep(r.nextInt(MAX_WORK_TIME_MS));
        } catch (InterruptedException e) {
        }
    }
}
