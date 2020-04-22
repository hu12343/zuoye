package cn.edu.xaut.DAO;

import cn.edu.xaut.entity.Customer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.List;

public class customerDAO {

   public  List<Customer> select() {

        Configuration config = new Configuration().configure();
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from Customer";
        Query query = session.createQuery(hql);
        List<Customer> cs = query.list();
        for (Customer c : cs) {
            System.out.println(c);
        }
        transaction.commit();
        session.close();
        sessionFactory.close();
        return cs;
    }
}