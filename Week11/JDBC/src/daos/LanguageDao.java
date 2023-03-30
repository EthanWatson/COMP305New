package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Language;
import entities.Language.PK;

public class LanguageDao implements Dao<Language, Language.PK> {
    Connection connection;

    public LanguageDao(Connection connection) {
        this.connection = connection;
    }

    public List<Language> findAll() {
        List<Language> languageList = new ArrayList<>();

        try (Statement statement = connection.createStatement();) {
            ResultSet result = statement.executeQuery("Select * FROM CountryLanguage");
            while(result.next()) {
                Language language = new Language(
                    result.getString("Count"),
                    result.getString("Language"),
                    result.getBoolean("isOfficial"),
                    result.getFloat("percentage")
                );

                languageList.add(language);
            }
        }
        catch(SQLException e) {
            System.err.println(e.getMessage());
        }

        return languageList;
    }

    public void insert(Language language) {

    }

    public Boolean update(Language language) {
        return true;
    }

    public Boolean delete(Language pk) {
        return true;
    }

    public Language findById(Language pk) {
        Language language = new Language(null, null, null, null);
        return language;
    }
}
