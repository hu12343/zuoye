package cn.edu.xaut.Service;
import cn.edu.xaut.DAO.CustomerDAO;
import cn.edu.xaut.Service.CustomerService;
import cn.edu.xaut.entity.Customer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("customerService")
public class CustomerServiceimpl implements CustomerService {

public void add(Customer customer)
{
    customerDAO.add(customer);
}
    public CustomerDAO getCustomerDAO() {
        return customerDAO;
    }

    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
@Resource(name ="CustomerDAOTempl")
    CustomerDAO customerDAO;
    public  int findTotalPage(int pageSize) {
        return customerDAO.findTotalPage(pageSize);
    }
    public List<Customer> findCustomerByPage(int page, int pageSize){
        return customerDAO.findCustomerByPage(page,pageSize);
    }

}
