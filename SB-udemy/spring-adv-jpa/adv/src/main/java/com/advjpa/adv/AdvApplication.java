package com.advjpa.adv;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.advjpa.adv.dao.AppDAO;
import com.advjpa.adv.entity.Instructor;
import com.advjpa.adv.entity.InstructorDetail;

@SpringBootApplication
public class AdvApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
			//System.out.println("Hello");
			//createInstructor(appDAO);
			findInstructor(appDAO);
		};
	}

	private void createInstructor(AppDAO appDAO)
	{
		//create the instructor
		Instructor tmpInstructor = new Instructor("chad", "darby", "123@gmail.com");

		InstructorDetail tmpDetail = new InstructorDetail("http://www.luv2code.com", "Love coding!!");

		tmpInstructor.setInstructorDetail(tmpDetail);

		System.out.println(tmpInstructor);
		appDAO.save(tmpInstructor);
	}

	private void findInstructor(AppDAO appDAO){

		int id = 5;

		Instructor tmp = appDAO.findInstructorbyId(id);

		System.out.println("tmpInstructor" + tmp);
	}

}
