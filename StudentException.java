/**incase when we enter usn and there is no such student in the record
 * Exception raised when a student is not found.
 */
public class StudentException extends Exception {
    public StudentException(String message) {
        super(message);
    }
}
