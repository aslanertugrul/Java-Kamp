
public class Instructor extends User {
	
	String instructorID;
	int instructorLevel;
	

	public String getInstructorID() {
		return "INS-"+ id;
	}
	
	public int getInstructorLevel() {
		return instructorLevel;
	}
	public void setInstructorLevel(int instructorLevel) {
		this.instructorLevel = instructorLevel;
	}


}
