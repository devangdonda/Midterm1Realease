package registrar;

/**
 * Write a description of class Enrollment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Registration {


    // instance variables - replace the example below with your own
    private String courseID;
    private int section;
    private int timeSlot;
    private String student;
    private String professor;

    public Registration(String courseID, int section, int timeSlot, String student, String professor) {
        this.courseID = courseID;
        this.section = section;
        this.timeSlot = timeSlot;
        this.student = student;
        this.professor = professor;
    }

    public String toString() {
        // all information as a string
        return student + " is registered for " + courseID + "(" + section + ") slot " + timeSlot + " (" + professor + ")";
    }

    public String getCourseID() {
        return courseID;
    }

    public int getTimeSlot() {
        return timeSlot;
    }

    public String getStudent() {
        return student;
    }

    public int getSection() {
        return section;
    }

    public String getProfessor() {
        return professor;
    }

    public boolean sameAs(Registration other){
        return courseID.equals(other.getCourseID()) &&
                student.equals(other.getStudent()) &&
                timeSlot == other.getTimeSlot() &&
                section == other.getSection() &&
                professor.equals(other.getProfessor());
    }
    /*
     * @Override
    public boolean equals(Object obj) {
        if (obj == null) {return false;}
        else{
            Registration test = (Registration) obj;
            return (this.courseID.equals(test.getCourseID()) && this.section==test.getSection() && this.student.equals(test.getStudent())  && this.timeSlot == test.getTimeSlot() && this.professor.equals(test.getProfessor()));
        
        }
    }
    
    @Override 
    public int hashCode(){
        return courseID.hashCode()+section+timeSlot+student.hashCode()+professor.hashCode();
    }
     */

}
