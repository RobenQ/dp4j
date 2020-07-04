package zq.dp4j.singleton;

import static java.lang.Thread.sleep;

/**
 * 单例模式
 * 懒汉式(只有在调用方法，想获取实例时才实例化类)
 * 线程不安全的懒汉式
 * 1、要保证类的单例性，首先不能有构造方法提供给外部使用，因为如果外部可以调用构造方法的话，
 * 能随便new出对象，就肯定不属于同一个对象。这里的做法的将构造方法的权限修饰符改为private，
 * 这样的话，该类的构造方法外部就不能直接使用了。
 * 2、试想以下，既然外部不能使用new关键字调用构造方法实例化类了，那我们怎么才能得到该类的唯
 * 一一个实例呢？那我们就在类里面实例化该类！在类里面调用该类的构造方法实例化出一个类的实例，
 * 然后通过一个外部可以调用的方法将该实例作为返回将其传递出去。但是要保证该类也不被外部看见，
 * 该实例也应该使用private修饰。所谓懒汉式，就是在声明实例变量的时候就不将对象new出来，而
 * 是用户调用getInstance方法时再将实例变量的对象new出来。但这不是线程安全的，因为在执行判
 * 断语句的时候可能被其他线程占用，导致可能判断之后返回多个不同的实例。所以这不算真正意义上的
 * 单例模式。
 * 3、这个供外部调用从而获取实例的方法怎么设计？由于我们事先不能获取该类的一个实例，故无法调
 * 用类的实例方法，所以，该方法应该使用static修饰该方法，因而声明实例变量的时候不仅要用
 * private修饰，还要使用static修饰。
 */
public class ExTwo {

    private static ExTwo singleton;

    private ExTwo() {
    }

    public static ExTwo getInstance(){
        if(singleton==null){
            singleton = new ExTwo();
        }
        return singleton;
    }

    public static void main(String[] args) throws InterruptedException {
        ExTwo a = ExTwo.getInstance();
        ExTwo b = ExTwo.getInstance();
        System.out.println(a);
        System.out.println(b);
    }

}
