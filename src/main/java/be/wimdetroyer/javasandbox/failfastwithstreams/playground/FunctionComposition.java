package be.wimdetroyer.javasandbox.failfastwithstreams.playground;

import be.wimdetroyer.javasandbox.failfastwithstreams.v2.ValidationResult;

import java.util.function.Function;

public class FunctionComposition {

    public static void main(String[] args) {
        // That takes 0 or more params
        Function<String, String> fn = (a) -> a;
        Function<String, String> fn2 = String::toUpperCase;
        Function<String, String> composee = fn.andThen(fn2);
        System.out.println(composee.apply("a"));

    }
}
