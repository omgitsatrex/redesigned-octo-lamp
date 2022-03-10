package employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.sql.ResultSet;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao{
    @Override
    public Employee getEmployeeByUsername(String username) {

        Configuration config = new Configuration();

        config.configure("hibernate.cfg.xml");

        SessionFactory factory = config.buildSessionFactory();

        Session session = factory.openSession();

        Employee employee = session.createQuery("from Employee where username='"+username+"'", Employee.class).getSingleResultOrNull();  //getSingleResult();

        return employee;
    }
}
