/**
 * Abstract class containing common student details.
 */
public abstract class Person {
    private String name;
    private String usn;
    private String dob;
    private String phone;
    private String email;
    private String department;

    public Person(String name, String usn, String dob,
                  String phone, String email, String department) {
        this.name = name;
        this.usn = usn;
        this.dob = dob;
        this.phone = phone;
        this.email = email;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getUsn() {
        return usn;
    }

    public String getDob() {
        return dob;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }

    public abstract String getRole();
}
