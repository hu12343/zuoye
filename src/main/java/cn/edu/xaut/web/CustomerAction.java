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

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    List<Customer> customers;
    customerDAO customerDAO=new customerDAO();
    public String execute() throws Exception {
       this.customers=customerDAO.select();
            return SUCCESS;


    }
}
