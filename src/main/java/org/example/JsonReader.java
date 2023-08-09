package org.example;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonReader implements Reader {
    private final static Logger LOGGER =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    @Override
    public void reader(Connection con, String filename) throws IOException, SQLException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray array = (JSONArray) parser.parse(new java.io.FileReader("C:\\Users\\john.thomas2\\IdeaProjects\\HelloWorld\\src\\"+filename));

        for (Object obj : array) {
            JSONObject json = (JSONObject) obj;
            int sno = ((Long) json.get("sno")).intValue();
            String name = (String) json.get("name");
            int age = ((Long) json.get("age")).intValue();

            String sql = "INSERT INTO people (sno, name, age) VALUES (?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, sno);
            statement.setString(2, name);
            statement.setInt(3, age);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new row was inserted successfully!");
                LOGGER.log(Level.INFO, "New row has been inserted");
            }
        }
    }
}
