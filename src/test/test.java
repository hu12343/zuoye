import cn.edu.xaut.DAO.customerDAO;
import org.junit.Test;

public class test {

    @Test
    public void f()
    {
        customerDAO customerDAO=new customerDAO();
        customerDAO.select();

    }
}
