package cn.edu.xaut.web;
import cn.edu.xaut.DAO.customerDAO;
import cn.edu.xaut.entity.Customer;
import java.util.List;

public class CustomerService {
    customerDAO customerDAO=new customerDAO();
    public  int findTotalPage(int pageSize) {
        return customerDAO.findTotalPage(pageSize);
    }
    public List<Customer> findCustomerByPage(int page, int pageSize){
        return customerDAO.findCustomerByPage(page,pageSize);
    }

}
