package basic_concepts;

public class C
{
    public C()
    {

    }

    // Example for method overloading
    public int area(int side)
    {
        return side * side;
    }

    public String area(double length, double breadth)
    {
        return String.format("%.2f",length * breadth);
    }
}
