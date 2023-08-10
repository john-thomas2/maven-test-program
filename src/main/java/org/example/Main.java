package org.example;

import org.json.simple.parser.ParseException;

import java.sql.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException, ParseException {
        Connect Conn=new Connect();
        Connection con=Conn.connect("config.properties");

        String file=args[0]+"."+args[1];
        String filetype=args[1];
        switch(filetype)
        {
            case "csv":
                CsvReader Csv=new CsvReader();
                Csv.reader(con,file);
                break;
            case "json":
                JsonReader Json=new JsonReader();
                Json.reader(con,file);
                break;
            default: System.out.println("Invalid file extension");
        }
    }
}