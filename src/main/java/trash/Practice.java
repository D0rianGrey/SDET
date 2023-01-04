package trash;

public class Practice {


    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public static ThreadLocal<String> threadLocal2 = ThreadLocal.withInitial(() -> "Test");

    public static void main(String[] args) {
        System.out.println(threadLocal2.get());
    }
}
