import java.util.Scanner;

/**
 * This is a Project Management System for an engineering firm called Poised. It
 * tracks all project details along with the person contact details who are
 * working on it. It also tracks the payments and invoicing for each project.
 */

public class Main {

	public int menu;
	public static Project newProject = new Project();

	// Captures new project information
	public static void newProject() {
		Scanner input = new Scanner(System.in);

		// Adds project details
		System.out.print("Project Name: ");
		String projName = input.nextLine();

		System.out.print("Structure Type: ");
		String structType = input.nextLine();

		System.out.print("Structure Address: ");
		String structAddress = input.nextLine();

		System.out.print("ERF Number: ");
		String erfNum = input.nextLine();

		System.out.print("Due Date (YYYY-MM-DD): ");
		String dueD = input.nextLine();

		System.out.print("Invoice Total: R ");
		double invTotal = input.nextDouble();

		System.out.println("\nAdd Customer\n--------------------------------");
		Person customer = new Person();

		System.out.println("\nAdd Contractor\n--------------------------------");
		Person contractor = new Person();

		System.out.println("\nAdd Architect\n--------------------------------");
		Person architect = new Person();

		String inv = "";
		String projStatus = "In Progress";
		String finalD = "";

		newProject = new Project(projName, structType, structAddress, erfNum, dueD, projStatus, invTotal, customer,
				contractor, architect);
	}

	public static void main(String[] args) {
		int menu = 0;
		System.out.println("\nPoised Project Management System");
		do {
			// Main Menu
			Scanner input = new Scanner(System.in);
			System.out.println("\nMain Menu\n--------------------------------");
			System.out.print("1 - Add Project \n");
			System.out.print("2 - View Project\n");
			System.out.print("3 - Add Payment\n");
			System.out.print("4 - Edit Due Date\n");
			System.out.print("5 - Edit Contractor\n");
			System.out.print("6 - Project Status\n");
			System.out.print("7 - Exit\n");
			System.out.print("Enter your selection: ");
			menu = input.nextInt();
			input.nextLine();
			
			switch (menu) {

			case 1:
				// Creates a new project
				System.out.print("\nAdd New Project\n--------------------------------\n");
				newProject();
				newProject.toString();
				
				break;

			case 2:
				do {
					if (Project.getProjId() == null) {
						System.out.print("\nNo project - please add one.\n");
					} else {
						System.out.println(newProject);
					}
					
					break;
					
				} while (menu == 2);
				
				break;

			case 3:
				// Make a customer payment
				// Checks if no projects before adding a payment
				do {
					if (Project.getProjId() == null) {
						System.out.print("\nNo project - please add one.\n");
					} else {
						System.out.println("\nAdd Payment\n--------------------------------");
						System.out.print("Invoice Total: " + newProject.fmt.format(newProject.getInvTotal()));
						System.out.print("\nAmount Owed: " + newProject.fmt.format(newProject.getInvBalance()));
						System.out.print("\nEnter payment amount: R ");
						double userInputDbl = input.nextDouble();
						double payment = userInputDbl;
						newProject.invPayment(payment);
						System.out.println("New Balance: " + newProject.fmt.format(newProject.getInvBalance()));
					}
					
					break;
					
				} while (menu == 3);
				
				break;

			case 4:
				// Updates the due date
				// Checks if no projects before updating due date
				do {
					if (Project.getProjId() == null) {
						System.out.print("\nNo project - please add one.\n");
					} else {
						System.out.println("\nEdit Due Date\n--------------------------------");
						System.out.print("Current due date: " + newProject.getDueD());
						System.out.print("\nEnter new date (YYYY-MM-DD): ");
						String dueD = input.nextLine();
						newProject.setDueD(dueD);
						System.out.print("\nSuccessfully updated to " + dueD + "\n");
					}
					
					break;
					
				} while (menu == 4);
				
				break;

			case 5:
				// Updates the contractor details
				// Checks if no projects before updating details
				do {
					if (Project.getProjId() == null) {
						System.out.print("\nNo project - please add one.\n");
					} else {

						do {
							System.out.println("\nEdit Contractor Details\n--------------------------------");
							System.out.print("1 - Update First Name\n");
							System.out.print("2 - Update Last Name\n");
							System.out.print("3 - Update Phone\n");
							System.out.print("4 - Update Email\n");
							System.out.print("5 - Update Address\n");
							System.out.print("6 - Main Menu\n");
							System.out.print("Enter your selection: ");
							String in = input.nextLine();
							menu = Integer.valueOf(in);
							switch (menu) {

							case 1:
								System.out.print("\nUpdate First Name: ");
								String firstName = input.nextLine();
								newProject.getContractor().setFirstName(firstName);
								break;

							case 2:
								System.out.print("\nUpdate Last Name: ");
								String lastName = input.nextLine();
								newProject.getContractor().setLastName(lastName);
								break;

							case 3:
								System.out.print("\nUpdate Phone: ");
								String phone = input.nextLine();
								newProject.getContractor().setPhone(phone);
								break;

							case 4:
								System.out.print("\nUpdate Email: ");
								String email = input.nextLine();
								newProject.getContractor().setEmail(email);
								break;

							case 5:
								System.out.print("\nUpdate Address: ");
								String address = input.nextLine();
								newProject.getContractor().setAddress(address);
								break;

							case 6:
								break;

							default:
								System.out.println(menu + " is not a valid Menu option. Please try again.");
							}

						} while (menu != 6);
					}
					
					break;
					
				} while (menu == 5);
				
				break;

			case 6:
				// Makes the project final
				do {
					if (Project.getProjId() == null) {
						System.out.print("\nNo project - please add one.\n");
					} else {
						do {
							System.out.println("\nSet Project Status\n--------------------------------");
							System.out.print("1 - Finalised \n");
							System.out.print("2 - In Progress\n");
							System.out.print("3 - Main Menu\n");
							System.out.print("Enter your selection: ");
							String in = input.nextLine();
							menu = Integer.valueOf(in);
							switch (menu) {
							
							case 1:
								// Sets project status to "Finalised on todayD" and generates invoice if
								// invBalance > 0
								newProject.makeFinal();
								System.out.print("\nProject set to: " + newProject.getProjStatus() + "\n");

								if (newProject.getInvBalance() > 0) {
									newProject.getInvBalance();
									// Prints invoice to screen - later this will generate txt file
									newProject.invGen();
								} else {
									newProject.getInvBalance();
								}
								break;

							case 2:
								// Sets project status to "In Progress"
								newProject.makeInProg();
								System.out.print("\nProject set to: " + newProject.getProjStatus() + "\n");
								break;

							case 3:
								break;

							default:
								System.out.println(menu + " is not a valid Menu option. Please try again.");
							}
							
						} while (menu != 3);
					}
					
					break;
					
				} while (menu == 6);
				
				break;

			case 7:
				// Quits the program
				System.out.println("Exiting program...");
				System.exit(0);
				
				break;

			default:
				System.out.println(menu + " is not a valid Menu option. Please try again.");
			}

		} while (menu != 7);

	}

}
