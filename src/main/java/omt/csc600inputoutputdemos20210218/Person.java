package omt.csc600inputoutputdemos20210218;

public class Person {
    String name;
    int age;
    
    Person() { }
    
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Name: " + name + " age: " + age;
    }
}
