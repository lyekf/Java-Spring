package com.spring;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.StudentJDBCTemplate;

/*
Executing SQL statements
Let us see how we can perform CRUD (Create, Read, Update and Delete) operation on database tables using SQL and JDBC Template object.

Querying for an integer

String SQL = "select count(*) from Student";
int rowCount = jdbcTemplateObject.queryForInt( SQL );
Querying for a long

String SQL = "select count(*) from Student";
long rowCount = jdbcTemplateObject.queryForLong( SQL );
A simple query using a bind variable

String SQL = "select age from Student where id = ?";
int age = jdbcTemplateObject.queryForInt(SQL, new Object[]{10});
Querying for a String

String SQL = "select name from Student where id = ?";
String name = jdbcTemplateObject.queryForObject(SQL, new Object[]{10}, String.class);
Querying and returning an object

String SQL = "select * from Student where id = ?";
Student student = jdbcTemplateObject.queryForObject(
   SQL, new Object[]{10}, new StudentMapper());

public class StudentMapper implements RowMapper<Student> {
   public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
      Student student = new Student();
      student.setID(rs.getInt("id"));
      student.setName(rs.getString("name"));
      student.setAge(rs.getInt("age"));
      
      return student;
   }
}
Querying and returning multiple objects

String SQL = "select * from Student";
List<Student> students = jdbcTemplateObject.query(
   SQL, new StudentMapper());

public class StudentMapper implements RowMapper<Student> {
   public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
      Student student = new Student();
      student.setID(rs.getInt("id"));
      student.setName(rs.getString("name"));
      student.setAge(rs.getInt("age"));
      
      return student;
   }
}
Inserting a row into the table

String SQL = "insert into Student (name, age) values (?, ?)";
jdbcTemplateObject.update( SQL, new Object[]{"Zara", 11} );
Updating a row into the table

String SQL = "update Student set name = ? where id = ?";
jdbcTemplateObject.update( SQL, new Object[]{"Zara", 10} );
Deleting a row from the table

String SQL = "delete Student where id = ?";
jdbcTemplateObject.update( SQL, new Object[]{20} );
Executing DDL Statements
You can use the execute(..) method from jdbcTemplate to execute any SQL statements or DDL statements. Following is an example to use CREATE statement to create a table −

String SQL = "CREATE TABLE Student( " +
   "ID   INT NOT NULL AUTO_INCREMENT, " +
   "NAME VARCHAR(20) NOT NULL, " +
   "AGE  INT NOT NULL, " +
   "PRIMARY KEY (ID));"

jdbcTemplateObject.execute( SQL );
 */

public class Main {
   public static void main(String[] args) {
      ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
      StudentJDBCTemplate studentJDBCTemplate = 
         (StudentJDBCTemplate)context.getBean("studentJDBCTemplate");
      
      System.out.println("------Records Creation--------" );
      studentJDBCTemplate.create("Zara", 11);
      studentJDBCTemplate.create("Nuha", 2);
      studentJDBCTemplate.create("Ayan", 15);

      System.out.println("------Listing Multiple Records--------" );
      List<Student> students = studentJDBCTemplate.listStudents();
      
      for (Student record : students) {
         System.out.print("ID : " + record.getId() );
         System.out.print(", Name : " + record.getName() );
         System.out.println(", Age : " + record.getAge());
      }
      System.out.println("----Listing Record with ID = 2 -----" );
      Student student = studentJDBCTemplate.getStudent(2);
      System.out.print("ID : " + student.getId() );
      System.out.print(", Name : " + student.getName() );
      System.out.println(", Age : " + student.getAge());
   }
}