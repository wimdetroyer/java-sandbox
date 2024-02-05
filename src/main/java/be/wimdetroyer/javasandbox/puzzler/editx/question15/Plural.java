package be.wimdetroyer.javasandbox.puzzler.editx.question15;

public class Plural {

    public static void main(String[] args) {
        countBugs(null);
    }

    private static void countBugs(Integer bugs) {
        //TODO: throws NPE - why? - read: https://betterprogramming.pub/java-20-pattern-matching-for-switch-whats-under-the-hood-223a109f5e2f
        // https://www.youtube.com/watch?v=aKaw9W789wU
        // When clause: https://www.infoq.com/articles/pattern-matching-for-switch/#:~:text=An%20optional%20when%20clause%20can,constants%20when%20using%20enum%20constants.
        switch (bugs) {
            case Integer i when i == 0 -> System.out.println("There is no bug");
            case Integer i when i == 1 -> System.out.println("There is one bug");
            case Integer i when i > 1 -> System.out.println("There are several bug");
            case Integer i  -> System.out.println("Theres no known bug");
        }
    }
}
