package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

    /**
     * returns a list of all cities in the city table
     */
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

    /**
     * pass a city object to insert that object's values into the table as a new row
     */
    public void insert(City city) {
        try(Statement statement = connection.createStatement()) {
            String insert = "INSERT INTO city VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, null);
            ps.setString(2, city.getName());
            ps.setString(3, city.getCountryCode());
            ps.setString(4, city.getDistrict());
            ps.setInt(5, city.getPopulation());
            ps.executeUpdate();

            ResultSet keys = ps.getGeneratedKeys();
            if(keys.next()) {
                city.setID(keys.getInt(1));
            }
        }
        catch(SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * pass in a city object to update the object this is run on to the values of the passed object
     * returns true or false for whether it succeded or failed
     */
    public Boolean update(City city) {
        Boolean success = true;

        String update = "UPDATE city SET population=? WHERE id=?";

        try(PreparedStatement ps = connection.prepareStatement(update);) {
            ps.setInt(1, city.getPopulation());
            ps.setInt(2, city.getID());
            ps.executeUpdate();
        } 
        catch(SQLException e) {
            System.err.println(e.getMessage());
            success = false;
        }
        return success;
    }

    /**
     * pass the primary key of the row you want to delete from the city table
     */
    public Boolean delete(Integer pk) {
        Boolean success = false;
        String delete = "DELETE FROM city WHERE id=?";

        try(PreparedStatement ps  = connection.prepareStatement(delete)) {
            ps.setInt(1, pk);

            if(ps.executeUpdate() != 0) {
                success = true;
            }
        }
        catch(SQLException e) {
            System.err.println(e.getMessage());
        }

        return success;
    }

    /**
     * returns a city object filled with values retrieved from the table with the passed primary key
     */
    public City findById(Integer pk) {
        City city = new City();
        String select = "SELECT * FROM city WHERE id=?";

        try(PreparedStatement ps = connection.prepareStatement(select);) {
            ps.setInt(1, pk);
            ResultSet result = ps.executeQuery();

            if (result.next()) {
                city.setCountryCode(result.getString("CountryCode"));
                city.setDistrict(result.getString("District"));
                city.setID(result.getInt("ID"));
                city.setName(result.getString("Name"));
                city.setPopulation(result.getInt("Population"));
            }
        }
        catch(SQLException e) {
            System.err.println(e.getMessage());
        }

        return city;
    }

    /**
     * pass the name of the city to find all the data from, and returns a city filled with that data
     */
    public City findByName(String passedName) {
        City city = new City();
        String select = "SELECT * FROM city WHERE name=?";

        try (PreparedStatement ps = connection.prepareStatement(select);) {
            ps.setString(1, passedName);   
            ResultSet result = ps.executeQuery();
            
            if (result.next()) {
                city.setCountryCode(result.getString("CountryCode"));
                city.setDistrict(result.getString("District"));
                city.setID(result.getInt("ID"));
                city.setName(result.getString("Name"));
                city.setPopulation(result.getInt("Population"));
            }
        } 
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return city;
    }

    /**
     * returns a list of city objects filled with data for every city with the passed countryCode
     */
    public List<City> findByCountryCode(String countryCode) {
        List<City> cities = new ArrayList<>();
        String select = "SELECT * FROM city WHERE countryCode=?";

        try (PreparedStatement ps = connection.prepareStatement(select);) {
            ps.setString(1, countryCode);   
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                City city = new City();
                city.setCountryCode(result.getString("CountryCode"));
                city.setDistrict(result.getString("District"));
                city.setID(result.getInt("ID"));
                city.setName(result.getString("Name"));
                city.setPopulation(result.getInt("Population"));

                cities.add(city);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return cities;
    }

    /**
     * returns a list of city objects filled with data for every city with over 1 million population
     */
    public List<City> findOver1MillionPopulation() {
        List<City> cities = new ArrayList<>();

        try (Statement statement = connection.createStatement();) {
            ResultSet result = statement.executeQuery("SELECT * FROM city WHERE population > 1000000");

            while (result.next()) {
                City city = new City();
                city.setCountryCode(result.getString("CountryCode"));
                city.setDistrict(result.getString("District"));
                city.setID(result.getInt("ID"));
                city.setName(result.getString("Name"));
                city.setPopulation(result.getInt("Population"));

                cities.add(city);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return cities;
    }
}
