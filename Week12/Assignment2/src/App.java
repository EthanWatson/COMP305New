import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import daos.CityDao;
import daos.CountryDao;
import daos.LanguageDao;
import entities.City;
import entities.Country;
import entities.Language;
import entities.Database;

public class App {
    public static void main(String[] args) throws Exception {
        List<Country> countryList;

    try (Connection connection = Database.getDatabaseConnection();
        Statement statement = connection.createStatement();) {

        //FindAll
        CountryDao countryDao = new CountryDao(connection);
        countryList = countryDao.findAll();

        System.out.println("Printing Countries");
        for (Country country: countryList) {
            System.out.println(country);
        }

        //Insert
        Country insertCountry = new Country();
        insertCountry.setCode("OCT");
        insertCountry.setName("1country");
        insertCountry.setContinent("North America");
        insertCountry.setRegion("North America");
        insertCountry.setSurfaceArea(527529);
        insertCountry.setIndepYear(2001);
        insertCountry.setPopulation(528975);
        insertCountry.setLifeExpectancy(74);
        insertCountry.setGNP(34278);
        insertCountry.setGNPOld(54325);
        insertCountry.setLocalName("1country");
        insertCountry.setGovernmentForm("Republic");
        insertCountry.setHeadOfState("Elisabeth II");
        insertCountry.setCapital(452);
        insertCountry.setCode2("OC");
        
        countryDao.insert(insertCountry);

        //FindById
        Country country = new Country();
        country = countryDao.findById("OCT");
        System.out.println('\n' + "Country returned from findById (OCT): " + country + '\n');

        //Update
        country.setName("2country");
        Boolean success = countryDao.update(country);
        if (success) {
            System.out.println("Country after update: " + countryDao.findById("OCT"));
        }

        //Delete
        countryDao.delete("OCT");

        //City FindByName
        CityDao cityDao = new CityDao(connection);
        City city = new City();
        city = cityDao.findByName("Haag");
        System.out.println('\n' + "City returned from findByName (Haag): " + city + '\n');

        //City findByCountryCode
        List<City> cityList2 = cityDao.findByCountryCode("ARG");

        System.out.println("Printing cities with countryCode (ARG)");
        for (City city2: cityList2) {
            System.out.println(city2);
        }

        //City FindOver1MillionPopulation
        List<City> cityList = cityDao.findOver1MillionPopulation();

        System.out.println("\n" + "Printing cities over 1 million population: ");
        for (City currentCity: cityList) {
            System.out.println(currentCity);
        }

        //Country findByName
        country = countryDao.findByName("Armenia");
        System.out.println('\n' + "Country returned from findByName (Armenia): " + country + '\n');

        //Country findByRegion
        List<Country> countryList2 = countryDao.findByRegion("Caribbean");
        System.out.println("Printing Countries in Caribbean region");
        for (Country currentCountry: countryList2) {
            System.out.println(currentCountry);
        }
    }
    catch (SQLException ex) {
        System.err.println("Exception: " + ex.getMessage());
    }
    }
}


