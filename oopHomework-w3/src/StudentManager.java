
public class StudentManager{

	//ders se�me
	public void selectLesson (Student student, String email, String password, int lessonID) {
		if ((student.getEmail() == email) && (student.getPassword()==password)) {
			System.out.println(lessonID + " nolu ders se�ilmi�tir.");
		}
		else System.out.println("email veya �ifre ge�ersiz");
	}
	
	public void writeStudent (Student student) {
		System.out.println("��renci olu�turuldu : ");
		System.out.println(
				student.getStudentID() + "\n" + 
				student.getName() + " " + student.getSurname() + "\n" 				
				);
	}
	
}
