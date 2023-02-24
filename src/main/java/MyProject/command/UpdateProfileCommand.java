package MyProject.command;

import MyProject.Intefaces.intefacesCommand.CommandInfo;
import MyProject.Intefaces.intefacesDAO.EmployeeDao;
import MyProject.Intefaces.intefacesDAO.MyDAOFactory;
import MyProject.entity.Employee;
import MyProject.factory.MyDAOFactoryImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.hibernate.HibernateException;

import java.util.Optional;

public class UpdateProfileCommand implements CommandInfo {
    @Override
    public String execute(HttpServletRequest request) {
        String nickName = request.getParameter("nickName");
        String lastName = request.getParameter("lastName");
        String mail = request.getParameter("mail");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String[] mas = {nickName, lastName, mail, phone, password};
        Employee employee = (Employee) request.getSession().getAttribute("employee");
        MyDAOFactory factory = MyDAOFactoryImpl.getFactory();
        EmployeeDao employeeDao = factory.getEmployeeDao();
        try {
            employeeDao.updateByID(employee.getId(), mas);
            request.getSession().removeAttribute("employee");
            Optional<Employee> byId = employeeDao.getById(employee.getId());
            byId.ifPresent(value -> request.getSession().setAttribute("employee", value));
            request.getSession().setAttribute("updated", "Update is OK");
        } catch (HibernateException e) {
            request.getSession().setAttribute("updated", "Updated is failed");
        }
        return "editor.jsp";
    }
}