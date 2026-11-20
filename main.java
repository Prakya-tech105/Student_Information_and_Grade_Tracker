import java.util.List;
import java.util.Scanner;

/**
 * Main menu for Student Information and Grade Tracker.
 */
public class main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== STUDENT GRADE TRACKER =====");
            System.out.println("1. Add Student");
            System.out.println("2. Add Marks");
            System.out.println("3. Display Student Records");
            System.out.println("4. View Report Card");
            System.out.println("5. View Rank List");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            String choice = sc.nextLine().trim();

            try {
                if (choice.equals("1")) {
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine().trim();

                    System.out.print("Enter USN: ");
                    String usn = sc.nextLine().trim();

                    System.out.print("Enter Date of Birth (DD-MM-YYYY): ");
                    String dob = sc.nextLine().trim();

                    System.out.print("Enter Phone Number: ");
                    String phone = sc.nextLine().trim();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine().trim();

                    System.out.print("Enter Department: ");
                    String department = sc.nextLine().trim();

                    manager.addStudent(name, usn, dob, phone, email, department);
                    System.out.println("Student added successfully.");
                }
                else if (choice.equals("2")) {
                    System.out.print("Enter USN: ");
                    Student student = manager.findStudent(sc.nextLine().trim());

                    System.out.print("Enter Subject: ");
                    String subject = sc.nextLine().trim();

                    System.out.print("Enter Marks (0-100): ");
                    int score = Integer.parseInt(sc.nextLine().trim());

                    student.addMarks(subject, score);
                    System.out.println("Marks saved successfully.");
                }
                else if (choice.equals("3")) {
                    List<Student> records = manager.getStudentRecords();

                    if (records.isEmpty()) {
                        System.out.println("No student records available.");
                    } else {
                        System.out.println("\\n===== STUDENT RECORDS =====");
                        for (Student student : records) {
                            System.out.println("Name       : " + student.getName());
                            System.out.println("USN        : " + student.getUsn());
                            System.out.println("DOB        : " + student.getDob());
                            System.out.println("Phone      : " + student.getPhone());
                            System.out.println("Email      : " + student.getEmail());
                            System.out.println("Department : " + student.getDepartment());
                            System.out.printf("CGPA       : %.2f%n", student.getCgpa());
                            System.out.println("--------------------------------");
                        }
                    }
                }
                else if (choice.equals("4")) {
                    System.out.print("Enter USN: ");
                    Student student = manager.findStudent(sc.nextLine().trim());
                    student.printReport();
                }
                else if (choice.equals("5")) {
                    List<Student> list = manager.getRankList();

                    if (list.isEmpty()) {
                        System.out.println("No student records available.");
                    } else {
                        System.out.println("\\n===== STUDENT RANK LIST =====");
                        int rank = 1;

                        for (Student student : list) {
                            System.out.printf("%d. %s (%s) - CGPA: %.2f%n",
                                    rank++,
                                    student.getName(),
                                    student.getUsn(),
                                    student.getCgpa());
                        }
                    }
                }
                else if (choice.equals("6")) {
                    System.out.println("Thank you!");
                    break;
                }
                else {
                    System.out.println("Invalid choice. Try again.");
                }
            }
            catch (StudentException | MarksException e) {
                System.out.println("Error: " + e.getMessage());
            }
            catch (NumberFormatException e) {
                System.out.println("Please enter a valid number for marks.");
            }
        }

        sc.close();
    }
}
