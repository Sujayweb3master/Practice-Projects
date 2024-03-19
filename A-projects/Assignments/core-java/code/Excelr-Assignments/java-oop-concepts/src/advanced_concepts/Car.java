package advanced_concepts;

// Example for Composition and Aggregation
public class Car
{
    private Engine engine;
    private Wheel[] wheels;
    public Car(Wheel[] wheels)
    {
        engine = new Engine(); // Composition
        this.wheels = wheels; // Aggregation
    }

}
