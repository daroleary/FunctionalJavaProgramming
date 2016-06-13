package collections.java6;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExampleFunctional {

    final static List<String> food = Arrays.asList(
            "Crunchy carrots",
            "Golden-hued bananas",
            "",
            "Bright orange pumpkins",
            "Little trees of broccoli",
            "meat"
    );

    public static final Predicate<String> NON_EMPTY = new Predicate<String>() {
        @Override
        public boolean apply(String input) {
            return input.isEmpty();
        }
    };

    static String summarize(List<String> descriptions) {

        Iterable<String> lastWords = FluentIterable.from(descriptions)
                .filter(NON_EMPTY)
                .transform(lastWord);

        return Joiner.on(" & ").join(lastWords);
    }

    private static Function<String,String> lastWord = new Function<String, String>() {
        @Override
        public String apply(String phrase) {
            return Iterables.getLast(
                    Arrays.asList(phrase.split(" ")), "");
        }
    };

    public static void main(String[] args) {
        final String summary = summarize(food);

        final String desired = "carrots & bananas & pumpkins & broccoli & meat";
        System.out.println(summary);
        if (summary.equals(desired))
            System.out.println("yay!");
    }
}
