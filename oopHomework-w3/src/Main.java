
public class Main {

	public static void main(String[] args) {
	
	//List oluþturma
		
	Instructor[] instructorList;
	Student[] studentList;
	Lesson[] lessonList;
	
	//Öðretici tanýmlama
		
	Instructor instructor1 = new Instructor();
	instructor1.setId(1);
	instructor1.setName("Engin");
	instructor1.setSurname("Demiroð");
	instructor1.setEmail("edemirog@gmail.com");
	instructor1.setInstructorLevel(4);
	instructor1.setPassword("12345");

	InstructorManager insManager1 = new InstructorManager();
	insManager1.writeInstructor(instructor1);
	insManager1.addLesson(instructor1, "edemirog@gmail.com", "12345", "Java OOP", 1, 50);
	insManager1.addLesson(instructor1, "edemirog@gmail.com", "12345", "React", 2, 30);
	insManager1.addLesson(instructor1, "edemirog@gmail.com", "122345", "React", 3, 30);
	
	//Öðrenci tanýmlama
	Student student1 = new Student();
	student1.setId(1);
	student1.setName("Ertuðrul");
	student1.setSurname("Aslan");
	student1.setEmail("easlan@kou.edu.tr");
	student1.setPassword("6161");
	
	StudentManager studentManager1 = new StudentManager();
	studentManager1.writeStudent(student1);
	studentManager1.selectLesson(student1, "easlan@kou.edu.tr", "6161", 2);
	studentManager1.selectLesson(student1, "easlan@kou.edu.tr", "6161123", 1);
		
}
	
}
