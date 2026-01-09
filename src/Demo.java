class Animal{
    // 定义动物类的属性
    public String name = "动物";
    public static String staticName = "可爱的动物";
    // 定义动物类的行为方法
    public void eat() {
        System.out.println("动物吃饭");
    }
    public static void staticEat() {
        System.out.println("可爱的动物正在在吃饭");
    }
}
// 定义猫类，该类继承动物类
class Cat extends Animal{
    // 定义猫类的属性
    public String name = "猫";
    public String str = "可爱的小猫";
    public static String staticName = "我是喵星人";
    // 定义猫类的行为方法
    public void eat() {
        System.out.println("猫吃饭");
    }
    public static void staticEat() {
        System.out.println("喵星人在吃饭");
    }
    public void eatMethod() {
        System.out.println("猫喜欢吃鱼");
    }


}

public class Demo{
    public static void main(String[] args) {
        // 请在下面的Begin-End之间按照注释中给出的提示编写正确的代码
        /********* Begin *********/
        // 向上转型，把猫类对象赋值给动物类
        Animal a1=new Cat();
        Cat c1=new Cat();

        // 向下转型，将动物类引用转换为猫类对象
        if(a1 instanceof Animal) a1=(Cat)a1;

        // 输出Animal类的name变量
        System.out.println(a1.name);

        // 输出Animal类的staticName变量
        System.out.println(Animal.staticName);

        // 输出Cat类的eat()方法
        a1.eat();

        // 输出Animal类的staticEat()方法
        Animal.staticEat();

        // 调用Cat类的str变量
        System.out.println(c1.str) ;

        // 调用Cat类的eatMethod()方法
        c1.eatMethod();

        /********** End **********/
    }
}



