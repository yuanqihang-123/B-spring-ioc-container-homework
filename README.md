### @Component 已经可以支持声明一个 bean 了，为何还要再弄个 @Bean 出来？
1. Spring的@Bean注解用于告诉方法，产生一个Bean对象，然后这个Bean对象交给Spring管理。 产生这个Bean对象的方法Spring只会调用一次，随后这个Spring将会将这个Bean对象放在自己的IOC容器中。

2. @Component , @Repository , @ Controller , @Service 这些注解只局限于自己编写的类，而@Bean注解能把第三方库中的类实例加入IOC容器中并交给spring管理。

3. @Bean注解的另一个好处就是能够动态获取一个Bean对象，能够根据环境不同得到不同的Bean对象。

4. 记住，@Bean就放在方法上，就是让方法去产生一个Bean，然后交给Spring容器，剩下的你就别管了。

> 举个例子：
> 假设这么一种情况，有几个class，我自己也不是不能写，但是写了周末就没时间去外滩闲逛了，就在这个时候，我发现alimama的老铁们已经写好了同样功能的class，我在maven里import一下就完了，开心三秒，又有问题了，他们写的时候没用Spring：
>
> 1）打好的jar包，我不能在class上面加@Component注解；
>
> 2）我没有他们的源码，也不能把他们的代码复制过来，假装自己重写了一遍QQQ
  这时候@Bean的作用就体现出来了，请看：

```java
@Configuration
public class MyClass {
  // class1和class2就是jar包里写好的
  @Bean
  public Class1 getClass1() {
    return new Class1();
  }
  @Bean
  public Class2 getClass1() {
    return new Class2();
  }
  .....
}
```