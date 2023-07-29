package com.spring.jdbc;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class App {
    public static void main(String[] args) {
        System.out.println("My jdbc program got started...");

        //spring jdbc=> JdbcTemplate object
        ApplicationContext context =
                new ClassPathXmlApplicationContext("config.xml");

        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

        //1. data for insert

        /*Student student = new Student();
        student.setId(553);
        student.setName("Anupam");
        student.setCity("Bangalore");
        int result = studentDao.insert(student);
        System.out.println("Student added: "+result);*/


        //2. data for UPDATE

       /* Student student = new Student();
        student.setId(555);
        student.setName("Raj kumar");
        student.setCity("UAE");
        int result = studentDao.change(student);
        System.out.println("Data updated/changed: "+result);*/

        //3. DELETE data

        /*int result = studentDao.delete(553);
        System.out.println("data deleted: "+result);*/

        //4. GET DATA

        /*Student result = studentDao.getStudent(222);
        System.out.println("Got the data from DB: "+result);*/

        //5. GET ALL DATA

        List<Student> allStudent = studentDao.getAllStudent();
        for (Student student : allStudent) {
            System.out.println(student);
        }



    }
}
