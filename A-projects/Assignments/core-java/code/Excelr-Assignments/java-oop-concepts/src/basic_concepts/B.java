package basic_concepts;

public class B
{
    private int field1;
    // No-argument constructor
    public B()
    {
        field1 = 10;
    }

    public B(int field1)
    {
        this.field1 = field1;
    }

    public int getField1()
    {
        return field1;
    }
}
