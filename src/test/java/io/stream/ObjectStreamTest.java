package io.stream;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;

public class ObjectStreamTest {

    @Test
    public void outputStreamTest() throws Exception {
        Person person = new Person("zhangsan", 12, false);
        Person person2 = new Person("lisi", 24, true);
        Person person3 = new Person("wangwu", 36, true);
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FileStreamTest.filePath));

        outputStream.writeObject(person);
        outputStream.writeObject(person2);
        outputStream.writeObject(person3);
        outputStream.writeObject(Arrays.asList(1, 2, 3, 4, 5, 6));

        outputStream.close();
    }

    @Test
    public void inputStreamTest() throws Exception {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FileStreamTest.filePath));

        Person p = (Person) inputStream.readObject();
        System.out.println(p);

        Person p2 = (Person) inputStream.readObject();
        System.out.println(p2);

        System.out.println(inputStream.readObject());
        System.out.println(inputStream.readObject());

        inputStream.close();
    }

}

//private类型实体类、没有实现Serializable接口，报错
class Person implements Serializable {
    private String name;   //姓名
    private int age;   //年龄
    private boolean sex;  //性别

    public Person() {
    }

    public Person(String name, int age, boolean sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {   //重写toString方法对对象进行打印
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
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

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
}
