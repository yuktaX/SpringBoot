package crud.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import crud.demo.dao.StudentDAO;
import crud.demo.entity.Student;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	//executes after all beans have been initialized
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO)
	{
		return runner -> {	//java lambda expression
			//createStudentDAO(studentDAO);
			readStudentDAO(studentDAO);
		};
	}

	private void createStudentDAO(StudentDAO studentDAO)
	{
		//create the student obj
		System.out.println("Creating student obj...");
		Student tmpStudent = new Student("Amber", "Depp", "amber@gmail.com");
		
		//save obj
		System.out.println("Saving student...");
		studentDAO.save(tmpStudent);

		//display id of saved obj
		System.out.println("Saved student, generated id: " + tmpStudent.getId());
	}

	private void readStudentDAO(StudentDAO studentDAO)
	{
		//create the student obj
		System.out.println("Creating student obj...");
		Student tmpStudent = new Student("John", "Doe", "doey123@gmail.com");
		
		//save obj
		System.out.println("Saving student...");
		studentDAO.save(tmpStudent);

		//display id of saved obj
		System.out.println("Saved student, generated id: " + tmpStudent.getId());
		
		//retrieve id usinf .find()
		Student rcvd = studentDAO.findByid(tmpStudent.getId());
		System.out.println("Received id: " + rcvd.getId());
	}

}
