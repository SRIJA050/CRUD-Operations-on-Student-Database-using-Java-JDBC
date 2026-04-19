package nodejs;

import java.util.List;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        UserDAO dao = new UserDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1. Insert");
            System.out.println("2. View All");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Roll Number: ");
                    String roll = sc.nextLine();

                    System.out.print("Branch: ");
                    String branch = sc.nextLine();

                    System.out.print("Marks: ");
                    int marks = Integer.parseInt(sc.nextLine());

                    dao.insertUser(new User(name, roll, branch, marks));
                    break;

                case 2:
                    List<User> list = dao.getAllUsers();
                    for (User u : list) {
                        System.out.println(
                                u.getName() + " | " +
                                u.getRollnumber() + " | " +
                                u.getBranch() + " | " +
                                u.getMarks()
                        );
                    }
                    break;

                case 3:
                    System.out.print("Roll number to update: ");
                    String ur = sc.nextLine();

                    System.out.print("New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("New Branch: ");
                    String newBranch = sc.nextLine();

                    System.out.print("New Marks: ");
                    int newMarks = Integer.parseInt(sc.nextLine());

                    dao.updateUser(new User(newName, ur, newBranch, newMarks));
                    break;

                case 4:
                    System.out.print("Roll number to delete: ");
                    String dr = sc.nextLine();

                    dao.deleteUser(dr);
                    break;

                case 5:
                    System.out.println("Thank You A Srija!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
