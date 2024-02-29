package ru.lukyanov.hiberdemo;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ru.lukyanov.hiberdemo.entity.Employee;

import java.util.List;

@Slf4j
public class HiberDemoApp {

    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {
            Session session = factory.openSession();
            session.beginTransaction();

            //SAVE
//            Employee employee = new Employee("Ivan4", "Ivanov4", "dept4", 10004);
//            session.persist(employee);
//            session.getTransaction().commit();

            //GET BY ID
//            int empId = employee.getId()
//            Employee getEmployee = session.get(Employee.class, empId);
//            session.getTransaction().commit();
//            log.info("{}", getEmployee);

            //GET ALL BY HQL QUERY
//            List<Employee> employees = session.createQuery("FROM Employee").getResultList();
//            employees.forEach(employee -> log.info(employee.toString()));
//            session.getTransaction().commit();

            //GET ALL BY NAME
//            Query query = session.createQuery("from Employee where name = :username and salary > :userSalary");
//            query.setParameter("username", "Ivan");
//            query.setParameter("userSalary", 1000);
//            List<Employee> employeesNamedIvan = query.getResultList();
//            employeesNamedIvan.forEach(employee -> log.info(employee.toString()));
//            session.getTransaction().commit();

            //UPDATE
//            Employee getEmployee = session.get(Employee.class, 4);
//            getEmployee.setSalary(50000);
//            Query query = session.createQuery("update Employee set salary = 100 where surname = :usersurname");
//            query.setParameter("usersurname", "Ivanov2").executeUpdate();
//            session.getTransaction().commit();
//            log.info("{}", getEmployee.getSalary());

            //DELETE
//            Employee getEmployee = session.get(Employee.class, 4);
//            session.remove(getEmployee);
            try {
                Query query = session.createQuery("delete FROM Employee where id = :id");
                            query.setParameter("id", 5).executeUpdate();
                            log.info("Deleted");
            }
            catch (IllegalArgumentException e) {
                System.out.println("Wrong id number");
                session.getTransaction().rollback();
            }
            session.getTransaction().commit();
        }

    }
}
