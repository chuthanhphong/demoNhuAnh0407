package Dao;

import Model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {

    private String FIND_ALL= "select*from Customer";
    private String ADD_CUSTOMER ="INSERT INTO Customer VALUES(?,?,?)";
    SQLConnection sqlConnection = new SQLConnection();
    public List<Customer> findAll() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        Connection connection =sqlConnection.getConection();
        PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()){
            int idCus = rs.getInt("idCus");
            String name = rs.getString("name");
            int age  = rs.getInt("age");
            customers.add(new Customer(idCus,name,age));
        }
        return customers;
    }
    public void add(Customer customer) throws SQLException {
        Connection connection = sqlConnection.getConection();
        PreparedStatement preparedStatement = connection.prepareStatement(ADD_CUSTOMER);
        preparedStatement.setInt(1, customer.getIdCus());
        preparedStatement.setString(2, customer.getName());
        preparedStatement.setInt(3, customer.getAge());
        preparedStatement.executeUpdate();
    }
}
