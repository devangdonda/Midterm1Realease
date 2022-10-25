package registrar;

import grading.GradeValue;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Write a description of class CollegeRegistrar here.
 *
 * @author (Devang Donda)
 * @version (a version number or a date)
 */
public class CollegeRecords {
    private ArrayList<Registration> records;
    private ArrayList<String> Arrays1;
    /**
     * Constructor for_ objects of class CollegeRegistrar
     */
    public CollegeRecords()
    {
        records = new ArrayList<>();
        Arrays1 = new ArrayList<String>();
    }

    public boolean addValidCourseID(String courseId){
        Boolean found = false;
        if (Arrays1.size()==0){
           found = true;
        }
        else{
            if (Arrays1.contains(courseId)){
                found = false;
            }
            else{
                found = true;
            }
        }  
        if (found == true){
            Arrays1.add(courseId);
            }
        return found;
    }
    
    /**
     * Check that the registration is one of the valid courses
     * @param a Registration object
     * @return true/false depending if this is one of the valid courses
     */
    private boolean verifyCourseID(Registration r) {
         Boolean valid = false;
        if (this.Arrays1.contains(r.getCourseID())){
            valid = true;
        }
        return valid;
    }

    /**
     * Check that the registration timeslot is valid
     * @param a Registration object
     * @return true/false depending if the section is valid
     */
    private boolean verifySection(Registration r) {
        return r.getSection() <= 2 && r.getSection() >= 0;
        // return true;
    }

    /**
     * Check that the registration section is valid
     * @param a Registration object
     * @return true/false depending if the timeslot is valid
     */
    private boolean verifySlot(Registration r) {
        return r.getTimeSlot() <= 25 && r.getTimeSlot() >= 12;
        // return true;
    }

    /**
     * add the registration to the college records
     *
     * @param  a new Registration object
     * @return    chaining object
     */

    public CollegeRecords add(Registration newRegistration)
    {
        records.add(newRegistration);
        return this;
    }

    /**
     *
     * @return a count of the registration records
     */

    public int count()
    {
        return records.size(); 
    }

    /**
     * convert the college records to a string
     *
     */

    public String toString()
    {
        return this.records.stream()
            .map(r -> r.toString())
            .reduce("",(initial,finale)->finale+" "+initial);
    }

    /**
     * Use all three validity predicates to remove invalid records from this
     * CollegeRecords object and return records that
     * were removed as a different CollegeRecords object.
     *
     * @return a CollegeRecords of invalid registrations that were removed
     */

    public CollegeRecords clean() {
        // this is some comment
        ArrayList<Registration> valid = new ArrayList<Registration>();
        this.records.stream().filter(this::verifySlot)  // and so is this
                             .filter(this::verifyCourseID)
                             .filter(this::verifySection)
                             .forEach(valid::add);

        this.records.removeAll(valid);

        ArrayList<Registration> invalid = this.records;
        this.records = valid;
        CollegeRecords c = new CollegeRecords();
        invalid.forEach(c::add);
        return c;
        /*
         * CollegeRecords obj1 = new CollegeRecords();
       this.records.stream()
           .filter(r -> verifyCourseID(r)==false || verifySlot(r)==false 
           || verifySection(r)==false)
           .forEach(r ->  obj1.add(r)); 
       this.records  
           .removeIf(r -> verifyCourseID(r)==false || verifySlot(r)==false 
           || verifySection(r)==false);
       return obj1;
         */
    }

}
/*
 * package registrar;
import java.util.stream.Collectors;
import java.util.ArrayList;
import static java.util.stream.Collectors.toList;

/**
 * Write a description of class CollegeRegistrar here.
 *
 * @author (Devang Donda)
 * @version (a version number or a date)
 */
