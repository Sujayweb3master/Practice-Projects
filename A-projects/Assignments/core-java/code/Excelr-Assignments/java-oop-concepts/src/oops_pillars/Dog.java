package oops_pillars;

public class Dog extends Mammal
{
    @Override
    public void moves()
    {
        System.out.println("Dog walks on four legs");
    }

    @Override
    public void eats()
    {
        System.out.println("Dogs eat meat");
    }

    public void senseSmell()
    {
        System.out.println("Dogs have exceptional sense of smell.");
    }

}
