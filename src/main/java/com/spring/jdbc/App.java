package com.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class App {
    public static void main(String[] args) {
        System.out.println("My program started...");

        //spring jdbc=> JdbcTemplate object
        ApplicationContext context =
                new ClassPathXmlApplicationContext("config.xml");

        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);

        //insert query
        String query = "insert into student(id,name,city) values(?,?,?)";

        //fire query
        int result = jdbcTemplate.update(query, 456, "Dilip", "Karnal");
        System.out.println("number of record inserted: "+result);



    }
}
