import java.util.Scanner;

/**
 * This is the person class which holds all the information
 * to create a new person object.
 */

public class Person {
	// Instance variables used for creating a new person.
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private String address;

	// Getters and Setters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	// default constructor
	public Person() {
		contact();
	}

	// Captures new person information
	public void contact() {
		Scanner input = new Scanner(System.in);

		System.out.print("First Name: ");
		firstName = input.nextLine();

		System.out.print("Last Name: ");
		lastName = input.nextLine();

		System.out.print("Phone: ");
		phone = input.nextLine();

		System.out.print("Email: ");
		email = input.nextLine();

		System.out.print("Address: ");
		address = input.nextLine();
	
	}

	// toString displays the Person object data
	public String toString() {
		String output = "Name: " + firstName + " " + lastName;
		output += "\nPhone: " + phone;
		output += "\nEmail: " + email;
		output += "\nAddress: " + address;
		return output;
	}

}