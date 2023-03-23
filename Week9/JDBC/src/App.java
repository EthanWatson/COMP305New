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
        System.out.println("Printing Languages");
        for(Language language: languageList) {
            System.out.println(language);
        }

        //Insert
        // City insertCity = new City();
        // insertCity.setCountryCode("CAN");
        // insertCity.setDistrict("Kings");
        // insertCity.setName("Kingston");
        // insertCity.setPopulation(136685);

        // cityDao.insert(insertCity);

        //findById
        City city = new City();
        city = cityDao.findById(4080);
        System.out.println("City returned from findById (4087): " + city);

        //Update
        city.setPopulation(10000);
        Boolean success = cityDao.update(city);
        System.out.println("City after the update: " + cityDao.findById(4087));

        //Delete
        cityDao.delete(4080);






        
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


