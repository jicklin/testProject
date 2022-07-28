package test.optional;

import com.sun.org.apache.regexp.internal.RE;
import org.junit.Test;

import java.util.Optional;
import java.util.function.Supplier;

public class TestOptional {


    @Test
    public void test() {
        String s = null;
//        Optional<String> s1 = Optional.of(s);
        Optional<String> s2 = Optional.ofNullable(s);
//        System.out.println(s1.get());
//        String s1 = s2.orElse("123");
//
//        System.out.println(s1);

        s2.orElseThrow(() -> new IllegalArgumentException());


    }
}
