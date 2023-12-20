public class Client extends Person {

	private Address adrs;
	private Account acc;

	public Client() {
		super();
		adrs = new Address();
		acc = new Account();
	}

	public Client(String n, int a, String g, Address adrs, Account acc, int day, int month, int year) {
		super(n, a, g, day, month, year);
		this.adrs = adrs;
		this.acc = acc;
	}

	public Address getAddress() {
		return adrs;
	}

	public Account getAccount() {
		return acc;
	}

	public void setAddress(Address a) {
		adrs = a;
	}

	public void setAccount(Account a) {
		acc = a;
	}

	// public boolean getAccess(String u, int p) {
	// if (u != null) {
	// return (acc.getAccountNum().equals(u) && acc.getPin() == p);
	// } else
	// return false;
	// }

	public String toString() {
		return super.toString() + "\n" + adrs.toString() + "\n" + acc.toString();
	}

}