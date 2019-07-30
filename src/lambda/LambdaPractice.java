package lambda;

import entity.Employee;
import fun.FunLong;
import fun.FunString;
import fun.FunNum;
import org.junit.Test;

import java.util.*;

public class LambdaPractice {
    /**
     * 需求：对一个数进行运算
     */
    @Test
    public void test1() {
        Integer num = operation(100, (x) -> x * x);
        System.out.println(num);
        System.out.println(operation(200, (y) -> (y - 100)));
    }

    /**
     * 用于操作数据的方法
     * @param num 要操作的数
     * @param fd 操作方式
     * @return 操作后的返回值
     */
    public Integer operation(Integer num, FunNum fd) {
        return fd.getValue(num);
    }

    /**
     * 调用Collections.sort()方法，通过定制排序比较两个 Employee
     * 先按年龄比，年龄相同按姓名比，使用 Lambda 作为参数传递
     */
    @Test
    public void test2() {
        List<Employee> emps = Arrays.asList(
                new Employee(1, "yb", 30, 222.22),
                new Employee(2, "ls", 23, 333.33),
                new Employee(3, "zs", 25, 444.44)
        );
        Collections.sort(emps, (e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return -Integer.compare(e1.getAge(), e2.getAge());
            }
        });
        for (Employee emp : emps) {
            System.out.println(emp);
        }
    }

    /**
     * ①声明函数式接口，接口中声明抽象方法，public String getValue（String str）；
     * ②声明类 LambdaPractice，类中编写方法使用接口作为参数，将一个字符串转换成大写，并作为方法的返回值。
     * ③再将一个字符串的第2个和第4个索引位置进行截取子串。
     */
    @Test
    public void test3() {
        //去除首尾空格
        String s = strHandler("\t\t\t 你好啊！ ", string -> string.trim());
        System.out.println(s);
        //大小写转换
        String abcDE = strHandler("abcDE", str -> str.toUpperCase());
        System.out.println(abcDE);
        //截取
        String subed = strHandler("dmoiwnflkwf", str -> str.substring(2, 5));
        System.out.println(subed);
    }

    /**
     * 用于操作字符串的方法
     * @param str 要操作的字符串
     * @param f 操作方式
     * @return 操作后的字符串
     */
    public String strHandler(String str, FunString f) {
        return f.getValue(str);
    }

    /**
     * ①声明一个带两个泛型的函数式接口，泛型类型为<T，R>T为参数，R为返回值
     * ②接口中声明对应抽象方法。
     * ③在 LambdaPractice 类中声明方法，使用接口作为参数，计算两个long型参数的和。
     * ④再计算两个long型参数的乘积。
     */
    @Test
    public void test4() {
        longHandler(100L, 200L, (x, y) -> x - y);
        longHandler(100L, 200L, (x, y) -> x * y);
    }

    public void longHandler(Long l1, Long l2, FunLong<Long, Long> funLong) {
        System.out.println(funLong.getValue(l1, l2));
    }
}
