import java.text.*;
import java.time.LocalDate;

/**
 * This is the project class which holds all the information
 * to create a new project object.
 * 
 */

public class Project {
	// Instance variables used to create a new project.
	private static String companyName;
	private static String projId;
	private String projName;
	private String structType;
	private String structAddress;
	private String erfNum;
	private String dueD;
	private String projStatus;
	private boolean finalised = false;
	private static String invNum;
	private double invTotal;
	private double invBalance = 0;
	private double payment = 0;
	private Person customer;
	private Person contractor;
	private Person architect;
	private static int id = 1000;
	private static int counter = 100;
	public LocalDate todayD = LocalDate.now();
	public NumberFormat fmt = NumberFormat.getCurrencyInstance();

	// Getters and Setters
	public static String getProjId() {
		return projId;
	}
	
	public void setProjId(String projId) {
		Project.projId = projId;
	}
	
	public String getProjName() {
		return projName;
	}

	public String getStructType() {
		return structType;
	}

	public String getDueD() {
		return dueD;
	}

	public void setDueD(String dueD) {
		this.dueD = dueD;
	}
	
	public String getProjStatus() {
		return projStatus;
	}
	
	public void setProjStatus(String projStatus) {
		this.projStatus = projStatus;
	}
	
	public void setFinalised(boolean finalised) {
		this.finalised = finalised;
	}

	public double getInvTotal() {
		return invTotal;
	}

	public double getInvBalance() {
		return invBalance;
	}
	
	public void setProjName(String projName) {
		this.projName = projName;
	}

	public Person getCustomer() {
		return customer;
	}
	
	public void setCustomer(Person customer) {
		this.customer = customer;
	}

	public Person getContractor() {
		return contractor;
	}
	
	public void setContractor(Person contractor) {
		this.contractor = contractor;
	}

	public Person getArchitect() {
		return architect;
	}
	
	public void setArchitect(Person architect) {
		this.architect = architect;
	}


	// default constructor
	public Project() {
		// here
	}

	// Add project details
	public Project(String projName, String structType, String structAddress, String erfNum, String dueD,
			String projStatus, double invTotal, Person customer, Person contractor, Person architect) {
		companyName = "Poised";
		this.projName = projName;
		this.structType = structType;
		this.structAddress = structAddress;
		this.erfNum = erfNum;
		this.dueD = dueD;
		this.projStatus = projStatus;
		this.invTotal = invTotal;
		this.invBalance = invTotal;
		id++;
		projId = companyName.toUpperCase() + "-" + id; // Creates project id
		counter++;
		invNum = "INV" + counter; // Creates invoice number
		this.customer = customer;
		this.contractor = contractor;
		this.architect = architect;
		customProjName(); // Sets project name if empty
	}

	// If the project name is empty then generate with structureType +
	// customerLastName.
	public void customProjName() {
		if (projName.isEmpty()) {
			this.projName = getStructType() + " " + customer.getLastName();
		}
	}

	// Make a payment
	public void invPayment(double payment) {
		this.invBalance = invBalance - payment;
	}

	// Invoice
	public void invGen() {
		System.out.print("\nInvoice from POISED\n--------------------------------");
		System.out.print("\nInvoice Date: " + todayD);
		System.out.print("\nInvoice Number: " + invNum);
		System.out.print("\n\nTo: " + customer.getFirstName() + " " + customer.getLastName());
		System.out.print("\nPhone: " + customer.getPhone());
		System.out.print("\nEmail: " + customer.getEmail());
		System.out.print("\nAddress: " + customer.getAddress());
		System.out.print("\n--------------------------------\nInvoice Total: " + fmt.format(invTotal));
		System.out.print("\nAmount Owed: " + fmt.format(invBalance) + "\n");
	}

	// Gets today's date
	public LocalDate todayD() {
		LocalDate date = LocalDate.now();
		date = LocalDate.now();
		return date;
	}

	// Makes project final
	public void makeFinal() {
		setFinalised(true);
		setProjStatus("Finalised on " + todayD);
	}

	// Makes project in progress
	public void makeInProg() {
		setFinalised(false);
		setProjStatus("In Progress");
	}

	// toString displays the Project summary
	public String toString() {
		String output = "\nProject ID: " + projId;
		output += "\nProject Name: " + projName;
		output += "\nProject status: " + projStatus;
		output += "\n";
		output += "\nStructure Type: " + structType;
		output += "\nStructure Address: " + structAddress;
		output += "\nERF Number: " + erfNum;
		output += "\nProject Due Date: " + dueD;
		output += "\n";
		output += "\nInvoice Number: " + invNum;
		output += "\nInvoice Total: " + fmt.format(invTotal);
		output += "\nInvoice Balance: " + fmt.format(invBalance);
		output += "\n\nCustomer Details\n--------------------------------";
		output += "\n" + customer;
		output += "\n\nContractor Details\n--------------------------------";
		output += "\n" + contractor;
		output += "\n\nArchitect Details\n--------------------------------";
		output += "\n" + architect;
		return output;
	}

}
