package cn.edu.xaut.web;

import cn.edu.xaut.entity.Customer;

import java.util.List;

public interface CustomerService  {
    public List<Customer> findCustomerByPage(int page, int pageSize);
    public  int findTotalPage(int pageSize);
}
