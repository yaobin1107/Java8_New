package fun;

@FunctionalInterface
public interface FunLong<T, R> {
    public R getValue(T t, T t2);
}
