package JAVA_OOPS_statements;

interface LibraryOperations {
	void issueBook(String bookTitle);
	void returnBook(String bookTitle) throws InvalidBookOperationException;
}

abstract class LibraryAccount implements LibraryOperations {
	private String memberId;
	private String memberName;
	private int issuedBookCount;

	public LibraryAccount(String memberId, String memberName) {
		this.memberId = memberId;
		this.memberName = memberName;
		this.issuedBookCount = 0;
	}

	protected abstract int getMaxBookLimit();
	public String getMemberId() {
		return memberId;
	}
	public String getMemberName() {
		return memberName;
	}

	public int getIssuedBookCount() {
		return issuedBookCount;
	}

	@Override
	public void issueBook(String bookTitle) {
		if (issuedBookCount >= getMaxBookLimit()) {
			throw new BookLimitExceededException("Limit reached! Max allowed: " + getMaxBookLimit());
		}
		issuedBookCount++;
		System.out.println("Success: '" + bookTitle + "' issued to " + memberName + ". (Total: " + issuedBookCount + ")");
	}

	public void issueBook(String bookTitle, boolean isPriority) {
		System.out.println("[Priority Request]");
		issueBook(bookTitle); 
	}

	@Override
	public void returnBook(String bookTitle) throws InvalidBookOperationException {
		if (issuedBookCount <= 0) {
			throw new InvalidBookOperationException("Cannot return book. No books are currently issued.");
		}
		issuedBookCount--;
		System.out.println("Success: '" + bookTitle + "' returned by " + memberName + ". (Total: " + issuedBookCount + ")");
	}

	public void returnBook(String bookTitle, boolean isDamaged) throws InvalidBookOperationException {
		if (isDamaged) {
			System.out.println("ALERT: Fine charged for damaged book: " + bookTitle);
		}
		returnBook(bookTitle); 
	}
}

class StudentMember extends LibraryAccount {
	public StudentMember(String memberId, String memberName) {
		super(memberId, memberName);
	}

	@Override
	protected int getMaxBookLimit() {
		return 3; 
	}
}

class FacultyMember extends LibraryAccount {
	public FacultyMember(String memberId, String memberName) {
		super(memberId, memberName);
	}

	@Override
	protected int getMaxBookLimit() {
		return 10; 
	}
}

class InvalidBookOperationException extends Exception {
	public InvalidBookOperationException(String message) {
		super(message);
	}
}

class BookLimitExceededException extends RuntimeException {
	public BookLimitExceededException(String message) {
		super(message);
	}
}

public class SecureLibraryBookTransactionSystem {
	public static void main(String[] args) {
		LibraryAccount student = new StudentMember("99", "Anirban");
		LibraryAccount faculty = new FacultyMember("100", "Subarna");
		System.out.println("LIBRARY SYSTEM SIMULATION");
		System.out.println("Student Operations");
		try {
			student.issueBook("Data Structures");
			student.issueBook("Operating Systems");
			student.issueBook("Natural Language", true);
			student.issueBook("Database Management"); 
		} catch (BookLimitExceededException e) {
			System.out.println("Exception Caught: " + e.getMessage());
		}
		System.out.println("Faculty Operations");
		try {
			faculty.issueBook("Advanced AI Research");
			faculty.returnBook("Advanced AI Research", true); 
			faculty.returnBook("Nano Carbon Fibres");
		} catch (InvalidBookOperationException e) {
			System.out.println("Exception Caught: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("General Error: " + e.getMessage());
		}
	}
}