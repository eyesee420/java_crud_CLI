import java.util.HashMap;
import java.util.Scanner;


public class App {
    static HashMap<String, user_model> employeeMap = new HashMap<>();
    static Scanner myObj = new Scanner(System.in);
    public static void main(String[] args) {

       showMainMenu();
    }
    
    private static void showMainMenu() {
        System.out.println("=========== MAIN MENU ===========");
        System.out.println("[1] REGISTER EMPLOYEE");
        System.out.println("[2] VIEW REGISTERED EMPLOYEES");
        System.out.println("[3] UPDATE EMPLOYEE");
        System.out.println("[4] REMOVE EMPLOYEE");
        System.out.println("[5] EXIT");
        System.out.println("=================================");
        System.out.print("ENTER MENU: ");
        int choice = myObj.nextInt();
        
        // Consume the newline character
        myObj.nextLine();
        
        switch (choice) {
            case 1:
                System.out.println("=========== EMPLOYEE REGISTRATION ===========");

                System.out.print("ENTER ID: ");
                String id = myObj.nextLine();
               
                if(employeeMap.containsKey(id)){
                System.out.println("CANNOT ADD WITH THE SAME ID!  ");
                }
                else {
                System.out.print("ENTER NAME: ");
                String name = myObj.nextLine();
                
                System.out.print("ENTER POSITION: ");
                String position = myObj.nextLine();
                user_model newUsers = new user_model(id, name, position);
                employeeMap.put(id, newUsers);
                System.out.println("SUCCESSFULY REGISTERED");
                }
                
                // After registering an employee, return to the main menu
                showMainMenu();
                break;
            case 2:
                System.out.println("=========== REGISTERED EMPLOYEES "+ "("+employeeMap.size()+")" +"===========");
                System.out.println("ID\tNAME\tPOSITION");
                System.out.println("---------------------------------------------");

                for (user_model employee : employeeMap.values()) {
                    System.out.println(employee.getId() + "\t" + employee.getName() + "\t" + employee.getPosition());
                }
                System.out.println("=============================================");
                

                showMainMenu();
                break;
            case 3:
                System.out.println("=========== UPDATE EMPLOYEES ===========");
                updateEmployees();

                break;
            case 4:
                System.out.println("=========== DELETE EMPLOYEES ===========");
                removeEmployees();   
                break;
            case 5:
                System.out.println("You selected option 5: EXIT");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please select a valid option.");
                showMainMenu(); // Return to the main menu for invalid choices
        }
        
        // Close the Scanner
        myObj.close();
    }

    private static void updateEmployees() {
        System.out.print("Search Employee by ID: ");
        String idToUpdate = myObj.nextLine();
        
        if (employeeMap.containsKey(idToUpdate)) {
            System.out.println("Employee found. Please update the information:");
            user_model existingEmployee = employeeMap.get(idToUpdate);
            
            System.out.print("Enter new NAME: ");
            String newName = myObj.nextLine();
            
            System.out.print("Enter new POSITION: ");
            String newPosition = myObj.nextLine();


            existingEmployee.setName(newName);
            existingEmployee.setPosition(newPosition);

            System.out.println("Employee information updated successfully. ! ");
        } else {
            System.out.println("Employee with ID " + idToUpdate + " not found.");
        }

        showMainMenu();
    }
    private static void removeEmployees() {
        System.out.print("Search Employee by ID: ");
        String idToDelete = myObj.nextLine();
        if (employeeMap.containsKey(idToDelete)) {
            employeeMap.remove(idToDelete);
            System.out.println("Employee with ID " + idToDelete + " removed successfully.");
        } else {
            System.out.println("Employee with ID " + idToDelete + " not found.");
        }

        showMainMenu();
    }
   
}



