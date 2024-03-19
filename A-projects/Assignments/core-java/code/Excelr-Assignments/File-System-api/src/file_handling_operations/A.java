package file_handling_operations;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class A
{
    private static String initPath = "/home/sujay18/Core-Java/Excelr-Assignments/File-Handling/";

    public void createDirectory(String dirName)
    {
        File file = new File(initPath.concat(dirName));
        if(file.exists())
            System.out.println("Directory already exists!!!");
        if(file.mkdir())
        {
            System.out.println("Directory was created!!!");
        }
        else
        {
            System.out.println("Directory was not created!!");
        }
        file = null;
    }


    public void createFileAndWrite(String fileName, String text)
    {
        String temp = fileName + ".txt";
        File file = new File(initPath.concat(temp));
        FileWriter writer = null;

        if(file.exists())
        {
            System.out.println("file already exists!!!");
            System.out.println("Only the entered text will be added");
        }
        try
        {
            writer = new FileWriter(file, false);
            writer.write(text);
            writer.flush();
            writer.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("done");

    }

    public void readTextFrom(String fileName)
    {
        File file = new File(initPath, fileName.concat(".txt"));
        char[] chBf = new char[(int)file.length()];
        try(FileReader reader = new FileReader(file))
        {
            reader.read(chBf);
            String str = new String(chBf);
            System.out.println(str);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void appendToFile(String fileName, String text)
    {
        String temp = fileName + ".txt";
        File file = new File(initPath.concat(temp));
        FileWriter writer = null;
        try
        {

            writer = new FileWriter(file, true);
            writer.write(text);
            writer.flush();
            writer.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("done");
    }

    public void deleteFile(String fileName)
    {
        String temp = fileName + ".txt";
        File file = new File(initPath.concat(temp));

        if(file.delete())
            System.out.println("File is deleted");
        else
            System.out.println("File is not available!!!");
    }

    public void copyTextToDestFile(String src, String dest)
    {
        String temp1 = src + ".txt";
        String temp2 = dest + ".txt";

        File file1 = new File(initPath.concat(temp1));
        File file2 = new File(initPath.concat(temp2));

        if((int)file1.length() == 0)
        {
            System.out.println("Source file is empty!!!");
            return;
        }

        try
        {
            FileReader reader = new FileReader(file1);
            FileWriter writer = new FileWriter(file2);
            char[] chBf = new char[(int)file1.length()];

            reader.read(chBf);
            String text = new String(chBf);
            writer.write(text);
            writer.flush();
            writer.close();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void listFiles(String dirName)
    {
        String temp = initPath;

        if(!dirName.equalsIgnoreCase("File-Handling"))
        {
            temp = initPath + dirName;
        }

//        System.out.println(temp);
        File file = new File(temp);

        String[] list = file.list();

        System.out.println("Files and folders list:");
        for(String str : list)
        {
            System.out.println(str);
        }
    }

    public void renameFile(String fileName, String destFileName)
    {
        String temp1 = initPath + fileName + ".txt";
        String temp2 = initPath + destFileName + ".txt";

        File file1 = new File(temp1);
        File file2 = new File(temp2);

        if(file2.exists())
        {
            System.out.println("Unsuccessful");
            System.out.println("File with name entered already exists!!!");
            return;
        }

        if(file1.renameTo(file2))
            System.out.println("Successfully changed!!!!!");

    }

    public void SearchForFile(String fileName)                             //02-03-2024
    {
        File file = new File(initPath);
        String txtFormat = ".txt";
        fileName += ".txt";

        String[] listOfFiles = file.list();


        if (listOfFiles != null)
        {
            for (String item : listOfFiles)
            {
                if(item.contains(txtFormat))
                {
                    if (item.compareTo(fileName) == 0)
                    {
                        System.out.println("File found in path:");
                        System.out.println(initPath + fileName);
                        return;
                    } else
                    {
                    }
//                        System.out.println("File not found!!!");

                }
                else
                {
                   String temp =  subDirectory(item, fileName);
                   if (temp != null)
                       System.out.println(temp);
                   else
                       System.out.println("File not found!!!");
                }
            }
        }
        else
        {
            System.out.println("Directory is empty");
        }

    }

    public void informationOfFile(String fileName)
    {
        File file = new File(initPath, fileName + ".txt");

        if(file.exists())
        {
            System.out.println("File size:");
            System.out.println(file.getTotalSpace());
            try
            {
                long time = file.lastModified();

                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                Date date = new Date(time);

                System.out.println("Last modified on: " + sdf.format(date));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            System.out.println("Length of the file:");
            System.out.println(file.length());
        }
        else
            System.out.println("File does not exist");
    }
    private static String subDirectory(String dirName, String fileName)
    {
        String path = null;
        String txtFormat = ".txt";

        File file = new File(initPath, dirName);

        String[] listOfFiles = file.list();

        if (listOfFiles != null)
        {
            for (String item : listOfFiles)
            {
                if (item.contains(txtFormat))
                {
                    if (item.compareTo(fileName) == 0)
                    {
//                        System.out.println("File found in path:");
//                        System.out.println(initPath + fileName);
                        System.out.println("File found in subdirectory:");
                        System.out.println(dirName);
                        System.out.println("Path:");
                        return initPath + dirName + "/" + fileName;
                    } else
                    {
                        System.out.println("File not found!!!");
                        return null;
                    }
                }
            }
        }

        return path;
    }

}
