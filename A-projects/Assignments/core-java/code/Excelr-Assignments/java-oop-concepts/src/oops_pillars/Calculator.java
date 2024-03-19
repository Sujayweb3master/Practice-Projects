package oops_pillars;

// Example for Abstraction and Encapsulation
public class Calculator
{
    private int var1, var2;

    public Calculator(int var1, int var2)
    {
        this.var1 = var1;
        this.var2 = var2;
    }

    public int getVar1()
    {
        return var1;
    }

    public void setVar1(int i)
    {
        var1 = i;
    }

    public int getVar2()
    {
        return var2;
    }

    public void setVar2(int i)
    {
        var2 = i;
    }

    public void sum()
    {
        System.out.println(var1 + var2);
    }

    public void subtract()
    {
        System.out.println(var1 - var2);
    }

    public void multiply()
    {
        System.out.println(var1 * var2);
    }

    public void division()
    {
        double i = (double)var1/(double)var2;
        String j = String.format("%.2f", i);
        System.out.println(j);
    }

}
