package com.spring.jdbc;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
    public static void main(String[] args) {
        System.out.println("My jdbc program got started...");

        //spring jdbc=> JdbcTemplate object
        ApplicationContext context =
                new ClassPathXmlApplicationContext("config.xml");

        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

        Student student = new Student();
        student.setId(555);
        student.setName("Rakesh Sharma");
        student.setCity("Delhi");

        int result = studentDao.insert(student);
        System.out.println("Student added: "+result);

        /*//insert query
        String query = "insert into student(id,name,city) values(?,?,?)";

        //fire query
        int result = jdbcTemplate.update(query, 404, "Jayant", "Etawa");
        System.out.println("number of record inserted: "+result);*/



    }
}
