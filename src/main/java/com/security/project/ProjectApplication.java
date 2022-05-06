package com.security.project;

import com.security.project.model.User;
import com.security.project.repository.UserRepository;
import com.security.project.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootApplication
public class ProjectApplication {

    public ProjectApplication() {}

    public static void main(String[] args)  {
        SpringApplication.run(ProjectApplication.class, args);

    String sqlUrl = "jdbc:postgresql://localhost:5432/jdbcsecurity";
        Connection con = null;
        try {
            con = DriverManager.getConnection(sqlUrl, "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Creating a Statement object
        Statement stmt = null;
        try {
            stmt = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Statements to insert records
    String insert1 = "INSERT INTO t_role VALUES ('1','ROLE_USER')";
    String insert2 = "INSERT INTO t_role VALUES ('2','ROLE_MODERATOR')";
    String insert3 = "INSERT INTO t_role VALUES ('3','ADMIN')";
      //Adding the statements to batch
        try {
            stmt.addBatch(insert1);
            stmt.addBatch(insert2);
            stmt.addBatch(insert3);

            //Executing the batch
            stmt.executeBatch();
        } catch (SQLException e) {
            System.out.println("Таблица с ролями уже создана и готова к работе!");
        }
    }
    @Bean
    public CommandLineRunner demo(UserRepository userRepository, UserService userService){
            return (args) -> {
                userRepository.save(new User("admin", "111"));
                userRepository.save(new User("moder", "111"));
                userRepository.save(new User("user", "111"));
            };
    }
}
