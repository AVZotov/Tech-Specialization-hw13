package ru.gb.task01;

public class Program {
    public static void main(String[] args) {
        Student student = new Student("Vasya", 18, 4);
        Student student1;
        System.out.println("Initial values before serialization: " + student);
        FileIO.serialize("student.json", student);

        student1 = FileIO.deserialize("student.json");
        System.out.println("After JSON deserialization: " + student1);

        FileIO.serialize("student.xml", student);

        student1 = FileIO.deserialize("student.xml");
        System.out.println("After XML deserialization: " + student1);

        FileIO.serialize("student.bin", student);

        student1 = FileIO.deserialize("student.bin");
        System.out.println("After Binary deserialization: " + student1);
    }
}
