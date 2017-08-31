package javase;

/**
 * Created by shiwx on 2016/3/20.
 */
public class Test {

    public static void main(String[] args) {
        Class<?> parent = java.io.InputStream.class;
        Class<?> child = java.io.FileInputStream.class;
        System.out.println(parent.isAssignableFrom(child));

        System.out.println(Object.class.isAssignableFrom(String.class));
    }
}
