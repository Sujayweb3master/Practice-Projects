package main;

import file_handling_operations.A;

import java.nio.file.Path;
import java.util.Scanner;

public class Main
{
    static private A a = new A();

    public static void main(String[] args)
    {
        int choice = 0;
        Scanner sc = new Scanner(System.in);



        while(true)
        {
            System.out.println("Welcome to File Handling Operations Console!!!!");
            System.out.println("Please choose one of the options by entering the option number");
            System.out.println("1. Create a new Directory");
            System.out.println("2. Create a new file and add text to the file");
            System.out.println("3. Read the content from an existing file");
            System.out.println("4. Append new content to an existing file");
            System.out.println("5. Delete a text file");
            System.out.println("6. Copy the content from one text file to another");
            System.out.println("7. List all files and directories in a given directory");
            System.out.println("8. Rename a file");
            System.out.println("9. Search for a specific file in a directory and its subdirectories");
            System.out.println("10. Get information about a file");
            try
            {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (Exception e)
            {
                sc.nextLine();
                e.printStackTrace();
//                System.out.println("Invalid entry");
//                System.out.println("Please enter a valid number according to the option displayed");
            }


            switch (choice)
            {
                case 1:
                    System.out.println("Enter directory name:");
                    try
                    {
                        String str = sc.nextLine();
                        a.createDirectory(str);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    break;

                case 2:

                    try
                    {
                        System.out.println("Enter file name to be created");
                        String str = sc.nextLine();
                        System.out.println("Enter the text to be written in file");
                        String str1 = sc.nextLine();

                        a.createFileAndWrite(str,str1);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    break;

                case 3:
                    try
                    {
                        System.out.println("Enter file name from which text has to be read:");
                        String name = sc.nextLine();
                        a.readTextFrom(name);

                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    break;

                case 4:
                    try
                    {
                        System.out.println("Enter file name in which text has to be appended:");
                        String name = sc.nextLine();
                        System.out.println("Enter the text to be appended:");
                        String str = sc.nextLine();
                        a.appendToFile(name,str);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    break;

                case 5:
                    try
                    {
                        System.out.println("Enter name of file to be deleted");
                        String name = sc.nextLine();
                        a.deleteFile(name);
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                    break;

                case 6:
                    try
                    {
                        System.out.println("Enter file name to be copied from: ");
                        String src= sc.nextLine();
                        System.out.println("Enter file name where the copied text is to be pasted:");
                        String dest = sc.nextLine();
                        a.copyTextToDestFile(src,dest);
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                    break;

                case 7:
                    try
                    {
                        System.out.println("Enter the directory name:");
                        String name = sc.nextLine();
                        a.listFiles(name);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    break;

                case 8:
                    try
                    {
                        System.out.println("Enter the name of file to be renamed: ");
                        String fileName = sc.nextLine();
                        System.out.println("Enter the new name for the file: ");
                        String name = sc.nextLine();
                        a.renameFile(fileName,name);
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                    break;

                case 9:                                                               //02-03-2024
                    try
                    {
                        System.out.println("Enter the name of the file to be searched:");
                        String fileName = sc.nextLine();
                        a.SearchForFile(fileName);
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                    break;

                case 10:
                    try
                    {
                        System.out.println("Enter the file name of which information is required:");
                        String fileName = sc.nextLine();
                        a.informationOfFile(fileName);
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                    break;

                default:
                    System.out.println("You entered an invalid choice!!! Please enter correct option");


            }

            System.out.println("---------------------------");
            System.out.println("Repeat the Operations?");
            System.out.println("Enter 'y' to repeat or press any other key to exit:");
            String str = sc.nextLine();

            if(str.equalsIgnoreCase("y"))
            {
            }
            else
            {
                System.out.println("Process Ended!!!");
                return;
            }
        }


    }
}
