
public class InstructorManager{


		//ders ekleme
		public void addLesson (Instructor instructor, String email, String password, String lessonName, int lessonID, int lessonHours) {
			if ((instructor.getEmail() == email) && (instructor.getPassword()==password)) {
				Lesson lesson = new Lesson();
				lesson.setLessonHours(lessonHours);
				lesson.setLessonID(lessonID);
				lesson.setLessonName(lessonName);
				LessonManager lessonManager1= new LessonManager();
				lessonManager1.lessonCreate(lesson,instructor);
			}
			else System.out.println("email veya þifre geçersiz\n");
		}
		
		public void writeInstructor (Instructor instructor) {
			System.out.println("Eðitici oluþturuldu : ");
			System.out.println(
					instructor.getInstructorID() + "\n" + 
					instructor.getName() + " " + instructor.getSurname() + "\n" +
					instructor.getInstructorLevel() + ". seviye eðitmen\n"					
					);
		}
}
