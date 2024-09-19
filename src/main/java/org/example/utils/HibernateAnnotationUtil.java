package org.example.utils;


import org.example.entity.Currency;
import org.example.entity.Employee;
import org.example.entity.Person;
import org.example.entity.Role;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.EntityManagerFactory;
import java.util.HashMap;
import java.util.Map;

public class HibernateAnnotationUtil {

    private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

    /**
     * Utility class
     */
    private HibernateAnnotationUtil() {
    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }

    private static SessionFactory buildSessionFactory() {
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(dbSettings())
                .build();

        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Role.class)
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Currency.class)
                .buildMetadata();

        //EntityManagerFactory factory = EntityManagerFactory

        return metadata.buildSessionFactory();
    }

    private static Map<String, Object> dbSettings() {
        Map<String, Object> dbSettings = new HashMap<>();
        dbSettings.put(Environment.URL, "jdbc:mysql://localhost:3308/j1023_db");
        dbSettings.put(Environment.USER, "root");
        dbSettings.put(Environment.PASS, "");
        dbSettings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
        dbSettings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        dbSettings.put(Environment.SHOW_SQL, "true");
        dbSettings.put(Environment.HBM2DDL_AUTO, "update"); //create
        return dbSettings;
    }

    public static void close() {
        SESSION_FACTORY.close();
    }


}