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
     * Returns a list of all rows in country table
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

    public Country findById(String pk) {
        return null;
    }

    String Code; //PK
    String Name;
    String Continent;
    String Region;
    float SurfaceArea;
    int IndepYear;
    int Population;
    float LifeExpectancy;
    float GNP;
    float GNPOld;
    String LocalName;
    String GovernmentForm;
    String HeadOfState;
    int Capital;
    String Code2;


    public void insert(Country country) {
        try (Statement statement = connection.createStatement()) {
            String insert = "INSERT INTO country VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, null);
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

            ResultSet keys = ps.getGeneratedKeys();
            if(keys.next()) {
                country.setCode(keys.getString(1));
            }


        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public Boolean update(Country item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    public Boolean delete(String pk) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
