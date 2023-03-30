public class Square implements Polygon, Line {
    @Override
    public void getArea(int length, int width) {
        System.out.println("The area of the square is " + (length * width));
    }

    @Override
    public void CountLines(int numberOfLines) {
        System.out.println("The number of lines = " + numberOfLines);
    }
}
