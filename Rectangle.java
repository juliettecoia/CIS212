public class Rectangle implements Measurable{
    double length;
    double width;
    double area;

    Rectangle(){
    }

    Rectangle(double lengthL, double widthW) {
        length = lengthL;
        width = widthW;
    }

    public double getArea() {
        area = length * width;
        return area;
    }
}
