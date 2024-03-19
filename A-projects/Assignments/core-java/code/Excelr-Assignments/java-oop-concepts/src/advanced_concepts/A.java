package advanced_concepts;

// Example for Composition
/*
It is a "has-a" relationship where one class contains another class as a part.
In composition, the contained object cannot exist independently of the container object.
 */
/*
The below written code might not be a best example for composition.
 */
public class A
{
    private int field1;
    private InnerA obj = new InnerA();

    public class InnerA
    {
        private int fieldOfInnerA;

        public int getFieldOfInnerA()
        {
            return fieldOfInnerA;
        }

        public void setFieldOfInnerA(int i)
        {
            fieldOfInnerA = i;
        }
    }

    public int getValueOfObj()
    {
        return obj.getFieldOfInnerA();
    }

    public void setValueOfObj()
    {
        obj.setFieldOfInnerA(34);
    }

}
