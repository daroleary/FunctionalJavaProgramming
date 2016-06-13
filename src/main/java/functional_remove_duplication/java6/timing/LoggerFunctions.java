package functional_remove_duplication.java6.timing;

import com.google.common.base.Function;
import org.apache.logging.log4j.Logger;

public class LoggerFunctions {
    public static Function<String, Void> info(final Logger logger) {
        return new Function<String, Void>() {
            @Override
            public Void apply(String s) {
                logger.info(s);
                return null;
            }
        };
    }
}
