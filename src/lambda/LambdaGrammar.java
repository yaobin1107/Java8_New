package lambda;

import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;

/**
 * ①Lambda表达式基础语法：Java8引入了一个新的操作符 “->” 该操作符称为箭头操作符或 Lambda 操作符
 *  箭头操作符将 Lambda 表达式分为两部分：
 *      左侧：Lambda 表达式的参数列表
 *      右侧：Lambda 表达式中所需执行的功能，即 Lambda 体
 *  语法格式一：无参数，无返回值
 *      () -> System.out.println("Hello!")
 *  语法格式二：一个参数，无返回值
 *      (x) -> System.out.println(x)
 *  语法格式三：若只有一个参数，小括号可以省略不写
 *      x -> System.out.println(x)
 *  语法格式四：两个及以上参数，有返回值，并且 Lambda 体中有多条语句
 *      Comparator<Integer> cp = (x, y) -> {
 *             System.out.println("函数式接口");
 *             return Integer.compare(x, y);
 *         };
 *  语法格式五：两个及以上参数，有返回值，但 Lambda 体中只有一条语句，return 和大括号都可以不写
 *      Comparator<Integer> cp2 = (x, y) -> Integer.compare(x, y);
 *  语法格式六：Lambda 表达式的参数列表的数据类型可以省略不写，因为 JVM 编译器可通过上下文推断出数据类型即“类型推断”
 *      (Integer x, Integer y) -> Integer.compare(x, y)
 *  口诀：
 *      左右遇一括号省
 *      左侧推断类型省
 *  ②Lambda 表达式需要“函数式接口”的支持
 *      函数式接口：接口中只有一个抽象方法的接口，称为函数式接口，可以使用注解 @FunctionalInterface 修饰
 *                可以检查是否是函数式接口
 */
public class LambdaGrammar {

    @Test
    public void test1() {

        int num = 0;//jdk1.7中，必须是final

        //匿名内部类
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello!" + num);
            }
        };
        r.run();
        System.out.println("----------------------");

        //Lambda
        Runnable r1 = () -> System.out.println("Hello,Lambda!" + num);
        r1.run();
    }

    @Test
    public void test2() {
        //Lambda 一个参数，无返回值
        Consumer<String> con = (x) -> System.out.println(x);
        //若只有一个参数，小括号可以省略不写
        Consumer<String> con1 = x -> System.out.println(x);
        con.accept("你好啊！");
        con1.accept("你好啊！");
    }

    @Test
    public void test3() {
        Comparator<Integer> cp = (x, y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x, y);
        };
        System.out.println("---------------");
        //两个及以上参数，有返回值，但 Lambda 体中只有一条语句，return 和大括号都可以不写
        Comparator<Integer> cp2 = (x, y) -> Integer.compare(x, y);
    }

    @Test
    public void test4() {
        //类型推断
        String[] strs = {"aa", "bb", "cc"};
        //下面就会报错，不能根据上下文类型推断
        /*String string;
        string = {"aa", "bb", "cc"};*/
        List<String> list = new ArrayList<>();

        //map可以不写类型，会自动推断
        show(new HashMap<>());//jdk1.8的升级
    }

    public void show(Map<String, Integer> map) {

    }

}
