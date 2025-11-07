package com.example.hibernatecrud;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        // Create
        createStudent("Yashraj Mishra", "yashraj@example.com");

        // Read
        readStudents();

        // Update
        updateStudent(1, "Yashraj Updated");

        // Delete
        deleteStudent(1);

        HibernateUtil.shutdown();
    }

    private static void createStudent(String name, String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Student s = new Student(name, email);
        session.save(s);
        tx.commit();
        session.close();
        System.out.println("✅ Student saved: " + s);
    }

    private static void readStudents() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Student> students = session.createQuery("from Student", Student.class).list();
        for (Student s : students) {
            System.out.println("📘 " + s);
        }
        session.close();
    }

    private static void updateStudent(int id, String newName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Student s = session.get(Student.class, id);
        if (s != null) {
            s.setName(newName);
            session.update(s);
            tx.commit();
            System.out.println("✏️ Updated: " + s);
        } else {
            System.out.println("⚠️ Student not found!");
        }
        session.close();
    }

    private static void deleteStudent(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Student s = session.get(Student.class, id);
        if (s != null) {
            session.delete(s);
            tx.commit();
            System.out.println("🗑️ Deleted: " + s);
        } else {
            System.out.println("⚠️ Student not found!");
        }
        session.close();
    }
}
