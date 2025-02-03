package org.halogen;
import java.sql.*;

public class jdbcSteps {
    public static void main(String[] args) {
        // STEPS:
        // import packages
        // load and register
        // create connection
        // create statement
        // execute statement
        // process results
        // close connection

        try {
//            Class.forName("org.postgresql.Driver");

            String url = "jdbc:postgresql://localhost:5432/jdbc-basic";
            String username = "postgres";
            String password = "cricket360";
            String query = "select * from users";

            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to PostgreSQL database");

//            Statement stmt = con.createStatement();
            PreparedStatement stmt = con.prepareStatement(query);

            System.out.println("Executing select query");
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.print(rs.getInt("id") + " ");
                System.out.print(rs.getString("name") + " ");
                System.out.print(rs.getString("position") + " ");
                System.out.println();
            }

            System.out.println("Executing insert query");
            query = "insert into users (id, name, position) values (4, 'John', 'intern')";
            Boolean insert = stmt.execute(query);
            System.out.println(insert);
            if (insert) {
                System.out.println("Row added successfully");
            }

            System.out.println("Executing update query");
            query = "update users set name = 'Johny' where id = 4 ";
            insert = stmt.execute(query);
            System.out.println(insert);

            con.close();
            System.out.println("Closed connection");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
