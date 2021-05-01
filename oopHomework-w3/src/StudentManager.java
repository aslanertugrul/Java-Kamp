
public class StudentManager{

	//ders seçme
	public void selectLesson (Student student, String email, String password, int lessonID) {
		if ((student.getEmail() == email) && (student.getPassword()==password)) {
			System.out.println(lessonID + " nolu ders seçilmiþtir.");
		}
		else System.out.println("email veya þifre geçersiz");
	}
	
	public void writeStudent (Student student) {
		System.out.println("Öðrenci oluþturuldu : ");
		System.out.println(
				student.getStudentID() + "\n" + 
				student.getName() + " " + student.getSurname() + "\n" 				
				);
	}
	
}
