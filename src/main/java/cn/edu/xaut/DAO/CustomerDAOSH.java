package cn.edu.xaut.DAO;

import cn.edu.xaut.entity.Customer;
import cn.edu.xaut.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import java.util.List;
import javax.annotation.*;
@Repository("CustomerDAOSH")
public class CustomerDAOSH implements CustomerDAO {

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Resource(name="sessionFactory")
    SessionFactory sessionFactory;

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
    public List<Customer> findCustomerByPage(int page,int pageSize){
        Session session = sessionFactory.openSession();
        String hql = "from Customer";
        Query query = session.createQuery(hql);
        query.setFirstResult((page-1)*pageSize);
        query.setMaxResults(pageSize);
        List<Customer> customers = query.list();
        session.close();
        return customers;
    }
    public int findTotalPage(int pageSize) {
        Session session = sessionFactory.openSession();
        String hql = "select count(*) from Customer";
        Query query = session.createQuery(hql);
        List list = query.list();
        int row = Integer.valueOf(list.get(0).toString());

        if(row%pageSize==0) {
            return row/pageSize;
        }
        else {
            return row/pageSize+1;
        }
    }
    public void add(Customer customer)
    {
        Session session=sessionFactory.openSession();
        session.save(customer);
    }
}
