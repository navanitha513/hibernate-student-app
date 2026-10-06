package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        SessionFactory factory = configuration.buildSessionFactory();

        // INSERT
     // INSERT

        Session session = factory.openSession();

        session.beginTransaction();

        Student s1 = new Student(
                101,
                "Navaneetham",
                "navanii@gmail.com",
                "Computer Science"
        );

        Student s2 = new Student(
                102,
                "Anu",
                "anu@gmail.com",
                "Data Science"
        );

        Student s3 = new Student(
                103,
                "Priya",
                "priya@gmail.com",
                "Information Technology"
        );

        Student s4 = new Student(
                104,
                "Kaviya",
                "kaviya@gmail.com",
                "Artificial Intelligence"
        );

        Student s5 = new Student(
                105,
                "Harini",
                "harini@gmail.com",
                "Cyber Security"
        );

        session.persist(s1);
        session.persist(s2);
        session.persist(s3);
        session.persist(s4);
        session.persist(s5);

        session.getTransaction().commit();

        System.out.println("5 Students inserted successfully!");

        session.close();

        // UPDATE
        session = factory.openSession();

        session.beginTransaction();

        Student s = session.get(Student.class, 101);

        if (s != null) {
            s.setCourse("Data Science");
        }

        session.getTransaction().commit();

        System.out.println("Student updated successfully!");
        System.out.println(s);

        session.close();

        factory.close();
    }
}
