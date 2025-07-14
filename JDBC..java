package www.jdbcexample.com;

import java.sql.Connection;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		// WAP to connect to mysql db and fetch data and display it
          try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/my_database";
            String username = "root";
            String password = "password";

            Connection connection = java.sql.DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database successfully!");

            String query = "INSERT INTO EMPDETAILS(EMPCODE,ENAME,AGE,ESALARY) VALUES(101,'JENNY',25,10000),(102,'JACKY',30,20000),"
            		+ "(103,'JOE',20,40000),(104,'JOHN',40,80000),(105,'SHAMEER',25,90000)";


            java.sql.Statement statement = connection.createStatement();
            int rows = statement.executeUpdate(query);

            // Close the resources            
            statement.close();
            connection.close();
        } catch (Exception e) {
//            System.out.println("MySQL JDBC Driver not found. Include it in your library path.");
              System.out.println(e.getMessage());
        }


        }



	}

}
