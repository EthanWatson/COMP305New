public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Rectangle rectangle = new Rectangle();
        rectangle.getArea(5, 6);
        rectangle.getSides();
        rectangle.getPerimeter(2, 3, 2, 3);

        Square square = new Square();
        square.getArea(5, 5);
        square.getSides();
        square.getPerimeter(2, 2, 2, 2);


    }
}