/*

public class CollegeRecords implements CollegeRecordsInterface {
    private ArrayList<Registration> records;
    private ArrayList<String> Arrays1 = new ArrayList<String>();
    
    
    /**
     * Constructor _for_ objects of class CollegeRegistrar
     */
    /*
    public CollegeRecords()
    {
        records = new ArrayList<>();
        Arrays1 = new ArrayList<String>();
    }

    /**
     * Add a valid courseID $for_ validity checking. Only courseIDs added
     * are considered valid.
     * Do not permit a duplicate courseID to be added
     * @param courseId the course ID to add
     * @return false if this course is already listed, otherwise false
     *//*
    
    public boolean addValidCourseID(String courseId){
        Boolean found = false;
        if (Arrays1.size()==0){
           found = true;
        }
        else{
            if (Arrays1.contains(courseId)){
                found = false;
            }
            else{
                found = true;
            }
        }  
        if (found == true){
            Arrays1.add(courseId);
            }
        return found;
    }

    /**
     * add the registration to the college records
     *
     * @param  a new Registration object
     * @return    chaining object
     * This IS perfect.
     *//*
    @Override
    public CollegeRecords add(Registration newRegistration)
    {
        records.add(newRegistration);
        return this;
    }

    /**
     *
     * @return a count of the registration records
     * This IS perfect.
     *//*
    public int count(){
        return records.size();
    }

    /**
     * should return a String combining all of the toStringâ€™s _for each
     * Registration in its records. To construct this, call 
     * Registration.toString() _for each Registration object.
     *//*
    public String toString()
    {
        return this.records.stream()
            .map(r -> r.toString())
            .reduce("",(initial,finale)->finale+" "+initial);
    }

    /**
     * Use all three validity predicates to remove invalid records from this
     * CollegeRecords object and return records that
     * were removed as a different CollegeRecords object.
     * 
     * The clean() method should use all three verify predicates to 
     * determine whether to remove a registration or not. A registration
     * failing any of the three validations should be cleaned out.
     *
     * @return a CollegeRecords of invalid registrations that were removed
     *//*
    @Override
    public CollegeRecords clean() {
       CollegeRecords obj1 = new CollegeRecords();
       this.records.stream()
           .filter(r -> verifyCourseID(r)==false || verifySlot(r)==false 
           || verifySection(r)==false)
           .forEach(r ->  obj1.add(r)); 
       this.records  
           .removeIf(r -> verifyCourseID(r)==false || verifySlot(r)==false 
           || verifySection(r)==false);
       return obj1;
        }

    @Override public CollegeRecords removeDuplicates() {
        CollegeRecords duplicates = new CollegeRecords();
        
        ArrayList<Registration> distinct1 = records.stream()
                             .distinct()
                             .collect(Collectors.toCollection(ArrayList::new));
        
        ArrayList<Registration> dupli = new ArrayList<>(records);
        records = new ArrayList<>(distinct1);
        distinct1.forEach(r->dupli.remove(r));
        dupli.forEach(r->duplicates.add(r));
        
        return duplicates;
    }
    
    public Registration toRegister(String s){
        String[] sdata = s.split("/");
        Registration r = new Registration(sdata[0], Integer.parseInt(sdata[1]),
                    Integer.parseInt(sdata[2]), sdata[3], sdata[4]);
        return r;          
    }

    public CollegeRecords recordsForStudent(String student)
    {
        CollegeRecords studRec = new CollegeRecords();
        this.records.stream().filter(r -> r.getStudent().equals(student))
                             .forEach(r->studRec.add(r));
        return studRec;
    }

    public int courseCount(String student)
    {
        CollegeRecords Records = new CollegeRecords();
        this.records.stream().filter(r -> r.getStudent().equals(student))
                             .forEach(r->Records.add(r));
        return Records.count();
    }

    /**
     * the Registrations listing this professor
     * @param professor
     * @return a CollegeRecords object of all registrations with the given professor
     * This IS perfect.
     *//*
    public CollegeRecords recordsForProfessor(String professor)
    {
        CollegeRecords newRecords = new CollegeRecords();
        this.records.stream().filter(r -> r.getProfessor().equals(professor))
                             .forEach(r->newRecords.add(r));
        return newRecords;
    }

    public CollegeRecords sectionRecords(String courseID, int section) {
        CollegeRecords newSectionRecords = new CollegeRecords();
        this.records.stream().filter(r -> r.getCourseID().equals(courseID)
                                            && r.getSection() == section)
                             .forEach(r->newSectionRecords.add(r));
        return newSectionRecords;
    }

    
    /**
     * Copied same code from clean.
     *//*
    public CollegeRecords dropAllClassesForStudent(String student)
    {
        CollegeRecords delteteRecords = new CollegeRecords();
        this.records.stream().filter(r -> r.getStudent().equals(student))
                             .forEach(r->delteteRecords.add(r));
                             
        this.records.removeIf(r -> r.getStudent().equals(student));
        return delteteRecords;
    }

    /**
     * Use reduce _for the profCourses() method; it is the only one that 
     * makes use of reduce.
     *//*
    public String profCourses(String professor){
        return this.records.stream()
            .filter(r->r.getProfessor().equals(professor))
            .map(r -> r.getCourseID())
            .distinct()
            .reduce(" ",(initial,finale)->initial+finale);
    }
    
    /**
     * true if and only if the registration object refers to a course 
     * previously added as valid using the 
     * CollegeRecords.addValidCourseID(String courseId) method.
     *//*
    private boolean verifyCourseID(Registration r){
        Boolean valid = false;
        if (this.Arrays1.contains(r.getCourseID())){
            valid = true;
        }
        return valid;
    }
    
    /**
     * true if and only if the registration objectâ€™s section
     * is between 0 and 2 inclusive.
     *//*
    private boolean verifySection(Registration r){
        Boolean answer = false;
        if (r.getSection()<=2 && r.getSection()>=0){
            answer = true;
        }
        return answer;
    }
    
    /**
     * true if and only if the registration objectâ€™s time slot
     * is between 12 and 25 inclusive
     *//*
    private boolean verifySlot(Registration r){
        Boolean answer = false;
        if (r.getTimeSlot()<=25 && r.getTimeSlot()>=12){
        answer = true;
        }
        return answer;
    }
}
 */
