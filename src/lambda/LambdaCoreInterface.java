package lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Java8 内置四大核心函数式接口
 * ① Consumer<T> ：消费接口
 *      void accept(T t);
 * ② Supplier<T> ：供给型接口
 *      T get();
 * ③ Function<T, R> ：函数型接口
 *      R apply(T t);
 * ④ Predicate<T> ：断言型接口
 *      boolean test(T t);
 */
public class LambdaCoreInterface {
    //Consumer<T>
    @Test
    public void test1() {
        happy(10000, (x) -> System.out.println("消费了：" + x + "元"));
    }

    public void happy(double money, Consumer<Double> con) {
        con.accept(money);
    }

    @Test
    public void test2() {
        List<Integer> numList = getNumList(20, () -> (int) (Math.random() * 100));
        System.out.println(numList);
    }

    //Supplier<T>
    //需求：产生指定个数的整数，并放入到集合中
    public List<Integer> getNumList(int num, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer integer = sup.get();
            list.add(integer);
        }
        return list;
    }

    @Test
    public void test3() {
        System.out.println(strHandler("哈佛文风凤凰网你发网盘", (str) -> str.substring(2, 5)));
    }

    //Function<T, R> ：函数型接口
    //处理字符串
    public String strHandler(String str, Function<String, String> fun) {
        return fun.apply(str);
    }

    @Test
    public void test4() {
        List<String> list = Arrays.asList("hello", "hi", "你好", "hehe");
        System.out.println(filterStr(list, (str) -> str.length() > 3));
    }

    //Predicate<T> 断言型接口
    //需求：将满足条件的字符串放入集合
    public List<String> filterStr(List<String> list, Predicate<String> pre) {
        List<String> strList = new ArrayList<>();
        for (String str : list) {
            if (pre.test(str)) {
                strList.add(str);
            }
        }
        return strList;
    }
}
