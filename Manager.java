import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages student records and ranking.
 */
public class Manager {
    private Map<String, Student> students = new HashMap<>();

    // Add a student using USN as the unique key.
    public void addStudent(String name, String usn, String dob,
                           String phone, String email, String department) {
        students.put(usn, new Student(name, usn, dob, phone, email, department));
    }

    // Find a student using USN.
    public Student findStudent(String usn) throws StudentException {
        Student student = students.get(usn);

        if (student == null) {
            throw new StudentException("Student not found: " + usn);
        }

        return student;
    }

    // Return all student records.
    public List<Student> getStudentRecords() {
        return new ArrayList<>(students.values());
    }

    // Arrange students by CGPA using insertion sort.
    public List<Student> getRankList() {
        List<Student> list = getStudentRecords();

        for (int i = 1; i < list.size(); i++) {
            Student current = list.get(i);
            int j = i - 1;

            while (j >= 0 && list.get(j).getCgpa() < current.getCgpa()) {
                list.set(j + 1, list.get(j));
                j--;
            }

            list.set(j + 1, current);
        }

        return list;
    }
}
