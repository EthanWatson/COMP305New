import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import daos.CityDao;
import daos.LanguageDao;
import entities.City;
import entities.Language;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        List<City> cityList;
        List<Language> languageList;

        String url = "jdbc:mysql://localhost:3306/world";
        String user = "root";
        String password = "8064";

    try (Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();) {

        CityDao cityDao = new CityDao(connection);
        cityList = cityDao.findAll();

        LanguageDao languageDao = new LanguageDao(connection);
        languageList = languageDao.findAll();

        //Cities
        System.out.println("Printing Cities");
        for(City city: cityList) {
            System.out.println(city);
        }

        //Languages
        System.out.println("Printing Languages")
        for(Language language: languageList) {
            System.out.println(language);
        }
        
        // ResultSet resultSet = statement.executeQuery("SELECT * FROM country");

        // while (resultSet.next()) {
        //     System.out.println(resultSet.getString(2));
        //     System.out.println(resultSet.getString("name"));
        // }

        // resultSet.close();
    }
    catch (SQLException ex) {
        System.err.println("Exception: " + ex.getMessage());
    }
    }
}
