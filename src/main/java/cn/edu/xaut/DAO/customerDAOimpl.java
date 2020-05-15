package cn.edu.xaut.DAO;

import cn.edu.xaut.entity.Customer;
import cn.edu.xaut.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class customerDAOimpl implements CustomerDAO{

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
           Session session = HibernateUtils.getSession();
           String hql = "from Customer";
           Query query = session.createQuery(hql);
          query.setFirstResult((page-1)*pageSize);
           query.setMaxResults(pageSize);
           List<Customer> customers = query.list();
           session.close();
           return customers;
   }
     public int findTotalPage(int pageSize) {
           Session session = HibernateUtils.getSession();
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
       CustomerDAOSH customerDAOSH =new CustomerDAOSH();
       customerDAOSH.add(customer);
    }
}