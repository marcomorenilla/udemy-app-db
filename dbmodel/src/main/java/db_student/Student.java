package db_student;

public class Student {

    private int id;
    private String name;
    private String surname;
    private int age;
    private String email;

    public Student(int id,String name, String surname, int age, String email) {
        this.id=id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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
