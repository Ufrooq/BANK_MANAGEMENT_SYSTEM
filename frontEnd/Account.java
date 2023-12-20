import java.io.Serializable;
import java.time.LocalDate;

public class Account implements Serializable {
	private String accountNum;
	private int pin;
	private double balance;
	private Date creationDate;

	public Account() {
		creationDate = new Date();
	}

	public Account(String an, int p, double b, Date d) {
		accountNum = an;
		pin = p;
		balance = b;
		LocalDate currenDate = LocalDate.now();
		creationDate = d;
		creationDate.setDay(currenDate.getDayOfMonth());
		creationDate.setMonth(currenDate.getMonthValue());
		creationDate.setYear(currenDate.getYear());
	}

	public String getAccountNum() {
		return accountNum;
	}

	public int getPin() {
		return pin;
	}

	public double getBalance() {
		return balance;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setAccountNum(String ac) {
		accountNum = ac;
	}

	public void setPin(int p) {
		pin = p;
	}

	public void setBalance(double b) {
		balance = b;
	}

	public void setCreationDate(Date d) {
		creationDate = d;
	}

	public String toString() {
		return ("Account Number: " + accountNum + "\nPin: " + pin + "\nBalance: " + balance + "\nCreation Date: "
				+ creationDate.toString());
	}

}