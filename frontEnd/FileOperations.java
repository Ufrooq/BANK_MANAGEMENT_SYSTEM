import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FileOperations {

	File f1 = new File("Admins.ser");
	File f2 = new File("Clients.ser");

	public void addAdmin(Admin a) {
		try {

			ObjectOutputStream out;

			if (f1.exists()) {
				out = new MyObjectOutputStream(new FileOutputStream(f1, true));
			} else {
				out = new ObjectOutputStream(new FileOutputStream(f1));
			}
			out.writeObject(a);
			out.close();
		}

		catch (IOException ex) {
			System.err.println("Some Error...");
		}
	}

	public void addClient(Client c) {
		try {

			ObjectOutputStream out;

			if (f2.exists()) {
				out = new MyObjectOutputStream(new FileOutputStream(f2, true));
			} else {
				out = new ObjectOutputStream(new FileOutputStream(f2));
			}
			out.writeObject(c);
			out.close();
		}

		catch (IOException ex) {
			System.err.println("Some Error...");
			ex.printStackTrace();
		}
	}

	public void readAdminFile() {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(f1));

			while (true) {
				Admin a = (Admin) in.readObject();
				JOptionPane.showMessageDialog(null, a.toString());
			}
		} catch (EOFException eof) {
			return;
		} catch (ClassNotFoundException c) {
			System.err.println("Class not found");
		} catch (FileNotFoundException f) {
			System.err.println("File not found");
		} catch (IOException ex) {
			System.err.println("Some Error");
		}

	}

	public void readClientFile() {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(f2));

			while (true) {
				try {
					Client c = (Client) in.readObject();
					JOptionPane.showMessageDialog(null, c.toString());
				} catch (EOFException eof) {
					break;
				}
			}
		} catch (ClassNotFoundException c) {
			System.err.println("Class not found");
		} catch (FileNotFoundException f) {
			System.err.println("File not found");
		} catch (IOException ex) {
			System.err.println("Some Error");
			ex.printStackTrace();
		}
	}

	public boolean getManagerAccess(String uName, String pass) {
		Manager m = new Manager();
		if (uName.equals(m.getUserName()) && pass.equals(m.getPassword())) {
			return true;
		} else
			return false;
	}

	public boolean getAdminAccess(String uName, int pin) {
		boolean flag = false;
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(f1));

			while (true) {
				Admin a = (Admin) in.readObject();
				if (a.getUserName().equals(uName) && a.getPinCode() == pin) {
					flag = true;
					return true;
				}
			}
		} catch (EOFException eof) {
			if (flag)
				return true;
		} catch (ClassNotFoundException c) {
			System.err.println("Class not found");
		} catch (FileNotFoundException f) {
			System.err.println("File not found");
		} catch (IOException ex) {
			System.err.println("Some Error");
		} finally {
			if (!flag)
				return false;
		}
		return false;
	}

	public boolean getClientAccess(String accNum, int pin) {
		boolean flag = false;
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(f2));

			while (true) {
				Client c = (Client) in.readObject();
				if (c.getAccount().getAccountNum().equals(accNum) && c.getAccount().getPin() == pin) {
					flag = true;
					return true;
				}
			}
		} catch (EOFException eof) {
			if (flag)
				return true;
		} catch (ClassNotFoundException c) {
			System.err.println("Class not found");
		} catch (FileNotFoundException f) {
			System.err.println("File not found");
		} catch (IOException ex) {
			System.err.println("Some Error");
		} finally {
			if (!flag)
				return false;
		}
		return false;
	}

	public Client getClient(String accNum, int pin) {
		boolean flag = false;
		Client c = null;
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(f2));

			while (true) {
				c = (Client) in.readObject();
				if (c.getAccount().getAccountNum().equals(accNum) && c.getAccount().getPin() == pin) {
					flag = true;
					return c;
				}
			}
		} catch (EOFException eof) {
			if (flag)
				return c;
			else
				return c;
		} catch (ClassNotFoundException cx) {
			System.err.println("Class not found");
		} catch (FileNotFoundException f) {
			System.err.println("File not found");
		} catch (IOException ex) {
			System.err.println("Some Error");
		} finally {
			if (!flag)
				return c;
		}
		return c;
	}

	public void searchAdmin(String str) {
		boolean flag = false;
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(f1));

			while (true) {
				Admin a = (Admin) in.readObject();
				if (a.getName().equals(str) || a.getUserName().equals(str)) {
					flag = true;
					JOptionPane.showMessageDialog(null, a.toString());
				}
			}
		} catch (EOFException eof) {
			return;
		} catch (ClassNotFoundException c) {
			System.err.println("Class not found");
		} catch (FileNotFoundException f) {
			System.err.println("File not found");
		} catch (IOException ex) {
			System.err.println("Some Error");
		} finally {
			if (!flag)
				JOptionPane.showMessageDialog(null, "Admin Not Found");
		}
	}

	public void updateAdmin(String str, int pin) {
		ArrayList<Admin> list = new ArrayList<Admin>();
		boolean flag = true;
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(f1));
			while (true) {
				Admin a = (Admin) in.readObject();
				if (a.getUserName().equals(str) || a.getName().equals(str)) {
					JOptionPane.showMessageDialog(null, "Record Found!");
					a.setPinCode(pin);
					JOptionPane.showMessageDialog(null, "Updated");
					JOptionPane.showMessageDialog(null, a.toString());
					flag = false;
				}
				list.add(a);
			}

		} catch (EOFException eof) {
			// System.err.println("EOF exception");
			return;
		} catch (ClassNotFoundException c) {
			System.err.println("Class not found");
		} catch (FileNotFoundException f) {
			System.err.println("File not found");
		} catch (IOException ex) {
			System.err.println("Some Error");
			return;
		}

		finally {
			if (flag) {
				JOptionPane.showMessageDialog(null, "Record not Found");
			}

			for (int i = 0; i < list.size(); i++) {
				try {
					ObjectOutputStream out;
					if (i == 0) {
						out = new ObjectOutputStream(new FileOutputStream(f1));
					} else {
						out = new MyObjectOutputStream(new FileOutputStream(f1, true));
					}
					out.writeObject(list.get(i));
					out.close();
				} catch (IOException e) {
					System.out.println("Error");
				}
			}
		}

	}

	public void deleteAdmin(String str) {
		ArrayList<Admin> list = new ArrayList<Admin>();
		boolean flag = true;
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(f1));

			while (true) {
				Admin a = (Admin) in.readObject();
				if (a.getName().equals(str) || a.getUserName().equals(str)) {
					JOptionPane.showMessageDialog(null, "Record Found!");
					JOptionPane.showMessageDialog(null, "Deleted");
					flag = false;
					continue;
				} else {
					list.add(a);
				}
			}

		} catch (EOFException eof) {
			// System.err.println("EOF exception");
			return;
		} catch (ClassNotFoundException c) {
			System.err.println("Class not found");
		} catch (FileNotFoundException f) {
			System.err.println("File not found");
		} catch (IOException ex) {
			System.err.println("Some Error");
		}

		finally {
			if (flag) {
				JOptionPane.showMessageDialog(null, "Record not Found");
			}
			if (list.size() == 0) {
				System.out.println("deleting last item");
				try {
					ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f1));
					out.close();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} else {
				for (int i = 0; i < list.size(); i++) {
					try {
						ObjectOutputStream out;
						if (i == 0) {
							out = new ObjectOutputStream(new FileOutputStream(f1));
						} else {
							out = new MyObjectOutputStream(new FileOutputStream(f1, true));
						}
						out.writeObject(list.get(i));
						out.close();
					} catch (IOException e) {
						System.out.println("Error");
					}
				}
			}

		}
	}

	public void searchClient(String str) {
		boolean flag = false;
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(f2));

			while (true) {
				Client c = (Client) in.readObject();
				if (c.getName().equals(str) || c.getAccount().getAccountNum().equals(str)) {
					flag = true;
					JOptionPane.showMessageDialog(null, c.toString());
				}
			}
		} catch (EOFException eof) {
			return;
		} catch (ClassNotFoundException c) {
			System.err.println("Class not found");
		} catch (FileNotFoundException f) {
			System.err.println("File not found");
		} catch (IOException ex) {
			System.err.println("Some Error");
		} finally {
			if (!flag)
				JOptionPane.showMessageDialog(null, "Client Not Found");
		}
	}

	public void updateClient(String str, int pin) {
		ArrayList<Client> list = new ArrayList<Client>();
		boolean flag = true;
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(f2));
			while (true) {
				Client c = (Client) in.readObject();
				if (c.getAccount().getAccountNum().equals(str) || c.getName().equals(str)) {
					JOptionPane.showMessageDialog(null, "Record Found!");
					c.getAccount().setPin(pin);
					JOptionPane.showMessageDialog(null, "Updated");
					JOptionPane.showMessageDialog(null, c.toString());
					flag = false;
				}
				list.add(c);
			}

		} catch (EOFException eof) {
			// System.err.println("EOF exception");
			return;
		} catch (ClassNotFoundException c) {
			System.err.println("Class not found");
		} catch (FileNotFoundException f) {
			System.err.println("File not found");
		} catch (IOException ex) {
			System.err.println("Some Error");
			return;
		}

		finally {
			if (flag) {
				JOptionPane.showMessageDialog(null, "Record not Found");
			}

			for (int i = 0; i < list.size(); i++) {
				try {
					ObjectOutputStream out;
					if (i == 0) {
						out = new ObjectOutputStream(new FileOutputStream(f2));
					} else {
						out = new MyObjectOutputStream(new FileOutputStream(f2, true));
					}
					out.writeObject(list.get(i));
					out.close();
				} catch (IOException e) {
					System.out.println("Error");
				}
			}
		}

	}

	public void deleteClient(String str) {
		ArrayList<Client> list = new ArrayList<Client>();
		// Client c = null;
		boolean flag = true;
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(f2));

			while (true) {
				Client c = (Client) in.readObject();

				if (c.getName().equals(str) || c.getAccount().getAccountNum().equals(str)) {
					JOptionPane.showMessageDialog(null, "Record Found!");
					JOptionPane.showMessageDialog(null, "Deleted");
					flag = false;
					continue;
				} else {
					list.add(c);
				}
			}

		} catch (EOFException eof) {
			// System.err.println("EOF exception");
			return;
		} catch (ClassNotFoundException c) {
			System.err.println("Class not found");
		} catch (FileNotFoundException f) {
			System.err.println("File not found");
		} catch (IOException ex) {
			System.err.println("Some Error");
		}

		finally {
			if (flag) {
				JOptionPane.showMessageDialog(null, "Record not Found");
			}
			if (list.size() == 0) {
				System.out.println("deleting last item");
				try {
					ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f2));
					out.close();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			} else {
				for (int i = 0; i < list.size(); i++) {
					try {
						ObjectOutputStream out;
						if (i == 0) {
							out = new ObjectOutputStream(new FileOutputStream(f2));
						} else {
							out = new MyObjectOutputStream(new FileOutputStream(f2, true));
						}
						out.writeObject(list.get(i));
						out.close();
					} catch (IOException e) {
						System.out.println("Error");
					}
				}
			}

		}

	}

	public void updateBalance(String str, String AccountNo, double bal) {
		ArrayList<Client> list = new ArrayList<Client>();
		boolean flag = true;
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(f2));
			while (true) {
				Client c = (Client) in.readObject();
				if (c.getAccount().getAccountNum().equals(AccountNo) && c.getName().equals(str)) {
					c.getAccount().setBalance(bal);
					JOptionPane.showMessageDialog(null, "Current Balance: " + c.getAccount().getBalance() + "Rs.");
					flag = false;
				}
				list.add(c);
			}

		} catch (EOFException eof) {
			// System.err.println("EOF exception");
			return;
		} catch (ClassNotFoundException c) {
			System.err.println("Class not found");
		} catch (FileNotFoundException f) {
			System.err.println("File not found");
		} catch (IOException ex) {
			System.err.println("Some Error");
			return;
		}

		finally {
			if (flag) {
				JOptionPane.showMessageDialog(null, "Record not Found");
			}

			for (int i = 0; i < list.size(); i++) {
				try {
					ObjectOutputStream out;
					if (i == 0) {
						out = new ObjectOutputStream(new FileOutputStream(f2));
					} else {
						out = new MyObjectOutputStream(new FileOutputStream(f2, true));
					}
					out.writeObject(list.get(i));
					out.close();
				} catch (IOException e) {
					System.out.println("Error");
				}
			}
		}

	}

	public boolean ifAdminExist(String userName) {
		boolean flag = false;
		Admin a = null;
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(f1));
			while (true) {
				a = (Admin) in.readObject();
				if (a.getUserName().equals(userName)) {
					flag = true;
					return flag;
				}
			}
		} catch (EOFException eof) {
			if (flag)
				return flag;
			else
				return flag;
		} catch (ClassNotFoundException cx) {
			System.err.println("Class not found");
		} catch (FileNotFoundException f) {
			System.err.println("File not found----");
		} catch (IOException ex) {
			System.err.println("Some Error");
		} finally {
			if (!flag)
				return flag;
		}
		return flag;
	}

	public boolean ifAccountExist(String accNum) {
		boolean flag = false;
		Client c = null;
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(f2));

			while (true) {
				c = (Client) in.readObject();
				if (c.getAccount().getAccountNum().equals(accNum)) {
					flag = true;
					return flag;
				}
			}
		} catch (EOFException eof) {
			if (flag)
				return flag;
			else
				return flag;
		} catch (ClassNotFoundException cx) {
			System.err.println("Class not found");
		} catch (FileNotFoundException f) {
			System.err.println("File not found");
		} catch (IOException ex) {
			System.err.println("Some Error");
		} finally {
			if (!flag)
				return flag;
		}
		return flag;
	}

	public void display_same_pin(int pin) {
		boolean flag = false;
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(f2));

			while (true) {
				Client c = (Client) in.readObject();
				if (c.getAccount().getPin() == pin) {
					flag = true;
					JOptionPane.showMessageDialog(null, c.toString());
				}
			}

		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		} finally {
			if (!flag) {
				JOptionPane.showMessageDialog(null, "NO RECORDS FOUND OF THAT PIN");
			}
		}
	}
}