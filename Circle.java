public class Circle implements Measurable {
    double radius = 0;
    double area = 0;

    Circle (){
    }

    Circle(double radiusR) {
        radius = radiusR;
    }

    public double getArea() {
        area =  Math.PI * radius * radius;
        return area;
    }
}
