
public class LessonManager {

	public void lessonCreate (Lesson lesson, Instructor instructor) {
		System.out.println("Ders olu�turuldu : " + lesson.getLessonName() + " - E�itmen : " + instructor.getName() + " " + instructor.getSurname() + "\n");
	}
	
}
