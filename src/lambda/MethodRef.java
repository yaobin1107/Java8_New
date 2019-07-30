package lambda;

import entity.Employee;
import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 若 Lambda 体中的内容有方法已经实现了，我们可以使用“方法引用”
 * 可以理解为方法引用是 Lambda 表达式的另外一种表现形式
 *
 * 三种格式：
 *      ① 对象::实例方法名
 *      ② 类::静态方法名
 *      ③ 类::实例方法名
 * 注意：
 *      Lambda体中调用方法的参数列表与返回值类型，要与函数式接口中抽象方法的参数列表和返回值类型保持一致
 *      若 Lambda 参数列表中第一个参数需实例方法的调用者，第二个参数是实例方法的参数，可以使用 类::实例方法
 */
public class MethodRef {
    //对象::实例方法名
    @Test
    public void test1() {
        Consumer<String> con = (x) -> System.out.println(x);
        Consumer<String> con1 = System.out::println;

        Employee employee = new Employee();
        Supplier<String> sup = () -> employee.getName();
        System.out.println(sup.get());

        Supplier<String> sup2 = employee::getName;
        System.out.println(sup2.get());
    }


    //类::静态方法名
    @Test
    public void test2() {
        Comparator<Integer> con = (x, y) -> Integer.compare(x, y);
        System.out.println(con.compare(1, 2));

        Comparator<Integer> con1 = Integer::compare;
        System.out.println(con1.compare(2, 1));
    }

    //类::实例方法名
    @Test
    public void test3() {
        BiPredicate<String, String> con = (x, y) -> x.equals(y);
        /**
         * 参数列表中第一个参数需要是实例方法的调用者，第二个参数是方法的参数
         */
        BiPredicate<String, String> con1 = String::equals;
    }
}
