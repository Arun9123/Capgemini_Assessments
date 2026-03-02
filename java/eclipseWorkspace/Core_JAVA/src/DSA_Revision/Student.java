package DSA_Revision;

import java.time.LocalDate;
import java.time.LocalTime;

public final class Student implements Comparable<Student>{
	private int studentId;
	private String studentName;
	private String email;
	private String gender;
	private Long phone;
	private LocalDate dateOfBirth;
	private LocalTime timeOfBirth;
	private double fees;
	
	public Student() {
		super();
	}

	public Student(int studentId, String studentName, String email, String gender, Long phone, LocalDate dateOfBirth,
			LocalTime timeOfBirth, double fees) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.email = email;
		this.gender = gender;
		this.phone = phone;
		this.dateOfBirth = dateOfBirth;
		this.timeOfBirth = timeOfBirth;
		this.fees = fees;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public LocalTime getTimeOfBirth() {
		return timeOfBirth;
	}

	public void setTimeOfBirth(LocalTime timeOfBirth) {
		this.timeOfBirth = timeOfBirth;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		long temp;
		temp = Double.doubleToLongBits(fees);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + studentId;
		result = prime * result + ((studentName == null) ? 0 : studentName.hashCode());
		result = prime * result + ((timeOfBirth == null) ? 0 : timeOfBirth.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Student))
			return false;
		Student other = (Student) obj;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (Double.doubleToLongBits(fees) != Double.doubleToLongBits(other.fees))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (studentId != other.studentId)
			return false;
		if (studentName == null) {
			if (other.studentName != null)
				return false;
		} else if (!studentName.equals(other.studentName))
			return false;
		if (timeOfBirth == null) {
			if (other.timeOfBirth != null)
				return false;
		} else if (!timeOfBirth.equals(other.timeOfBirth))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", email=" + email + ", gender="
				+ gender + ", phone=" + phone + ", dateOfBirth=" + dateOfBirth + ", timeOfBirth=" + timeOfBirth
				+ ", fees=" + fees + "]";
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return o.getStudentId() - this.getStudentId();
	}
	
}

