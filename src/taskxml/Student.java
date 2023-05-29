/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskxml;

/**
 *
 * @author gamal
 */
public class Student {
    private int id;
    private String name="";
    private int age;
    private int phone;

    public Student(String name, int id, int age, int phone) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.phone = phone;
    }
 public Student() {}
    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public int getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", age=" + age + ", phone=" + phone + '}';
    }
}
