package com.security.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


@SpringBootApplication
public class ProjectApplication {

    public ProjectApplication() throws SQLException {
    }

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(ProjectApplication.class, args);


    String sqlUrl = "jdbc:postgresql://localhost:5432/jdbcsecurity";
    Connection con = DriverManager.getConnection(sqlUrl, "root", "root");

    //Creating a Statement object
    Statement stmt = con.createStatement();
    //Statements to insert records
    String insert1 = "INSERT INTO t_role VALUES ('1','ROLE_USER')";
    String insert2 = "INSERT INTO t_role VALUES ('2','ROLE_MODERATOR')";
    String insert3 = "INSERT INTO t_role VALUES ('3','ROLE_ADMIN')";
    //Adding the statements to batch
      stmt.addBatch(insert1);
      stmt.addBatch(insert2);
      stmt.addBatch(insert3);

//Executing the batch
        stmt.executeBatch();



}
}
