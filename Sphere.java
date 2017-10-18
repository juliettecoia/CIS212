public class Sphere extends Circle {
    double radius;
    double area;

    Sphere(double radiusR) {
        radius = radiusR;
    }

    public double getArea() {
        area =  4 * Math.PI * radius * radius;
        return area;
    }
}
