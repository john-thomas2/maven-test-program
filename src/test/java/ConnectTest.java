import org.example.Connect;
import org.example.CsvReader;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class ConnectTest {
    @Test
    public void Test() throws SQLException, IOException, ClassNotFoundException {
        Connection con=mock(Connection.class);
        PreparedStatement st=mock(PreparedStatement.class);
        when(con.prepareStatement(anyString())).thenReturn(st);
        when(st.executeUpdate()).thenReturn(1);
        CsvReader sample=new CsvReader();
        sample.reader(con,"book1.csv");

        verify(con, times(2))
                .prepareStatement("INSERT INTO test VALUES(?,?,?,?,?,?,?,?,?,?)");

        verify(st).setInt(1, 1);
        verify(st).setString(2, "A");
        verify(st).setInt(3, 22);
        verify(st).setInt(1, 2);
        verify(st).setString(2, "B");
        verify(st).setInt(3, 23);

        verify(st, times(2)).executeUpdate();
        //Connection c= con.connect("config.properties");
        //Assertions.assertNotNull(c);
    }
}
