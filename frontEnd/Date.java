import java.io.Serializable;

public class Date implements Serializable {
	private int day;
	private int month;
	private int year;

	public Date() {

	}

	public Date(int d, int m, int y) {
		if (d > 0 && d <= 31)
			day = d;
		else {
			System.out.println("Invalid date so set to 1");
			day = 1;
		}

		if (m > 0 && m <= 12)
			month = m;
		else {
			System.out.println("Invalid month so set to 1");
			month = 1;
		}

		if (y > 2000 && y <= 2022)
			year = y;
		else {
			System.out.println("Invalid year so set to 2000");
			year = 2000;
		}
	}

	// public void setDay(int d) {
	// if (d > 0 && d <= 31)
	// day = d;
	// else {
	// System.out.println("Invalid date so set to 1");
	// day = 1;
	// }
	// }

	// public void setMonth(int m) {
	// if (m > 0 && m <= 12)
	// month = m;
	// else {
	// System.out.println("Invalid month so set to 1");
	// month = 1;
	// }
	// }

	// public void setYear(int y) {
	// if (y > 2000 && y <= 2022)
	// year = y;
	// else {
	// System.out.println("Invalid year so set to 2000");
	// year = 2000;
	// }
	// }

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	public void setDay(int d) {
		day = d;
	}

	public void setMonth(int m) {
		month = m;
	}

	public void setYear(int y) {
		year = y;
	}

	public String toString() {
		return (day + "/" + month + "/" + year);
	}
}
