package Controller;

import Dao.CustomerDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;



@WebServlet(name = "Customer", value = "/Customer")
public class Customer extends HttpServlet {
    CustomerDao customerDao = new CustomerDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null){
            action="";

        }
        switch (action){
            case "create":
                showCreatePage(request,response);
                break;
            default:
                showListPage(request,response);

        }

    }
    public void showCreatePage(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("demo/Create.jsp");
        dispatcher.forward(request,response);
    }
    public void showListPage(HttpServletRequest request,HttpServletResponse response) throws ServletException ,IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("demo/list.jsp");

        try {
            List<Model.Customer> customerList = customerDao.findAll();
            request.setAttribute("customers", customerList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dispatcher.forward(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null){
            action="";

        }
        switch (action){
            case "create":
               addCustomer(request,response);
                break;
        }

    }
    public void addCustomer(HttpServletRequest request,HttpServletResponse response) throws ServletException ,IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        try {
            customerDao.add(new Model.Customer(id,name,age));
            showListPage(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
