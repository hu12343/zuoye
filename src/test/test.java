import cn.edu.xaut.DAO.CustomerDAO;
import cn.edu.xaut.DAO.CustomerDAOSH;
import cn.edu.xaut.DAO.customerDAOimpl;
import cn.edu.xaut.entity.Customer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class test {

    @Test
    public void f()
    {
        customerDAOimpl customerDAOimpl =new customerDAOimpl();
        customerDAOimpl.select();

    }
    @Test
    public void tda()throws SQLException
    {
        ApplicationContext cs=new ClassPathXmlApplicationContext("beans.xml");
        DataSource dataSource=(DataSource)cs.getBean("datasource");
        Connection con=dataSource.getConnection();
        ResultSet rs=con.createStatement().executeQuery("select * from customer2");
        while(rs.next())
        {
            System.out.print(rs.getString("name")+" ");
            System.out.println(rs.getString("id"));
        }
    }
    @Test
    public void testSessionFactory () {
        ApplicationContext cs = new ClassPathXmlApplicationContext("beans.xml");
        SessionFactory sessionFactory = (SessionFactory) cs.getBean("sessionFactory");
        Session session = sessionFactory.openSession();
        String hql = "from Customer";
        Query query = session.createQuery(hql);
        List<Customer> css = query.list();
        for (Customer c : css) {
            System.out.println(c);
        }
    }
        @Test
        public void testCustomerDaoSH ()
    {
        ApplicationContext cs = new ClassPathXmlApplicationContext("beans.xml");
        CustomerDAO customerDAO=cs.getBean("CustomerDAOSH", CustomerDAOSH.class);
        List<Customer> list1=customerDAO.select();
        System.out.println(list1.size());
        List <Customer> list2 =customerDAO.findCustomerByPage (1,5);
        System.out.println(list2.size());


    }


}
