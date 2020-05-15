package cn.edu.xaut.Service;

import cn.edu.xaut.entity.Customer;

import java.util.List;

public interface CustomerService  {
    public List<Customer> findCustomerByPage(int page, int pageSize);
    public  int findTotalPage(int pageSize);
    public void add(Customer customer);
}

