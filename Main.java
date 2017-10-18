/*
    Resources I used:
    Interface information: http://xahlee.info/java-a-day/interface.html
    Inheritance constructors: http://xahlee.info/java-a-day/inheritance_constructers.html
    Creating classes and interfaces in the IDE: https://www.jetbrains.com/help/idea/creating-java-classes,-interfaces,-enumerations-and-annotations.html
    Differences between interfaces and classes: https://www.youtube.com/watch?v=NnZQ-C0x4hs
    More inheritance and constructors: https://stackoverflow.com/questions/525548/default-constructors-and-inheritance-in-java
    Generating a random number using nextDouble(): https://stackoverflow.com/questions/9723765/generating-a-random-double-number-of-a-certain-range-in-java
*/

import java.util.ArrayList;
import java.util.Random;

public class Main {

    private static double nextDouble(){

        Random randNum = new Random();
        double random = randNum.nextDouble();

        return random;
    }

    private static double calculateSum(ArrayList<Measurable>arrList){
        double sum = 0;

        for (int i = 0; i < 1000; i++)
        {
            sum = sum + arrList.get(i).getArea();
        }

        return sum;
    }

    public static void main(String[] args) {
        ArrayList<Measurable> arrList = new ArrayList<>();
        int rCount = 0, bCount = 0, cCount = 0, sCount = 0;

        for (int i = 0; i < 1000; i++)
        {
            Random randomChance = new Random();
            double chance = randomChance.nextDouble();

            if (chance < 0.25)
            {
                double length = nextDouble();
                double width = nextDouble();
                Rectangle r = new Rectangle(length, width);
                arrList.add(r);
                rCount++;
            }
            else if (chance < 0.5)
            {
                double length = nextDouble();
                double width = nextDouble();
                double height = nextDouble();
                Box b = new Box(length, width, height);
                arrList.add(b);
                bCount++;
            }
            else if (chance < 0.75)
            {
                double radius = nextDouble();
                Circle c = new Circle (radius);
                arrList.add(c);
                cCount++;
            }
            else if (chance < 1)
            {
                double radius = nextDouble();
                Sphere s = new Sphere(radius);
                arrList.add(s);
                sCount++;
            }
        }

        System.out.println("Rectangles: " + rCount + " Boxes: " + bCount + " Circles " + cCount + " Spheres: " + sCount);

        double sum = calculateSum(arrList);
        System.out.println("Sum: " + sum);
    }
}
