package oops_pillars;

// Example for inheritance
// Example for generalization and specialization
public class Mammal extends Animal
{
    @Override
    public void category()
    {
        System.out.println("Mammals belong to the class Mammalia.");
    }

    @Override
    public void backBoneCategory()
    {
        System.out.println("Mammals are vertebrates.");
    }
}
