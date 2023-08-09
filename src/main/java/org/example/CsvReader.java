package org.example;

import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CsvReader implements Reader {
    private final static Logger LOGGER =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public ICsvBeanReader beanReader;
    @Override
    public void reader(Connection con,String filename) throws IOException, SQLException {
        int count=0,batch=20;
        String Sql = "INSERT INTO test VALUES(?,?,?,?,?,?,?,?,?,?) ";
        PreparedStatement st = con.prepareStatement(Sql);

        String[] header = {"Year", "Indagg", "Indcode", "Indname", "units", "varcode", "varname", "varval", "val", "indcd"};

        CellProcessor[] processors = new CellProcessor[]{
                new ParseInt(),
                new NotNull(),
                new NotNull(),
                new NotNull(),
                new NotNull(),
                new NotNull(),
                new NotNull(),
                new NotNull(),
                new NotNull(),
                new NotNull(),
        };

        beanReader = new CsvBeanReader(new FileReader("C:\\Users\\john.thomas2\\IdeaProjects\\HelloWorld\\src\\"+filename),
                CsvPreference.STANDARD_PREFERENCE);

        Review bean = null;

        while ((bean = beanReader.read(Review.class, header, processors)) != null) {
            int Year = bean.getYear();
            String Indagg = bean.getIndagg();
            String Indcode = bean.getIndcode();
            String Indname = bean.getIndname();
            String units = bean.getUnits();
            String varcode = bean.getVarcode();
            String varname = bean.getVarname();
            String varval = bean.getVarval();
            String val = bean.getVal();
            String indcd = bean.getIndcd();

            st.setInt(1, Year);
            st.setString(2, Indagg);
            st.setString(3, Indcode);
            st.setString(4, Indname);
            st.setString(5, units);
            st.setString(6, varcode);
            st.setString(7, varname);
            st.setString(8, varval);
            st.setString(9, val);
            st.setString(10, indcd);

            st.addBatch();

            if (count % batch == 0) {
                st.executeBatch();
                LOGGER.log(Level.INFO, "New batch of rows has been inserted");
            }
        }
        beanReader.close();
        st.executeBatch();
        st.close();
    }
}

