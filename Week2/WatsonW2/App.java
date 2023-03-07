import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) { 
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(new File("res/grades.csv"));
            String headerLine = fileScanner.nextLine();
            headerLine = headerLine.replaceAll("\"", "");
            String[]headers = headerLine.split(",");

            FileWriter fileWriter = new FileWriter("res/grades.html");
            StringBuilder builder = new StringBuilder();

            builder.append("<table>").append("\n");
            builder.append("<tr>");
            for (int i = 0; i < headers.length; i++) {
                builder.append("<th>").append(headers[i]).append("</th>").append("\n");
            }

            builder.append("</tr>").append("\n");
            builder.append("</table>");

            fileWriter.append(builder.toString());
            fileWriter.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}