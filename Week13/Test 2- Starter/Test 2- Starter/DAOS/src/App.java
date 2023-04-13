import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import daos.ItemDao;
import entities.Database;
import entities.Item;

public class App {
    public static void main(String[] args) throws Exception {
        
        List<Item> itemList;

        try (Connection connection = Database.getDatabaseConnection();
            Statement statement = connection.createStatement();) {

            ItemDao itemDao = new ItemDao(connection);

            //findAll()
            itemList = itemDao.findAll();

            System.out.println("Printing Items");
            for (Item item: itemList) {
                System.out.println(item);
            }
            
            //insert()
            Item insertItem = new Item();
            insertItem.setID(9);
            insertItem.setName("Keyboard");
            insertItem.setDescription("A bunch of keys");
            itemDao.insert(insertItem);

            //findById()
            Item item = new Item();
            item = itemDao.findById(9);
            System.out.println("Item returned from findById(9): " + item);

            //update()
            item.setName("Blue Keyboard");
            Boolean success = itemDao.update(item);
            System.out.println("item after the update: " + itemDao.findById(9));

            //delete()
            itemDao.delete(9);
            ResultSet resultSet = statement.executeQuery("SELECT * FROM item");

            while (resultSet.next()) {
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getString("name"));
            }

            resultSet.close();

            
        } catch (SQLException ex) {
            System.err.println("Exception: " + ex.getMessage());
        }
    
    }
}
