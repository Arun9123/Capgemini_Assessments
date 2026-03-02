package JAVA_OOPS_statements;

interface EvaluationOperations {
	void evaluate(int obtainedMarks) throws InvalidMarksException;
	String generateResult();
}

abstract class ExamEvaluation implements EvaluationOperations {
	private String studentId;
	private String studentName;
	private int marks;
	private boolean isResultLocked;

	public ExamEvaluation(String studentId, String studentName) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.marks = 0;
		this.isResultLocked = false;
	}

	protected abstract int getMaxScore();
	protected abstract String calculateGrade(int marks);

	public String getStudentName() {
		return studentName;
	}

	protected void setMarks(int marks) {
		this.marks = marks;
	}

	protected int getMarks() {
		return this.marks;
	}

	@Override
	public void evaluate(int obtainedMarks) throws InvalidMarksException {
		if (isResultLocked) {
			throw new ResultTamperingException("Security Alert: Attempt to modify finalized result for " + studentId);
		}
		if (obtainedMarks < 0 || obtainedMarks > getMaxScore()) {
			throw new InvalidMarksException("Invalid Input: Marks must be between 0 and " + getMaxScore());
		}
		this.marks = obtainedMarks;
		this.isResultLocked = true; 
		System.out.println("Success: Marks recorded for " + studentName + ". Result Locked.");
	}

	public void evaluate(int obtainedMarks, String remarks) throws InvalidMarksException {
		System.out.println("[Evaluator Note]: " + remarks);
		evaluate(obtainedMarks); 
	}

	@Override
	public String generateResult() {
		return "ID: " + studentId + " | Name: " + studentName + " | Grade: " + calculateGrade(this.marks);
	}
}

class ObjectiveExam extends ExamEvaluation {
	public ObjectiveExam(String id, String name) {
		super(id, name);
	}

	@Override
	protected int getMaxScore() {
		return 100;
	}

	@Override
	protected String calculateGrade(int marks) {
		return (marks >= 40) ? "PASS" : "FAIL";
	}
}

class SubjectiveExam extends ExamEvaluation {
	public SubjectiveExam(String id, String name) {
		super(id, name);
	}

	@Override
	protected int getMaxScore() {
		return 50; 
	}

	@Override
	protected String calculateGrade(int marks) {
		if (marks >= 45) return "A (Decent)";
		if (marks >= 30) return "B (Not Decent)";
		return "C (Fail)";
	}
}

class InvalidMarksException extends Exception {
	public InvalidMarksException(String message) {
		super(message);
	}
}

class ResultTamperingException extends RuntimeException {
	public ResultTamperingException(String message) {
		super(message);
	}
}

public class SecureOnlineExamEvaluationEngine {
	public static void main(String[] args) {
		System.out.println("EXAM EVALUATION SYSTEM");
		ExamEvaluation objExam = new ObjectiveExam("1007", "Anirban");
		ExamEvaluation subExam = new SubjectiveExam("1072", "Subarna");
		System.out.println("Objective Exam");
		try {
			objExam.evaluate(85, "OMR Sheet Verified");
			System.out.println(objExam.generateResult());

		} catch (InvalidMarksException e) {
			System.out.println("Error: " + e.getMessage());
		}
		System.out.println("Security Check");
		try {
			System.out.println("Attempting to update marks to 95");
			objExam.evaluate(95); 
		} catch (ResultTamperingException e) {
			System.out.println("SECURITY EXCEPTION: " + e.getMessage());
		} catch (InvalidMarksException e) {
			System.out.println("Error: " + e.getMessage());
		}
		System.out.println("Subjective Exam");
		try {
			System.out.println("Attempting to assign 90 marks (Max is 50)");
			subExam.evaluate(90); 
		} catch (InvalidMarksException e) {
			System.out.println("VALIDATION ERROR: " + e.getMessage());
		}
		try {
			subExam.evaluate(48);
			System.out.println(subExam.generateResult());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}