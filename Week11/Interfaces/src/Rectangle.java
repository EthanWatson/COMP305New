public class Rectangle implements Polygon {
    @Override
    public void getArea(int length, int width) {
        System.out.println("The area of the rectangle is " + (length * width));
    }

    public void getSides() {
        System.out.println("I have 4 sides");
    }
}
