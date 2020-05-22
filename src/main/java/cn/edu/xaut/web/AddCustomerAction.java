package cn.edu.xaut.web;

import cn.edu.xaut.Service.CustomerService;
import cn.edu.xaut.Service.CustomerServiceimpl;
import cn.edu.xaut.entity.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

import static com.opensymphony.xwork2.Action.SUCCESS;
@Controller
@Scope("prototype")
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

  @Resource(name="customerService")
    CustomerService customerService;

    public String addCustomer()
    {
        customerService.add(customer);
        return SUCCESS;
    }


}
