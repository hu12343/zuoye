package cn.edu.xaut.web;

import cn.edu.xaut.DAO.customerDAO;
import cn.edu.xaut.entity.Customer;
import cn.edu.xaut.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class CustomerAction extends ActionSupport {
    public List<Customer> getCustomers() {
        return customers;
    }

    public CustomerService getCuostmerService() {
        return customerservice;
    }

    public void setCuostmerService(CustomerService cuostmerService) {
        this.customerservice = cuostmerService;
    }

    CustomerService customerservice=new CustomerService();
    int page;


    int pageSize;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    int totalPage;
    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    List<Customer> customers;

    customerDAO customerDAO=new customerDAO();
    public String execute() throws Exception {
       this.customers= customerservice.findCustomerByPage(page,pageSize);
       this.totalPage=customerservice.findTotalPage(pageSize);
            return SUCCESS;


    }
}
