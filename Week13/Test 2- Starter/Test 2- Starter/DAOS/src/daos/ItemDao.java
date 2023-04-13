package daos;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Item;

public class ItemDao implements Dao<Item, Integer>{

    Connection connection;
    public ItemDao(Connection connection) {
        this.connection = connection;
    }

    /**
     * returns all rows from item table
     */
    public List<Item> findAll() {
        List<Item>items = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery("SELECT * FROM item");

            while (result.next()) {
                Item item = new Item();

                item.setID(result.getInt("id"));
                item.setName(result.getString("name"));
                item.setDescription(result.getString("description"));

                items.add(item);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return items;
    }

    /**
     * returns the row that has the passed primary key
     */
    public Item findById(Integer pk) {
        Item item = new Item();
        String select = "SELECT * FROM item WHERE id=?";

        try (PreparedStatement ps = connection.prepareStatement(select);) {
            ps.setInt(1, pk);
            ResultSet result = ps.executeQuery();

            if (result.next()) {
                item.setID(result.getInt("id"));
                item.setName(result.getString("name"));
                item.setDescription(result.getString("description"));
            }
            
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return item;
    }

    /**
     * inserts the passed item object into the item database table
     */
    public void insert(Item item) {
        try (Statement statement = connection.createStatement()) {
            String insert = "INSERT INTO item VALUES (?,?,?)";

            PreparedStatement ps = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, item.getID());
            ps.setString(2, item.getName());
            ps.setString(3, item.getDescription());

            ps.executeUpdate();

            ResultSet keys = ps.getGeneratedKeys();
            if (keys.next()) {
                item.setID(keys.getInt(1));
            }

            
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * updates the database's item table name to match the passed item
     */
    public Boolean update(Item item) {
        Boolean success = true;
        String update = "UPDATE item SET name=? WHERE id=?";

        try (PreparedStatement ps = connection.prepareStatement(update);) {
            ps.setString(1, item.getName());
            ps.setInt(2, item.getID());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            success = false;
        }

        return success;
    }

    /**
     * deletes the row from the item table with the matching primary key
     */
    public Boolean delete(Integer pk) {
        Boolean success = false;
        String delete = "DELETE FROM item WHERE id=?";

        try (PreparedStatement ps = connection.prepareStatement(delete);) {
            ps.setInt(1, pk);

            if (ps.executeUpdate() != 0) {
                success = true;
            }
            
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return success;
    }
    
}
