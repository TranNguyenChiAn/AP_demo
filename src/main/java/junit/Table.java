package junit;

import org.decimal4j.util.DoubleRounder;

public class Table {
    private double height;
    private double width;

    public Table() {
        this.height = 1.0;
        this.width = 1.0;
    }

    public Table(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height <= 0) {
            throw new RuntimeException("Height must be positive");
        }
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (width <= 0) {
            throw new RuntimeException("Width must be positive");
        }
        this.width = width;
    }

    public double area() {
        double dt = width * height;
        return DoubleRounder.round(dt, 2);
    }

    public double perimeter() {
        double cv = (width + height) * 2;
        return DoubleRounder.round(cv, 2);
    }

    @Override
    public String toString() {
        return "Table{" +
                "height=" + height +
                ", width=" + width +
                '}';
    }
}
