

package main;

import advanced_concepts.Car;
import advanced_concepts.Wheel;
import basic_concepts.*;
import oops_pillars.*;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.exit;
//import advanced_concepts.*;

public class Main
{

    public static void main(String[] args)
    {
        boolean check = true;
        int choice = 10;
        String str;

        Scanner sc = new Scanner(System.in);

        while(true)
        {
            System.out.println("Enter a choice:");
            System.out.println("1 - Example for usage of a class for creating objects");
            System.out.println("2 - Calling a user defined constructor");
            System.out.println("3 - Overloaded method example");
            System.out.println("4 - Override example");
            System.out.println("5 - Example for interfaces");
            System.out.println("6 - Example for usage of abstract class");
            System.out.println("7 - Example for abstraction and encapsulation");
            System.out.println("8 - Example for composition and aggregation");
            System.out.println("9 - Example for composition and aggregation (complex)");
            try
            {
                choice = sc.nextInt();
            }
            catch(InputMismatchException e)
            {
                e.printStackTrace();
                choice = 10;
            }

            switch (choice)
            {
                case 1:         // Example for usage of a class for creating objects
                    A objOfA = new A();
                    objOfA.setfield1(23);
                    System.out.println(objOfA.getfield1());
                    System.out.println("------------------");
                    break;

                case 2:         // Calling a user defined constructor
                    B objOfB = new B(30);
                    System.out.println(objOfB.getField1());
                    System.out.println("------------------");
                    break;

                case 3:         // Polymorphism
                    // Overloaded method example
                    C objOfC = new C();
                    System.out.print("Area of square: ");
                    System.out.println(objOfC.area(23));
                    System.out.print("Area of rectangle: ");
                    System.out.println(objOfC.area(22.3, 44.1));
                    System.out.println("------------------");
                    break;

                case 4:         // Override example
                    Animal objOfAnimal1 = new Dog();
                    Animal objOfAnimal2 = new Cat();
                    objOfAnimal1.eats();
                    objOfAnimal1.moves();
                    objOfAnimal1.category();
                    objOfAnimal1.backBoneCategory();
                    objOfAnimal2.eats();
                    objOfAnimal2.moves();
                    objOfAnimal2.category();
                    objOfAnimal2.backBoneCategory();
                    System.out.println("------------------");
                    break;

                case 5:         // Example for interfaces
                    SmartPhone objOfSmartPhone = new SmartPhone();
                    FeaturePhone objOfFeaturePhone = new FeaturePhone();
                    objOfSmartPhone.typeOfDisplay();
                    objOfFeaturePhone.typeOfDisplay();
                    System.out.println("------------------");
                    break;

                case 6:         // Example for usage of abstract class
                    Flyable objOfAeroplane = new Aeroplane();
                    Flyable objOfTrain = new Train();
                    objOfAeroplane.checkCapability();
                    objOfTrain.checkCapability();
                    System.out.println("------------------");
                    break;

                case 7:         // Example for abstraction and encapsulation
                    Calculator objOfCalc = new Calculator(23, 11);
                    objOfCalc.sum();
                    objOfCalc.subtract();
                    objOfCalc.multiply();
                    objOfCalc.division();
                    System.out.println("------------------");
                    break;

                case 8:         // Example for composition and aggregation
                    Wheel[] sharedWheels = {new Wheel(), new Wheel(), new Wheel(), new Wheel()};
                    Car car1 = new Car(sharedWheels);
                    Car car2 = new Car(sharedWheels);
                    System.out.println("done");
                    break;

                case 9:         // Example for composition and aggregation (complex)
                    advanced_concepts.A objOfNewA = new advanced_concepts.A();
                    objOfNewA.setValueOfObj();
                    System.out.println(objOfNewA.getValueOfObj());
                    advanced_concepts.A.InnerA objOfInnerA = objOfNewA.new InnerA();
                    System.out.println("done");
                    System.out.println("------------------");
                    break;

                default:
                    System.out.println("Entered a invalid choice. Choose among 1 - 9");

            }
            System.out.println();
            System.out.println("Enter 'Y' or 'y' to continue!! OR");
            System.out.println("Enter any other key to exit ");
            str = sc.next();

            if(!Objects.equals(str, "y") && !Objects.equals(str, "Y"))
            {
                sc.close();
                break;
            }else
            {
                continue;
            }
        }

        System.out.println("Exited");
        System.out.println("Thank you!!!!");


    }
}
