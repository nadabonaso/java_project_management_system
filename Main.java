import java.util.Scanner;

/**
 * This is a Project Management System for an engineering firm called Poised. It
 * tracks all project details along with the person contact details who are
 * working on it. It also tracks the payments and invoicing for each project.
 */
public class Main {

	public int choice;
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
		Scanner input = new Scanner(System.in);
		int choice;

		do {
			// Main Menu
			System.out.println("\nMain Menu\n--------------------------------");
			System.out.print("1 - New Project \n");
			System.out.print("2 - View Project\n");
			System.out.print("3 - Add Payment\n");
			System.out.print("4 - Edit Due Date\n");
			System.out.print("5 - Edit Contractor\n");
			System.out.print("6 - Finalise Project\n");
			System.out.print("7 - Exit\n");
			System.out.print("Enter your selection: ");
			choice = input.nextInt();
			switch (choice) {

			case 1:
				// Creates a new project
				System.out.print("\nAdd New Project\n--------------------------------\n");
				newProject();
				newProject.toString();

				break;

			case 2:
				// Prints out a project summary
				// Checks if no projects before viewing the summary
				if (Project.getProjId() == null) {
					System.out.print("\nNo project - please add one.\n");
				} else {
					System.out.println(newProject);
				}

				break;

			case 3:
				// Make a customer payment
				// Checks if no projects before adding a payment
				if (Project.getProjId() == null) {
					System.out.print("\nNo project - please add one.\n");
				} else {
					System.out.println("\nAdd Payment\n--------------------------------");
					System.out.print("Invoice Total: " + newProject.fmt.format(newProject.getInvTotal()));
					System.out.print("\nAmount Owed: " + newProject.fmt.format(newProject.getInvBalance()));
					System.out.print("\nEnter payment amount: R ");
					double payment = input.nextDouble();
					newProject.invPayment(payment);
					System.out.println("New Balance: " + newProject.fmt.format(newProject.getInvBalance()));
				}

				break;

			case 4:
				// Updates the due date
				// Checks if no projects before updating due date
				if (Project.getProjId() == null) {
					System.out.print("\nNo project - please add one.\n");
				} else {
					System.out.println("\nEdit Due Date\n--------------------------------");
					Scanner updateD = new Scanner(System.in);
					System.out.print("Current due date: " + newProject.getDueD());
					System.out.print("\nEnter new date (YYYY-MM-DD): ");
					String dueD = updateD.nextLine();
					newProject.setDueD(dueD);
					System.out.print("\nSuccessfully updated to " + dueD + "\n");
				}

				break;

			case 5:
				// Updates the contractor details
				// Checks if no projects before updating details
				if (Project.getProjId() == null) {
					System.out.print("\nNo project - please add one.\n");
				} else {

					do {
						System.out.println("\nEdit Contractor Details\n--------------------------------");
						Scanner updateC = new Scanner(System.in);
						System.out.print("1 - Update First Name\n");
						System.out.print("2 - Update Last Name\n");
						System.out.print("3 - Update Phone\n");
						System.out.print("4 - Update Email\n");
						System.out.print("5 - Update Address\n");
						System.out.print("6 - Main Menu\n");
						System.out.print("Enter your selection: ");
						String in = updateC.nextLine();
						choice = Integer.valueOf(in);

						if (choice == 1) {
							System.out.print("\nUpdate First Name: ");
							String firstName = updateC.nextLine();
							newProject.getContractor().setFirstName(firstName);
						}

						else if (choice == 2) {
							System.out.print("\nUpdate Last Name: ");
							String lastName = updateC.nextLine();
							newProject.getContractor().setLastName(lastName);
						}

						else if (choice == 3) {
							System.out.print("\nUpdate Phone: ");
							String phone = updateC.nextLine();
							newProject.getContractor().setPhone(phone);
						}

						else if (choice == 4) {
							System.out.print("\nUpdate Email: ");
							String email = updateC.nextLine();
							newProject.getContractor().setEmail(email);
						}

						else if (choice == 5) {
							System.out.print("\nUpdate Address: ");
							String address = updateC.nextLine();
							newProject.getContractor().setAddress(address);
						}

						else if (choice == 6) {
						}

					} while (choice != 6 /* Exit loop when choice is 6 */);

				}

				break;

			case 6:
				// Makes the project final
				if (Project.getProjId() == null) {
					System.out.print("\nNo project - please add one.\n");
				} else {

					do {
						System.out.println("\nFinalise Project\n--------------------------------");
						System.out.print("Mark project as finalised?\n");
						System.out.print("1 - Yes \n");
						System.out.print("2 - No\n");
						System.out.print("Enter your selection: ");
						choice = input.nextInt();

						if (choice == 1) {
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
						}

						if (choice == 2) {
							// Sets project status to "In Progress"
							newProject.makeInProg();
							System.out.print("\nProject set to: " + newProject.getProjStatus() + "\n");
						} else {

							break;
						}

					} while (choice != 2);
				}

				break;

			case 7:
				// Quits the program
				System.out.println("Exiting program...");
				System.exit(0);

				break;

			default:
				System.out.println(choice + " is not a valid Menu option. Please try again.");
			}

		} while (choice != 7 /* Exit loop when choice is 7 */);

	}

}
