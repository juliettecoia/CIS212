public class Box extends Rectangle {
    double length;
    double width;
    double height;
    double area;

    Box(double lengthL, double widthW, double heightH) {
        length = lengthL;
        width = widthW;
        height = heightH;
    }

    public double getArea() {
        area = 2 * (width * length + height * length + height * width);
        return area;
    }
}
