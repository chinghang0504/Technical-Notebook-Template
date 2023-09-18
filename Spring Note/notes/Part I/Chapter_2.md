# [Spring Note](../../README.md) - Chapter 2 The Spring context: Defining beans
| Chapter | Title |
| :-: | :- |
| 2.1 | [Spring Context](#21-spring-context) |
|  | [Spring Context Dependency](#spring-context-dependency) |
|  | [Using @Configuration to Create a Configuartion](#using-configuration-to-create-a-configuartion) |
|  | [Using the Configuartion to Create a Context](#using-the-configuartion-to-create-a-context) |
| 2.2 | [Spring Bean](#22-spring-bean) |
| 2.3 | [Using @Bean to Create a Bean](#23-using-bean-to-create-a-bean) |
|  | [Single Bean](#single-bean) |
|  | [Multiple Beans (Using the Method Names)](#multiple-beans-using-the-method-names) |
|  | [Multiple Beans (Using the Bean Names)](#multiple-beans-using-the-bean-names) |
|  | [Multiple Beans (Using the Bean Names and @Primary)](#multiple-beans-using-the-bean-names-and-primary) |
| 2.4 | [Using @Component to Craete a Component](#24-using-component-to-craete-a-component) |
|  | [Using @ComponentScan to Scan All the Compontents](#using-componentscan-to-scan-all-the-compontents) |
|  | [Single Component](#single-component) |
|  | [Javax Annotation Dependency (@PostConstruct and @PreDestroy)](#javax-annotation-dependency-postconstruct-and-predestroy) |
|  | [Using @PostConstruct to Construct a Component after Created](#using-postconstruct-to-construct-a-component-after-created) |
|  | [Using @PreDestroy to Destruct a Component before Destroied](#using-predestroy-to-destruct-a-component-before-destroied) |
| 2.5 | [Using the Bean Register Method to Create a Bean](#25-using-the-bean-register-method-to-create-a-bean) |
|  | [Single Bean](#single-bean-1) |
|  | [Multiple Beans (Using the Bean Names)](#multiple-beans-using-the-bean-names-1) |
|  | [Multiple Beans (Using the Bean Names and the Set Primary Method)](#multiple-beans-using-the-bean-names-and-the-set-primary-method) |

<br />

## 2.1 Spring Context
- Imagine the context as a place in the memory of your app in which we add all the object instances that we want the framework to manage.
- By default, Spring doesn’t know any of the objects you define in your application.
- To enable Spring to see your objects, you need to add them to the context.
- Spring uses the instances in the context to connect your app to various functionalities it provides.

### Spring Context Dependency
pom.xml
```XML
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>6.0.11</version>
</dependency>
```

### Using @Configuration to Create a Configuartion
ProjectConfig.java
```Java
@Configuration
public class ProjectConfig {

}
```

### Using the Configuartion to Create a Context
Main.java
```Java
public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
    }
}
```

<br />

## 2.2 Spring Bean
- You can add beans in the context in the following ways:
    1. Using the @Bean annotation
    2. Using the @Component annotation
    3. Using the Bean Register Method

<br />

## 2.3 Using @Bean to Create a Bean
### Single Bean
Parrot.java
```Java
public class Parrot {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

ProjectConfig.java
```Java
@Configuration
public class ProjectConfig {

    @Bean
    Parrot parrot() {
        var p = new Parrot();
        p.setName("Koko");
        return p;
    }
}
```

Main.java
```Java
public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot p = context.getBean(Parrot.class);
        System.out.println(p.getName());
    }
}
```

### Multiple Beans (Using the Method Names)
Parrot.java
```Java
public class Parrot {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

ProjectConfig.java
```Java
@Configuration
public class ProjectConfig {

    @Bean
    Parrot parrot1() {
        var p = new Parrot();
        p.setName("Koko");
        return p;
    }

    @Bean
    Parrot parrot2() {
        var p = new Parrot();
        p.setName("Miki");
        return p;
    }
}
```

Main.java
```Java
public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot p1 = context.getBean("parrot1", Parrot.class);
        System.out.println(p1.getName());

        Parrot p2 = context.getBean("parrot2", Parrot.class);
        System.out.println(p2.getName());
    }
}
```

### Multiple Beans (Using the Bean Names)
Example of Setting the Bean Names
```Java
@Bean("Miki")
@Bean(name = "Miki")
@Bean(value = "Miki")
```

Parrot.java
```Java
public class Parrot {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

ProjectConfig.java
```Java
@Configuration
public class ProjectConfig {

    @Bean("Koko")
    Parrot parrot1() {
        var p = new Parrot();
        p.setName("Koko");
        return p;
    }

    @Bean("Miki")
    Parrot parrot2() {
        var p = new Parrot();
        p.setName("Miki");
        return p;
    }
}
```

Main.java
```Java
public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot p1 = context.getBean("Koko", Parrot.class);
        System.out.println(p1.getName());

        Parrot p2 = context.getBean("Miki", Parrot.class);
        System.out.println(p2.getName());
    }
}
```

### Multiple Beans (Using the Bean Names and @Primary)
Parrot.java
```Java
public class Parrot {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

ProjectConfig.java
```Java
@Configuration
public class ProjectConfig {

    @Bean("Koko")
    @Primary
    Parrot parrot1() {
        var p = new Parrot();
        p.setName("Koko");
        return p;
    }

    @Bean("Miki")
    Parrot parrot2() {
        var p = new Parrot();
        p.setName("Miki");
        return p;
    }
}
```

Main.java
```Java
public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot p1 = context.getBean(Parrot.class);
        System.out.println(p1.getName());

        Parrot p2 = context.getBean("Miki", Parrot.class);
        System.out.println(p2.getName());
    }
}
```

<br />

## 2.4 Using @Component to Craete a Component
### Using @ComponentScan to Scan All the Compontents
ProjectConfig.java
```Java
@Configuration
@ComponentScan
public class ProjectConfig {

}
```

### Single Component
Parrot.java
```Java
@Component
public class Parrot {

    private String name = "Koko";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

ProjectConfig.java
```Java
@Configuration
@ComponentScan
public class ProjectConfig {

}
```

Main.java
```Java
public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot p = context.getBean(Parrot.class);
        System.out.println(p.getName());
    }
}
```

### Javax Annotation Dependency (@PostConstruct and @PreDestroy)
pom.xml
```XML
<dependency>
    <groupId>javax.annotation</groupId>
    <artifactId>javax.annotation-api</artifactId>
    <version>1.3.2</version>
</dependency>
```

### Using @PostConstruct to Construct a Component after Created
Parrot.java
```Java
@Component
public class Parrot {

    private String name;

    @PostConstruct
    public void init() {
        this.name = "Koko";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

ProjectConfig.java
```Java
@Configuration
@ComponentScan
public class ProjectConfig {

}
```

Main.java
```Java
public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot p = context.getBean(Parrot.class);
        System.out.println(p.getName());
    }
}
```

### Using @PreDestroy to Destruct a Component before Destroied
Parrot.java
```Java
@Component
public class Parrot {

    private String name;

    @PostConstruct
    public void init() {
        this.name = "Koko";
        System.out.println("Initializing the component");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroying the component");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

ProjectConfig.java
```Java
@Configuration
@ComponentScan
public class ProjectConfig {

}
```

Main.java
```Java
public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot p = context.getBean(Parrot.class);
        System.out.println(p.getName());

        context.close();
    }
}
```

<br />

## 2.5 Using the Bean Register Method to Create a Bean
### Single Bean
Parrot.java
```Java
public class Parrot {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

ProjectConfig.java
```Java
@Configuration
public class ProjectConfig {

}
```

Main.java
```Java
public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot registerP = new Parrot();
        registerP.setName("KoKo");
        context.registerBean("Koko", Parrot.class, () -> registerP);

        Parrot p = context.getBean(Parrot.class);
        System.out.println(p.getName());
    }
}
```

### Multiple Beans (Using the Bean Names)
Parrot.java
```Java
public class Parrot {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

ProjectConfig.java
```Java
@Configuration
public class ProjectConfig {

}
```

Main.java
```Java
public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot registerP1 = new Parrot();
        registerP1.setName("KoKo");
        context.registerBean("Koko", Parrot.class, () -> registerP1);

        Parrot registerP2 = new Parrot();
        registerP2.setName("Miki");
        context.registerBean("Miki", Parrot.class, () -> registerP2);

        Parrot p1 = context.getBean("Koko", Parrot.class);
        System.out.println(p1.getName());
        Parrot p2 = context.getBean("Miki", Parrot.class);
        System.out.println(p2.getName());
    }
}
```

### Multiple Beans (Using the Bean Names and the Set Primary Method)
Parrot.java
```Java
public class Parrot {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

ProjectConfig.java
```Java
@Configuration
public class ProjectConfig {

}
```

Main.java
```Java
public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot registerP1 = new Parrot();
        registerP1.setName("KoKo");
        context.registerBean("Koko", Parrot.class, () -> registerP1, bc -> bc.setPrimary(true));

        Parrot registerP2 = new Parrot();
        registerP2.setName("Miki");
        context.registerBean("Miki", Parrot.class, () -> registerP2);

        Parrot p1 = context.getBean(Parrot.class);
        System.out.println(p1.getName());
        Parrot p2 = context.getBean("Miki", Parrot.class);
        System.out.println(p2.getName());
    }
}
```

<br />
