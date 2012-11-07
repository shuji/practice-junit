package ch03;

public class Person {

    private String name;
    private int age;
    private String email;

    public Person(String name) {
        this.name = name;
        this.age = -1;
        this.email = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
