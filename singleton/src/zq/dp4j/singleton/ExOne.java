package zq.dp4j.singleton;

/**
 * 单例模式
 * 饿汉式(类被加载时就先实例化，或者理解为还没调用获取实例的方法前该类就已经被实例化)
 * 线程安全
 * 1、要保证类的单例性，首先不能有构造方法提供给外部使用，因为如果外部可以调用构造方法的话，
 * 能随便new出对象，就肯定不属于同一个对象。这里的做法的将构造方法的权限修饰符改为private，
 * 这样的话，该类的构造方法外部就不能直接使用了。
 * 2、试想以下，既然外部不能使用new关键字调用构造方法实例化类了，那我们怎么才能得到该类的唯
 * 一一个实例呢？那我们就在类里面实例化该类！在类里面调用该类的构造方法实例化出一个类的实例，
 * 然后通过一个外部可以调用的方法将该实例作为返回将其传递出去。但是要保证该类也不被外部看见，
 * 该实例也应该使用private修饰。
 * 3、这个供外部调用从而获取实例的方法怎么设计？由于我们事先不能获取该类的一个实例，故无法调
 * 用类的实例方法，所以，该方法应该使用static修饰该方法，因而声明实例变量的时候不仅要用
 * private修饰，还要使用static修饰。
 */
public class ExOne {

    private static ExOne singleton = new ExOne();

    private ExOne() {
    }

    public static ExOne getInstance(){
        return singleton;
    }

    //测试:输出的a和b的引用是同一地址
    public static void main(String[] args) {
        ExOne a = ExOne.getInstance();
        ExOne b = ExOne.getInstance();
        System.out.println(a);
        System.out.println(b);
    }
}
