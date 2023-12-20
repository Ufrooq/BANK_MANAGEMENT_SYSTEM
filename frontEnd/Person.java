import java.io.Serializable;

public abstract class Person implements Serializable {
	private String name;
	private String gender;
	private int age;

	// for date of birth
	private int day;
	private int month;
	private int year;

	public Person() {

	}

	public Person(String n, int a, String g, int d, int m, int y) {
		name = n;
		age = a;
		gender = g;
		day = d;
		year = y;
		month = m;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public void setName(String n) {
		name = n;
	}

	public void setAge(int a) {
		age = a;
	}

	public void setGender(String g) {
		gender = g;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	// public abstract boolean getAccess(String u, int p);

	public String toString() {
		return "Name: " + name + "\nAge: " + age + "\nGender: " + gender + "\nDOB:: Day : " + day + ", Month : " + month
				+ " ,Year : " + year;
	}
}
