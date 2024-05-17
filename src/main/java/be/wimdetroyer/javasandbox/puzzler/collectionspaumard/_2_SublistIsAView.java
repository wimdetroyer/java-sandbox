package be.wimdetroyer.javasandbox.puzzler.collectionspaumard;

import java.util.ArrayList;
import java.util.List;

public class _2_SublistIsAView {

  public static void main(String[] args) {
    var integers = new ArrayList<Integer>(List.of(1, 2, 3, 4, 5));
    /*
    From the docs:

    Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive. (If fromIndex and toIndex are equal, the returned list is empty.)
    The returned list is backed by this list, so non-structural changes in the returned list are reflected in this list, and vice-versa.
    The returned list supports all of the optional list operations.
     */
    var subListOfIt = integers.subList(0, 0);
    subListOfIt.addAll(List.of(10, 11, 12));
    System.out.println(integers);
  }
}
