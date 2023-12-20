public class Manager extends Person {
	private String userName;
	private String password;

	public Manager() {
		super("Umar", 19, "Male", 11, 9, 2004);
		userName = "Umar125";
		password = "edurome";
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

}