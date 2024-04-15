package ru.gb.task01;

public class Program {
    public static void main(String[] args) {
        Student student = new Student("Vasya", 18, 4);
        FileIO.serialise("student.xml", student);
    }
}
