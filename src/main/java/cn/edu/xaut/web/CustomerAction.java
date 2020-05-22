package cn.edu.xaut.web;
import cn.edu.xaut.DAO.customerDAOimpl;
import cn.edu.xaut.Service.CustomerService;
import cn.edu.xaut.Service.CustomerServiceimpl;
import cn.edu.xaut.entity.Customer;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import javax.annotation.Resource;
import java.util.List;
@Controller
@Scope("prototype")
public class CustomerAction extends ActionSupport {
    public List<Customer> getCustomers() {
        return customers;
    }

    public CustomerService getCustomerservice() {
        return customerservice;
    }

    public void setCustomerservice(CustomerService customerservice) {
        this.customerservice = customerservice;
    }

    public cn.edu.xaut.DAO.customerDAOimpl getCustomerDAOimpl() {
        return customerDAOimpl;
    }

    public void setCustomerDAOimpl(cn.edu.xaut.DAO.customerDAOimpl customerDAOimpl) {
        this.customerDAOimpl = customerDAOimpl;
    }

    @Resource(name="customerService")
    CustomerService customerservice;

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

    customerDAOimpl customerDAOimpl =new customerDAOimpl();
    public String execute() throws Exception {
       this.customers= customerservice.findCustomerByPage(page,pageSize);
       this.totalPage=customerservice.findTotalPage(pageSize);
            return SUCCESS;


    }
}
