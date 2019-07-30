package lambda;

import entity.Employee;
import org.junit.Test;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 构造器引用：
 *  格式；
 *      ClassName::new
 * 数组引用：
 *      Type::new
 */
public class ConstructorRef {
    @Test
    public void test1() {
        Supplier<Employee> sup = () -> new Employee();

        //构造器引用方式
        Supplier<Employee> sup2 = Employee::new;//无参
    }

    /**
     * 调用哪个构造方法取决于函数式接口中方法的参数
     */
    @Test
    public void test2() {
        Function<String, Employee> fun = (x) -> new Employee(x);

        //构造器引用方式
        Function<String, Employee> fun2 = Employee::new;//一个参数
        System.out.println(fun2.apply("yb"));
    }

    //数组引用
    @Test
    public void test3() {
        Function<Integer, String[]> fun = (x) -> new String[x];

        Function<Integer, String[]> fun2 = String[]::new;
    }
}
