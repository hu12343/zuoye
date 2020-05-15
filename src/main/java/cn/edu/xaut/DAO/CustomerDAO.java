package cn.edu.xaut.DAO;

import cn.edu.xaut.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    public  List<Customer> select();
    public List<Customer> findCustomerByPage(int page,int pageSize);
    public int findTotalPage(int pageSize);
    public void add(Customer customer);
}
