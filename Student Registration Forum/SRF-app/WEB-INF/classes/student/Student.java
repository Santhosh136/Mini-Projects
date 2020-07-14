package student;

public class Student {
	int regno;
	String name;
	String dob;
	String dept;
	String gender;
	String passwd;
	String verify;

	public Student(int regno,String name,String dob,String dept,String gender, String passwd, String verify) {
		this.regno = regno;
		this.name = name;
		this.dob = dob;
		this.dept = dept;
		this.gender = gender;
		this.passwd = passwd;
		this.verify = verify;
	}

	public int getRegNo() {
		return this.regno;
	}

	public String getName() {
		return this.name;
	}

	public String getDOB() {
		return this.dob;
	}

	public String getDept() {
		return this.dept;
	}

	public String getGender() {
		return this.gender;
	}

	public String getPasswd() {
		return this.passwd;
	}

	public String getVerify() {
		return this.verify;
	}
}