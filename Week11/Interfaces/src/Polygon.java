public interface Polygon {
    void getArea(int length, int width);

    //default method
    default void getSides() {
        System.out.println("I can get the sides of the polygon");
    }

    //static method
    default void getPerimeter(int... sides) {
        int perimeter = 0;
        for(int side: sides) {
            perimeter += side;
        }
        System.out.println("Perimeter: " + perimeter);
    }
}
