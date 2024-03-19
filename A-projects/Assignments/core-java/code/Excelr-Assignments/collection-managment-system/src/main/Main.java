package main;

import Sets.SetManager;
import lists.ListManager;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.BufferedReader;

import static java.lang.System.exit;

public class Main
{
    private static final Scanner sc = new Scanner(System.in);
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args)
    {
        int choice = 0;
        int innerChoice = 0;
        Object obj = new Object();
        ListManager lm = new ListManager();
        SetManager sm = new SetManager();
        String space = "\t\t\t\t";

        while(true)
        {

            System.out.println(space + "Welcome to Collection Management System:");
            System.out.println("===================================================================");
            System.out.println("Enter a choice from the following options: ");
            System.out.println("1. List ");
            System.out.println("2. Sets");
            System.out.println("3. Maps");

            choice = input();

            switch(choice)
            {

                case 1:

                    do
                    {
                        System.out.println("List Operations:");
                        System.out.println("1. Add an element to the array list");
                        System.out.println("2. Remove an element from the array list");
                        System.out.println("3. Display all the elements in the array list");

                        innerChoice = input();

                        switch (innerChoice)
                        {
                            case 1:
                                System.out.println("Please enter the value to be added:");
                                try
                                {
                                    obj = br.readLine();
                                } catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                if (lm.exists(obj))
                                {
                                    System.out.println("Value entered already exists in the list....");
                                    break;
                                }
                                lm.addOperation(obj);
                                System.out.println("Data added successfully.....");
                                break;

                            case 2:
                                System.out.println("Enter the value to be removed from the list:");
                                try
                                {
                                    obj = br.readLine();
                                } catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                if (!lm.exists(obj))
                                {
                                    System.out.println("Entered value is not present in the list....");
                                    break;
                                } else
                                {
                                    if (lm.removeOperation(obj))
                                    {
                                        System.out.println("Successfully removed from the list");
                                    }
                                }
                                break;

                            case 3:
                                System.out.println("Current List: ");
                                if (lm.empty())
                                {
                                    System.out.println("List is empty....");
                                    System.out.println("Please add some values to the list");
                                    break;
                                }
                                lm.displayOperation();
                                break;

                            default:
                                System.out.println("-> Entered invalid choice!!!");
                                System.out.println("-> Please enter a valid option");
                        }
                        System.out.println("To come out of list enter y:");
                    } while (!sc.nextLine().equalsIgnoreCase("y"));
                    break;

                case 2:
                    do
                    {
                        boolean flag;

                        System.out.println("'Set' Operations:");
                        System.out.println("1. Add an element to the Hash set");
                        System.out.println("2. Remove an element from the Hash set");
                        System.out.println("3. Display all the elements in the Hash set");

                        innerChoice = input();

                        switch (innerChoice)
                        {
                            case 1:
                                System.out.println("Please enter the value to be added:");
                                try
                                {
                                    obj = br.readLine();
                                } catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                flag = sm.addElement(obj);
                                if(!flag)
                                    System.out.println("Entered value already exists in the set");
                                break;

                            case 2:
                                System.out.println("Enter the value to be removed from the list:");
                                try
                                {
                                    obj = br.readLine();
                                } catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                flag = sm.removeElement(obj);
                                if(!flag)
                                    System.out.println("Item not present in the set");
                                break;

                            case 3:
                                System.out.println("Items in set: ");

                                if(sm.empty())
                                    System.out.println("Set is empty");
                                else
                                    sm.displaySet();

                            default:
                                System.out.println("-> Please enter a valid choice !!!!");
                        }
                        System.out.println("To come out of set enter y:");
                    } while (!sc.nextLine().equalsIgnoreCase("y"));
                    break;

                default :
                    System.out.println("-> You entered an invalid choice!!!");
                    System.out.println("-> Please enter appropriate option");
            }

            System.out.println("Do you wish to continue ?");
            System.out.println("Press y and enter to proceed or enter any other key to exit:");
            if(!sc.nextLine().equalsIgnoreCase("y"))
            {
                System.out.println("Exited the console!!!!");
                exit(0);
                //or we can use
                //return;
            }

        }

    }

    // method used to take input from the user wherever necessary
    public static int input()
    {
        int enteredValue;
        try
        {
            enteredValue = sc.nextInt();
            sc.nextLine();
            return enteredValue;
        }
        catch(InputMismatchException e)
        {
            System.err.println("Invalid format entered : " + e.getMessage());
        }

        return 0;
    }

}
