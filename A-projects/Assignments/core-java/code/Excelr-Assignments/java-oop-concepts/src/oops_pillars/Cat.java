package oops_pillars;

public class Cat extends Mammal
{
    @Override
    public void moves()
    {
        System.out.println("Cat walks on four legs.");
    }

    @Override
    public void eats()
    {
        System.out.println("Cats drink milk.");
    }

    public void taste()
    {
        System.out.println("Cats don't taste sweetness.");
    }
}
