package basic_operations;

import java.sql.SQLOutput;
import java.util.Arrays;

public class A
{

    public void concatenate(String str1,String str2)
    {
//        System.out.println(str1 + str2);
        System.out.println(str1.concat(str2));
    }

    public void length(String str)
    {
        System.out.println(str.length());
    }

    public void toUpperCase(String str)
    {
        System.out.println("Upper Case: " + str.toUpperCase());
    }

    public void toLowerCase(String str)
    {
        System.out.println("Lower Case: " + str.toLowerCase());
    }

    public void subString(String str, int start, int end)
    {
        System.out.println(str.substring(start,end));
    }

    public void splitString(String str)
    {
//        System.out.println(str.split(" "));
        String[] arr = str.split(" ");
        System.out.println("After splitting the sentence we get:");
        for(String i : arr)
        {
            System.out.println(i);
        }

    }

    public void reverseString(String str)
    {
        char[] ch = str.toCharArray();
        char[] chNew = new char[str.length()];
        System.out.println("Reversed String: ");
        for(int i = str.length() - 1, j = 0; i >= 0; i--, j++)
        {
            chNew[j] = ch[i];
        }
        String reversedString = new String(chNew);
        System.out.println(reversedString);
    }


}
