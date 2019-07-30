package lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

public class LambdaStart {
    //原来的匿名内部类
    @Test
    public void test1() {
        Comparator<Integer> cp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, 02);
            }
        };
        TreeSet<Integer> treeSet = new TreeSet<>(cp);
    }

    //Lambda表达式
    @Test
    public void test2() {
        Comparator<Integer> cp = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> ts = new TreeSet<>(cp);
    }
}
