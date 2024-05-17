package be.wimdetroyer.javasandbox.puzzler.og;

import java.util.IdentityHashMap;
import java.util.Map;

public class InterningAndCaching {

  // Run this with args: "orange, 1, 1000"
  public static void main(String[] args) {
    String runTimeOrange = args[0];
    // Args passed are "orange"
    Map<String, String> stringMap = new IdentityHashMap<>();
    stringMap.put("orange", "foo");
    stringMap.put("orange", "bar");
    stringMap.put(runTimeOrange, "baz");
    System.out.println(stringMap.size());

    Integer runTimeAutoboxedIntUnder128 = Integer.parseInt(args[1]);
    Integer runTimeAutoboxedIntAboveCacheLimit = Integer.parseInt(args[2]);

    Map<Integer, String> boxingIntMap = new IdentityHashMap<>();
    boxingIntMap.put(1, "foo");
    boxingIntMap.put(1, "bar");
    boxingIntMap.put(runTimeAutoboxedIntUnder128, "baz");

    System.out.println(boxingIntMap.size());
  }
}
