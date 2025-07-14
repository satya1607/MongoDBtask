package www.jdbcexample.com;

import java.sql.Connection;

public class Fetchstudents {
	public static void main(String[] args) {
		// WAP to connect to mysql db and fetch data and display it
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/my_database";
            String username = "root";
            String password = "password";

            Connection connection = java.sql.DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database successfully!");

            String query = "SELECT * FROM EMPDETAILS";


            java.sql.Statement statement = connection.createStatement();
            java.sql.ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int emp_code = resultSet.getInt("empcode");
                String e_name = resultSet.getString("ename");
                int age = resultSet.getInt("age");
                int esalary = resultSet.getInt("esalary");
                System.out.println("Empcode: " + emp_code + ",Ename: " + e_name +
                                   ", Age: " + age + ", Salary: " + esalary);
            }

            // Close the resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("MySQL JDBC Driver not found. Include it in your library path.");
        }



	}
}
