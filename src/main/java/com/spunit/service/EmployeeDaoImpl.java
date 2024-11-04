package com.spunit.service;

import com.spunit.config.HibernateConfig;
import com.spunit.model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public void saveEmployee(Employee employee) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(employee);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(employee);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public Employee getEmployeeById(long id) {
        Transaction transaction = null;
        Employee employee = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            employee = session.get(Employee.class, id);
            //student = session.load(Student.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployee() {
        Transaction transaction = null;
        List<Employee> employees = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            employees = session.createQuery("from Employee", Employee.class).getResultList();
            //student = session.load(Employee.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return employees;
    }

    @Override
    public void deleteEmployee(long id) {
        Transaction transaction = null;
        Employee employee;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            employee = session.get(Employee.class, id);
            // get student object
            session.remove(employee);
            //student = session.load(Student.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
