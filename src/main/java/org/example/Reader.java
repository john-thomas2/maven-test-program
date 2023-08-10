package org.example;

import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public interface Reader {
    public void reader(Connection con,String filename) throws IOException, SQLException, ParseException;
}
