public class Admin extends Person {
	private String userName;
	private int pinCode;
	private int adminId;

	public Admin() {
		super();
	}

	public Admin(String n, int a, String g, String u, int p, int d, int m, int y, int admin_id) {
		super(n, a, g, d, m, y);
		userName = u;
		pinCode = p;
		adminId = admin_id;
	}

	public String getUserName() {
		return userName;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setUserName(String u) {
		userName = u;
	}

	public void setPinCode(int p) {
		pinCode = p;
	}

	public void setadminId(int a) {
		adminId = a;
	}

	public int getadminId() {
		return adminId;
	}

	public String toString() {
		return super.toString() + "\nUserName: " + userName + "\nPinCode: " + pinCode;
	}

	// public boolean getAccess(String u, int p) {
	// if (u != null) {
	// return (u.equals(userName) && pinCode == p);
	// } else
	// return false;
	// }

}