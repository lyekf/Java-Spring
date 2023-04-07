package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
   public static void main(String[] args) {
      //ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");	//execute your advice before or after all methods,
	   ApplicationContext context = new ClassPathXmlApplicationContext("Beans1.xml");	//execute your advice before or after a particular method,
      
      Student student = (Student) context.getBean("student");
      student.getName();
      student.getAge();
      student.printThrowException();
   }
}