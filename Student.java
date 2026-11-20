 // key value pair of usn and student - hash map import 
import java.util.HashMap; 
import java.util.Map;


 // * Stores student marks and calculates CGPA.

public class Student extends Person {
    private Map<String, Integer> marks = new HashMap<>();

    public Student(String name, String usn, String dob,
                   String phone, String email, String department) {
        super(name, usn, dob, phone, email, department);
    }

    @Override
    public String getRole() {
        return "Student";
    }

    // Add or to update marks for a subject.
    public void addMarks(String subject, int score) throws MarksException {
        if (score < 0 || score > 100) {
            throw new MarksException("Marks must be between 0 and 100.");
        }
        marks.put(subject, score);
    }

    // Convert marks into grade points considering the 1-10 as 1 gradepoint
    private int gradePoint(int score) {
        if (score >= 90) return 10;
        if (score >= 80) return 9;
        if (score >= 70) return 8;
        if (score >= 60) return 7;
        if (score >= 50) return 6;
        if (score >= 40) return 5;
        return 0;
    }

    //  average grade points total grade by total subjects
    public double getCgpa() {
        if (marks.isEmpty()) {
            return 0;
        }

        int total = 0;
        for (int score : marks.values()) {
            total += gradePoint(score);
        }

        return (double) total / marks.size();
    }

    // Display  student's report card.
    public void printReport() {
        System.out.println("\n===== STUDENT REPORT CARD =====");
        System.out.println("Name       : " + getName());
        System.out.println("USN        : " + getUsn());
        System.out.println("DOB        : " + getDob());
        System.out.println("Phone      : " + getPhone());
        System.out.println("Email      : " + getEmail());
        System.out.println("Department : " + getDepartment());
        System.out.println("--------------------------------");

        for (Map.Entry<String, Integer> entry : marks.entrySet()) {
            int score = entry.getValue();
            System.out.println(entry.getKey() + " : " + score
                    + " (Grade Point: " + gradePoint(score) + ")");
        }

        System.out.println("--------------------------------");
        System.out.printf("CGPA : %.2f%n", getCgpa());
        System.out.println("================================");
       
    }
}
