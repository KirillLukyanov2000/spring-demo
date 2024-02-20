package ru.lukyanov.hiberdemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.lukyanov.hiberdemo.entity.Employee;

public class HiberDemoApp {

    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {
            Session session = factory.openSession();

            Employee employee = new Employee("Ivan2", "Ivanov2", "dept2", 10000);
            session.beginTransaction();
            session.persist(employee);
            session.getTransaction().commit();
        }
    }
}
