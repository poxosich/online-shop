package org.example;

import org.example.commands.Commands;
import org.example.managers.CategoryManager;
import org.example.models.Category;

import java.util.Scanner;

public class Main implements Commands {
   private static CategoryManager categoryManager = new CategoryManager();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        boolean isRun = true;
        while (isRun){
            Commands.printCommands();
            String command = scanner.nextLine();
            switch (command){
                case Exit :
                    isRun = false;
                    System.out.println("հույսով եմ նորից կտեսնվենք )))");
                    break;
                case ADD_CATEGORY:
                    addC();
                    break;
                case EDIT_CATEGORY_BY_ID:
                    ubdatC();
                    break;
                case DELETE_CATEGORY_BY_ID:
                    deleteC();
                    break;
                default:
                    System.err.println("չկա նամն հրաման!!!!!!");
                    break;
            }
        }
    }

    private static void ubdatC() {
        System.out.println("տվեք էն id-ին որի տվյալները գուզես փոխես");
        int categoryID = Integer.parseInt(scanner.nextLine());
        System.out.println("տվեք նոր Category-ի նոր անունը");
        String name = scanner.nextLine();
        Category category = new Category(name);
        categoryManager.updateCategory(category,categoryID);

    }

    private static void deleteC() {
        System.out.println("տուր այն category id որի պառամետռերը գուզես ջնջես");
        int categoryID = Integer.parseInt(scanner.nextLine());
        categoryManager.deleteCategory(categoryID);
    }

    private static void addC() {
        System.out.println("տուր Category-ի անունը");
        String name = scanner.nextLine();
        Category category = new Category(name);
        categoryManager.addCategory(category);
    }
}