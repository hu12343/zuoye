package cn.edu.xaut.web;

import cn.edu.xaut.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CustomerAction extends ActionSupport {
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private User user;
    public String execute() throws Exception {
        ActionContext context=ActionContext.getContext();
        System.out.println(this.user.getUsername());
        System.out.println(this.user.getPassword());
        if("hu".equals(this.user.getUsername())&&"123".equals(this.user.getPassword())) {
            context.getSession().put("user",this.user);
            return SUCCESS;
        }
        else {
            return INPUT;
        }
    }
}
