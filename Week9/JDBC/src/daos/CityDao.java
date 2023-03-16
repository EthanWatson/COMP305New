package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.City;

public class CityDao implements Dao<City, Integer> {
    Connection connection;
    public CityDao(Connection connection) {
        this.connection = connection;
    }

    public List<City> findAll() {
        List<City>cities = new ArrayList<>();

        try(Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery("SELECT * FROM city");

            while (result.next()) {
                City city = new City();
                city.setCountryCode(result.getString("CountryCode"));
                city.setDistrict(result.getString("District"));
                city.setID(result.getInt("ID"));
                city.setName(result.getString("Name"));
                city.setPopulation(result.getInt("Population"));

                cities.add(city);
            }
        }
        catch(SQLException e) {
            System.err.println(e.getMessage());
        }
        return cities;
    }

    public void insert(City city) {

    }

    public Boolean update(City city) {
        return true;
    }

    public Boolean delete(Integer pk) {
        return true;
    }

    public City findById(Integer pk) {
        City city = new City();
        return city;
    }
}
