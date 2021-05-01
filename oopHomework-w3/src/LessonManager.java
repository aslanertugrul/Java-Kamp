
public class LessonManager {

	public void lessonCreate (Lesson lesson, Instructor instructor) {
		System.out.println("Ders oluþturuldu : " + lesson.getLessonName() + " - Eðitmen : " + instructor.getName() + " " + instructor.getSurname() + "\n");
	}
	
}
