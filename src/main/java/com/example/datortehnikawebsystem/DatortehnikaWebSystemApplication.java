package com.example.datortehnikawebsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@SpringBootApplication
public class DatortehnikaWebSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatortehnikaWebSystemApplication.class, args);
    }


}
