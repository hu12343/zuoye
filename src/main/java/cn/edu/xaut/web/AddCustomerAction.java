package cn.edu.xaut.web;

import cn.edu.xaut.Service.CustomerService;
import cn.edu.xaut.Service.CustomerServiceimpl;
import cn.edu.xaut.entity.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static com.opensymphony.xwork2.Action.SUCCESS;

public class AddCustomerAction {
    Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
    ApplicationContext cs = new ClassPathXmlApplicationContext( "beans.xml");
    CustomerService customerService = cs.getBean ( "customerService", CustomerServiceimpl.class);

    public String addCustomer()
    {
        customerService.add(customer);
        return SUCCESS;
    }


}
