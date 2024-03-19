package main;

import basic_operations.A;

import java.util.Scanner;

import static java.lang.System.exit;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        A a = new A();
        String str1 = null;
        String str2 = null;

        while(true)
        {
            // User-friendly Console
            System.out.println("!!! Welcome to String Operations Console !!!");
            System.out.println("Choose one of the options by entering the option number:");
            System.out.println("1. Concatenate two strings");
            System.out.println("2. Get length of the entered String value");
            System.out.println("3. Convert string to uppercase and lowercase");
            System.out.println("4. Extract a substring");
            System.out.println("5. Split a sentence into single words");
            System.out.println("6. Reverse a String");

            try
            {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (Exception e)
            {
                e.printStackTrace();
            }

            switch (choice)
            {
                case 1:

                    System.out.println("Please enter two strings:");

                    try
                    {
                        str1 = sc.nextLine();
                        System.out.println("Next String:");
                        str2 = sc.nextLine();
                    } catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    a.concatenate(str1, str2);
                    break;

                case 2:
                    System.out.println("Please enter a string");
                    try
                    {
                        str1 = sc.nextLine();
                    } catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    a.length(str1);
                    break;

                case 3:
                    System.out.println("Please enter a string:");
                    try
                    {
                        str1 = sc.nextLine();
                    } catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    a.toLowerCase(str1);
                    a.toUpperCase(str1);
                    break;

                case 4:
                    System.out.println("Enter a string:");
                    int start = 0, end = 0;
                    try
                    {
                        str1 = sc.nextLine();
                        System.out.println("Enter starting and ending index");
                        System.out.println("Note: it should be between 0 and " + str1.length());
                        start = sc.nextInt();
                        sc.nextLine();
                        end = sc.nextInt();
                        sc.nextLine();
                    } catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    a.subString(str1, start, end);
                    break;

                case 5:
                    System.out.println("Please enter a string:");
                    try
                    {
                        str1 = sc.nextLine();
                    } catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    a.splitString(str1);
                    break;

                case 6:
                    System.out.println("Enter the string to be reversed:");
                    try
                    {
                        str1 = sc.nextLine();
                    } catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    a.reverseString(str1);
                    break;

                default:
                    System.out.println("You entered an invalid input. Please try again!!");
            }
            System.out.println("Enter Y to continue or any other key to exit:");
            try
            {
                str2 = sc.next();
                sc.nextLine();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            if (!str2.equals("y") && !str2.equals("Y"))
            {
                System.out.println("THANK YOUUUU");
                System.out.println("Exited!!!!!!");
                sc.close();
                exit(0);
            }
        }
    }
}
