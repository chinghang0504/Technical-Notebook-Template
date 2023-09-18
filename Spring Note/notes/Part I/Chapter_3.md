# [Spring Note](../../README.md) - Chapter 3 The Spring context: Wiring beans
| Chapter | Title |
| :-: | :- |
| 3.1 | [Bean Relationships](#31-bean-relationships) |
| 3.2 | [Wiring to Single Bean](#32-wiring-to-single-bean) |
|  | [Using @Bean and the Direct Method](#using-bean-and-the-direct-method) |
|  | [Using @Bean and the Method Parameter](#using-bean-and-the-method-parameter) |
| 3.3 | [Auto-Wiring to Single Component](#33-auto-wiring-to-single-component) |
|  | [Using @Component and @Autowired to the Field](#using-component-and-autowired-to-the-field) |
|  | [Using @Component and @Autowired to the Constructor Parameter](#using-component-and-autowired-to-the-constructor-parameter) |
|  | [Using @Component and @Autowired to the Method Parameter](#using-component-and-autowired-to-the-method-parameter) |
| 3.4 | [Circular Dependencies](#34-circular-dependencies) |
|  | [Problem](#problem) |
|  | [Solution](#solution) |
| 3.5 | [Wiring to Multiple Beans](#35-wiring-to-multiple-beans) |
|  | [Using @Bean, @Primary, and @Qualifier with the Method Name](#using-bean-primary-and-qualifier-with-the-method-name) |
|  | [Using @Bean, @Primary, and @Qualifier with the Bean Name](#using-bean-primary-and-qualifier-with-the-bean-name) |
| 3.6 | [Auto-Wiring to Multiple Beans](#36-auto-wiring-to-multiple-beans) |
|  | [Using @Bean, @Primary, @Component, @Autowired, and @Qualifier with the Method Name to the Field](#using-bean-primary-component-autowired-and-qualifier-with-the-method-name-to-the-field) |
|  | [Using @Bean, @Primary, @Component, @Autowired, and @Qualifier with the Method Name to the Constructor Parameter](#using-bean-primary-component-autowired-and-qualifier-with-the-method-name-to-the-constructor-parameter) |
|  | [Using @Bean, @Primary, @Component, @Autowired, and @Qualifier with the Method Name to the Method Parameter](#using-bean-primary-component-autowired-and-qualifier-with-the-method-name-to-the-method-parameter) |

<br />

## 3.1 Bean Relationships
- Two ways to establish relationships among the beans (one bean will have a reference to another to delegate calls when it needs).
    1. Wiring
    2. Auto-Wiring

<br />

## 3.2 Wiring to Single Bean
### Using @Bean and the Direct Method
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

    @Override
    public String toString() {
        return "Parrot: " + name;
    }
}
```

Person.java
```Java
public class Person {

    private String name;
    private Parrot parrot;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parrot getParrot() {
        return parrot;
    }

    public void setParrot(Parrot parrot) {
        this.parrot = parrot;
    }
}
```

ProjectConfig.java
```Java
@Configuration
public class ProjectConfig {

    @Bean
    public Parrot parrot() {
        Parrot p = new Parrot();
        p.setName("Koko");
        return p;
    }

    @Bean
    public Person person() {
        Person p = new Person();
        p.setName("Ella");
        p.setParrot(parrot());
        return p;
    }
}
```

Main.java
```Java
public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Person person = context.getBean(Person.class);
        Parrot parrot = context.getBean(Parrot.class);

        System.out.println("Person's name: " + person.getName());
        System.out.println("Parrot's name: " + parrot.getName());
        System.out.println("Person's parrot: " + person.getParrot());
    }
}
```

### Using @Bean and the Method Parameter
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

    @Override
    public String toString() {
        return "Parrot: " + name;
    }
}
```

Person.java
```Java
public class Person {

    private String name;
    private Parrot parrot;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parrot getParrot() {
        return parrot;
    }

    public void setParrot(Parrot parrot) {
        this.parrot = parrot;
    }
}
```

ProjectConfig.java
```Java
@Configuration
public class ProjectConfig {

    @Bean
    public Parrot parrot() {
        Parrot p = new Parrot();
        p.setName("Koko");
        return p;
    }

    @Bean
    public Person person(Parrot parrot) {
        Person p = new Person();
        p.setName("Ella");
        p.setParrot(parrot);
        return p;
    }
}
```

Main.java
```Java
public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Person person = context.getBean(Person.class);
        Parrot parrot = context.getBean(Parrot.class);

        System.out.println("Person's name: " + person.getName());
        System.out.println("Parrot's name: " + parrot.getName());
        System.out.println("Person's parrot: " + person.getParrot());
    }
}
```
    
<br />

## 3.3 Auto-Wiring to Single Component
### Using @Component and @Autowired to the Field
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

    @Override
    public String toString() {
        return "Parrot: " + name;
    }
}
```

Person.java
```Java
@Component
public class Person {

    private String name = "Ella";
    @Autowired
    private Parrot parrot;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parrot getParrot() {
        return parrot;
    }

    public void setParrot(Parrot parrot) {
        this.parrot = parrot;
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

        Person person = context.getBean(Person.class);
        Parrot parrot = context.getBean(Parrot.class);

        System.out.println("Person's name: " + person.getName());
        System.out.println("Parrot's name: " + parrot.getName());
        System.out.println("Person's parrot: " + person.getParrot());
    }
}
```

### Using @Component and @Autowired to the Constructor Parameter
- This approach is the one used most often in production code and the one I recommend.
- It enables you to define the fields as final, ensuring no one can change their value after Spring initializes them.

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

    @Override
    public String toString() {
        return "Parrot: " + name;
    }
}
```

Person.java
```Java
@Component
public class Person {

    private String name = "Ella";
    private final Parrot parrot;

    @Autowired
    public Person(Parrot parrot) {
        this.parrot = parrot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parrot getParrot() {
        return parrot;
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

        Person person = context.getBean(Person.class);
        Parrot parrot = context.getBean(Parrot.class);

        System.out.println("Person's name: " + person.getName());
        System.out.println("Parrot's name: " + parrot.getName());
        System.out.println("Person's parrot: " + person.getParrot());
    }
}
```

### Using @Component and @Autowired to the Method Parameter
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

    @Override
    public String toString() {
        return "Parrot: " + name;
    }
}
```

Person.java
```Java
@Component
public class Person {

    private String name = "Ella";
    private Parrot parrot;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parrot getParrot() {
        return parrot;
    }

    @Autowired
    public void setParrot(Parrot parrot) {
        this.parrot = parrot;
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

        Person person = context.getBean(Person.class);
        Parrot parrot = context.getBean(Parrot.class);

        System.out.println("Person's name: " + person.getName());
        System.out.println("Parrot's name: " + parrot.getName());
        System.out.println("Person's parrot: " + person.getParrot());
    }
}
```
    
<br />

## 3.4 Circular Dependencies
### Problem
- A circular dependency is a situation in which, to create a bean (let’s name it Bean A), Spring needs to inject another bean that doesn’t exist yet (Bean B).
- But Bean B also requests a dependency to Bean A. So, to create Bean B, Spring needs first to have Bean A.
- Spring is now in a deadlock.
- It cannot create Bean A because it needs Bean B, and it cannot create Bean B because it needs Bean A.

### Solution
- A circular dependency is easy to avoid.
- You just need to make sure you don’t define objects whose creation depends on the other.
- Having dependencies from one object to another like this is a bad design of classes.
- In such a case, you need to rewrite your code.
    
<br />

## 3.5 Wiring to Multiple Beans
### Using @Bean, @Primary, and @Qualifier with the Method Name
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

    @Override
    public String toString() {
        return "Parrot: " + name;
    }
}
```

Person.java
```Java
public class Person {

    private String name;
    private Parrot parrot;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parrot getParrot() {
        return parrot;
    }

    public void setParrot(Parrot parrot) {
        this.parrot = parrot;
    }
}
```

ProjectConfig.java
```Java
@Configuration
public class ProjectConfig {
    @Bean
    @Primary
    public Parrot parrot1() {
        Parrot p = new Parrot();
        p.setName("Koko");
        return p;
    }

    @Bean
    public Parrot parrot2() {
        Parrot p = new Parrot();
        p.setName("Miki");
        return p;
    }

    @Bean
    public Person person(@Qualifier("parrot1") Parrot parrot1) {
        Person p = new Person();
        p.setName("Ella");
        p.setParrot(parrot1);
        return p;
    }
}
```

Main.java
```Java
public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Person person = context.getBean(Person.class);
        Parrot parrot = context.getBean(Parrot.class);

        System.out.println("Person's name: " + person.getName());
        System.out.println("Parrot's name: " + parrot.getName());
        System.out.println("Person's parrot: " + person.getParrot());
    }
}
```

### Using @Bean, @Primary, and @Qualifier with the Bean Name
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

    @Override
    public String toString() {
        return "Parrot: " + name;
    }
}
```

Person.java
```Java
public class Person {

    private String name;
    private Parrot parrot;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parrot getParrot() {
        return parrot;
    }

    public void setParrot(Parrot parrot) {
        this.parrot = parrot;
    }
}
```

ProjectConfig.java
```Java
@Configuration
public class ProjectConfig {
    @Bean("Koko")
    @Primary
    public Parrot parrot1() {
        Parrot p = new Parrot();
        p.setName("Koko");
        return p;
    }

    @Bean("Miki")
    public Parrot parrot2() {
        Parrot p = new Parrot();
        p.setName("Miki");
        return p;
    }

    @Bean
    public Person person(@Qualifier("Koko") Parrot parrot1) {
        Person p = new Person();
        p.setName("Ella");
        p.setParrot(parrot1);
        return p;
    }
}
```

Main.java
```Java
public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Person person = context.getBean(Person.class);
        Parrot parrot = context.getBean(Parrot.class);

        System.out.println("Person's name: " + person.getName());
        System.out.println("Parrot's name: " + parrot.getName());
        System.out.println("Person's parrot: " + person.getParrot());
    }
}
```
    
<br />

## 3.6 Auto-Wiring to Multiple Beans
### Using @Bean, @Primary, @Component, @Autowired, and @Qualifier with the Method Name to the Field
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

    @Override
    public String toString() {
        return "Parrot: " + name;
    }
}
```

Person.java
```Java
@Component
public class Person {

    private String name = "Ella";
    @Autowired
    @Qualifier("parrot1")
    private Parrot parrot;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parrot getParrot() {
        return parrot;
    }

    public void setParrot(Parrot parrot) {
        this.parrot = parrot;
    }
}
```

ProjectConfig.java
```Java
@Configuration
@ComponentScan
public class ProjectConfig {
    @Bean
    @Primary
    public Parrot parrot1() {
        Parrot p = new Parrot();
        p.setName("Koko");
        return p;
    }

    @Bean
    public Parrot parrot2() {
        Parrot p = new Parrot();
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

        Person person = context.getBean(Person.class);
        Parrot parrot = context.getBean(Parrot.class);

        System.out.println("Person's name: " + person.getName());
        System.out.println("Parrot's name: " + parrot.getName());
        System.out.println("Person's parrot: " + person.getParrot());
    }
}
```

### Using @Bean, @Primary, @Component, @Autowired, and @Qualifier with the Method Name to the Constructor Parameter
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

    @Override
    public String toString() {
        return "Parrot: " + name;
    }
}
```

Person.java
```Java
@Component
public class Person {

    private String name = "Ella";
    private final Parrot parrot;

    @Autowired
    public Person(@Qualifier("parrot1") Parrot parrot) {
        this.parrot = parrot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parrot getParrot() {
        return parrot;
    }
}
```

ProjectConfig.java
```Java
@Configuration
@ComponentScan
public class ProjectConfig {
    @Bean
    @Primary
    public Parrot parrot1() {
        Parrot p = new Parrot();
        p.setName("Koko");
        return p;
    }

    @Bean
    public Parrot parrot2() {
        Parrot p = new Parrot();
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

        Person person = context.getBean(Person.class);
        Parrot parrot = context.getBean(Parrot.class);

        System.out.println("Person's name: " + person.getName());
        System.out.println("Parrot's name: " + parrot.getName());
        System.out.println("Person's parrot: " + person.getParrot());
    }
}
```

### Using @Bean, @Primary, @Component, @Autowired, and @Qualifier with the Method Name to the Method Parameter
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

    @Override
    public String toString() {
        return "Parrot: " + name;
    }
}
```

Person.java
```Java
@Component
public class Person {

    private String name = "Ella";
    private Parrot parrot;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parrot getParrot() {
        return parrot;
    }

    @Autowired
    @Qualifier("parrot1")
    public void setParrot(Parrot parrot) {
        this.parrot = parrot;
    }
}
```

ProjectConfig.java
```Java
@Configuration
@ComponentScan
public class ProjectConfig {
    @Bean
    @Primary
    public Parrot parrot1() {
        Parrot p = new Parrot();
        p.setName("Koko");
        return p;
    }

    @Bean
    public Parrot parrot2() {
        Parrot p = new Parrot();
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

        Person person = context.getBean(Person.class);
        Parrot parrot = context.getBean(Parrot.class);

        System.out.println("Person's name: " + person.getName());
        System.out.println("Parrot's name: " + parrot.getName());
        System.out.println("Person's parrot: " + person.getParrot());
    }
}
```
    
<br />
