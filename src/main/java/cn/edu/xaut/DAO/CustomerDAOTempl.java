package cn.edu.xaut.DAO;

import cn.edu.xaut.entity.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;
@Repository("CustomerDAOTempl")
public class CustomerDAOTempl implements CustomerDAO {
    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
@Resource(name = "hibernateTemplate")
    HibernateTemplate hibernateTemplate;

    public List<Customer> select(){
String hql="from Customer";
return this.hibernateTemplate.find(hql);
    }

    public List<Customer> findCustomerByPage(final int page, final int pageSize){
        return hibernateTemplate . executeFind ( new HibernateCallback()
        {
            public Object doInHibernate (Session session) throws HibernateException,SQLException
                    {
                        String hql="from Customer";
                        Query query=session.createQuery(hql);
                        query.setFirstResult((page-1)*pageSize);
                        query.setMaxResults(pageSize);
                        return query.list();
                    }
        });

    }
    public int findTotalPage(int pageSize) {
        String hql="select count(*) from Customer";
        List list=this.hibernateTemplate.find(hql);
        int row = Integer.valueOf(list.get(0).toString());

        if (row % pageSize == 0) {
            return row / pageSize;
        } else {
            return row / pageSize + 1;
        }
    }
        public void add (Customer customer){
            hibernateTemplate.save(customer);
        }
    }
