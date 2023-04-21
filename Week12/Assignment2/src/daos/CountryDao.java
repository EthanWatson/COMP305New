package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Country;

public class CountryDao implements Dao<Country, String> {

    Connection connection;

    public CountryDao(Connection connection) {
        this.connection = connection;
    }

    /** 
     * Returns a list of country objects filled with data from all rows in country table
     */
    public List<Country> findAll() {
        List<Country> countries = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery("SELECT * FROM country");

            while (result.next()) {
                Country country = new Country();
                country.setCode(result.getString("Code"));
                country.setName(result.getString("Name"));
                country.setContinent(result.getString("Continent"));
                country.setRegion(result.getString("Region"));
                country.setSurfaceArea(result.getFloat("SurfaceArea"));
                country.setIndepYear(result.getInt("IndepYear"));
                country.setPopulation(result.getInt("Population"));
                country.setLifeExpectancy(result.getFloat("LifeExpectancy"));
                country.setGNP(result.getFloat("GNP"));
                country.setGNPOld(result.getFloat("GNPOld"));
                country.setLocalName(result.getString("LocalName"));
                country.setGovernmentForm(result.getString("GovernmentForm"));
                country.setHeadOfState(result.getString("HeadOfState"));
                country.setCapital(result.getInt("Capital"));
                country.setCode2(result.getString("Code2"));

                countries.add(country);
            }
        } 
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return countries;
    }

    /**
     * Returns a country object filled with data from country table row that has the matching passed primary key
     */
    public Country findById(String pk) {
        Country country = new Country();
        String select = "SELECT * FROM country WHERE Code=?";

        try (PreparedStatement ps = connection.prepareStatement(select);) {
            ps.setString(1, pk);
            ResultSet result = ps.executeQuery();

            if (result.next()) {
                country.setCode(result.getString("Code"));
                country.setName(result.getString("Name"));
                country.setContinent(result.getString("Continent"));
                country.setRegion(result.getString("Region"));
                country.setSurfaceArea(result.getFloat("SurfaceArea"));
                country.setIndepYear(result.getInt("IndepYear"));
                country.setPopulation(result.getInt("Population"));
                country.setLifeExpectancy(result.getFloat("LifeExpectancy"));
                country.setGNP(result.getFloat("GNP"));
                country.setGNPOld(result.getFloat("GNPOld"));
                country.setLocalName(result.getString("LocalName"));
                country.setGovernmentForm(result.getString("GovernmentForm"));
                country.setHeadOfState(result.getString("HeadOfState"));
                country.setCapital(result.getInt("Capital"));
                country.setCode2(result.getString("Code2"));
            }
        } 
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return country;
    }

    /**
     * inserts a row into the country table with the data stored in the passed country object
     */
    public void insert(Country country) {
        try (Statement statement = connection.createStatement()) {
            String insert = "INSERT INTO country VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = connection.prepareStatement(insert);
            ps.setString(1, country.getCode());
            ps.setString(2, country.getName());
            ps.setString(3, country.getContinent());
            ps.setString(4, country.getRegion());
            ps.setFloat(5, country.getSurfaceArea());
            ps.setInt(6, country.getIndepYear());
            ps.setInt(7, country.getPopulation());
            ps.setFloat(8, country.getLifeExpectancy());
            ps.setFloat(9, country.getGNP());
            ps.setFloat(10, country.getGNPOld());
            ps.setString(11, country.getLocalName());
            ps.setString(12, country.getGovernmentForm());
            ps.setString(13, country.getHeadOfState());
            ps.setInt(14, country.getCapital());
            ps.setString(15, country.getCode2());

            ps.executeUpdate();
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * update the name column for the row in the country table with the matching primary key in the passed country object
     */
    public Boolean update(Country country) {
        Boolean success = true;

        String update = "UPDATE country SET Name=? WHERE Code=?";

        try (PreparedStatement ps = connection.prepareStatement(update);) {
            ps.setString(1, country.getName());
            ps.setString(2, country.getCode());

            ps.executeUpdate();
        } 
        catch (SQLException e) {
            System.err.println(e.getMessage());
            success = false;
        }
        return success;
    }

    /**
     * delete the row from the country table with the same primary key as the passed string
     */
    public Boolean delete(String pk) {
        Boolean success = false;
        String delete = "DELETE FROM country WHERE Code=?";

        try (PreparedStatement ps = connection.prepareStatement(delete)) {
            ps.setString(1, pk);

            if (ps.executeUpdate() != 0) {
                success = true;
            }
        } 
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return success;
    }

    /**
     * pass the name of the country to find all the data from, and returns a country filled with that data
     */
    public Country findByName(String name) {
        Country country = new Country();
        String select = "SELECT * FROM country WHERE name=?";

        try (PreparedStatement ps = connection.prepareStatement(select);) {
            ps.setString(1, name);   
            ResultSet result = ps.executeQuery();
            
            if (result.next()) {
                country.setCode(result.getString("Code"));
                country.setName(result.getString("Name"));
                country.setContinent(result.getString("Continent"));
                country.setRegion(result.getString("Region"));
                country.setSurfaceArea(result.getFloat("SurfaceArea"));
                country.setIndepYear(result.getInt("IndepYear"));
                country.setPopulation(result.getInt("Population"));
                country.setLifeExpectancy(result.getFloat("LifeExpectancy"));
                country.setGNP(result.getFloat("GNP"));
                country.setGNPOld(result.getFloat("GNPOld"));
                country.setLocalName(result.getString("LocalName"));
                country.setGovernmentForm(result.getString("GovernmentForm"));
                country.setHeadOfState(result.getString("HeadOfState"));
                country.setCapital(result.getInt("Capital"));
                country.setCode2(result.getString("Code2"));
            }
        } 
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return country;
    }

    /**
     * returns a list of country objects filled with data for every country in the passed region
     */
    public List<Country> findByRegion(String region) {
        List<Country> countries = new ArrayList<>();
        String select = "SELECT * FROM country WHERE region=?";

        try (PreparedStatement ps = connection.prepareStatement(select);) {
            ps.setString(1, region); 
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                Country country = new Country();
                country.setCode(result.getString("Code"));
                country.setName(result.getString("Name"));
                country.setContinent(result.getString("Continent"));
                country.setRegion(result.getString("Region"));
                country.setSurfaceArea(result.getFloat("SurfaceArea"));
                country.setIndepYear(result.getInt("IndepYear"));
                country.setPopulation(result.getInt("Population"));
                country.setLifeExpectancy(result.getFloat("LifeExpectancy"));
                country.setGNP(result.getFloat("GNP"));
                country.setGNPOld(result.getFloat("GNPOld"));
                country.setLocalName(result.getString("LocalName"));
                country.setGovernmentForm(result.getString("GovernmentForm"));
                country.setHeadOfState(result.getString("HeadOfState"));
                country.setCapital(result.getInt("Capital"));
                country.setCode2(result.getString("Code2"));

                countries.add(country);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return countries;
    }
}
