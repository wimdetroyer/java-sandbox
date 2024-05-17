package be.wimdetroyer.javasandbox.puzzler.collectionspaumard;

import java.util.Arrays;
import java.util.List;

public class _1_DontUseAsListWithPrimitiveArrayType {

  public static void main(String[] args) {
    int simple = 1;
    int[] ints = {1, 2, 3};
    Integer[] intBoxed = {1, 2, 3}; // arrrayboxed
    List<int[]> list = Arrays.asList(ints); // type parameter is a primitive array type
    List<Integer> boxed = Arrays.asList(intBoxed);
    List<Integer> boxedFromSimple = Arrays.asList(simple); // autoboxed
    System.out.println(list);
    System.out.println(boxed);
  }
}
