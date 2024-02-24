package be.wimdetroyer.javasandbox.puzzler.collectionspaumard;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _3_ListOfDoesntAcceptNulls {

    public static void main(String[] args) {


        String[] stringies = {"1", "2", "3", null};
        List<String> arraysAsList = Arrays.asList(stringies); // works!
        arraysAsList.removeIf(Objects::isNull);
        System.out.println(arraysAsList.size());

    }



}
