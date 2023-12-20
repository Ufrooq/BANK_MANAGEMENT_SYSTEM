import java.io.Serializable;

public class Address implements Serializable{
	private int home;
	private int street;
	private String city;


	public Address(){

	}

	public Address(int h, int s, String c){
		home = h;
		street = s;
		city = c;

	}

	// SETTERS

	public void setHome(int h){
		home = h;
	}

	public void setStreet(int s){
		street = s;

	}

	public void setCity(String c){
		city = c;
	}


	// GETTERS

	public int getHome(){
		return home;
	}	

	public int getStreet(){
		return street;
	}

	public String getCity(){
		return city;
	}

	public String toString(){
		return ("Address: "+ "House# "+home+ " , Street# "+street+ " , City "+city);
	}
}
