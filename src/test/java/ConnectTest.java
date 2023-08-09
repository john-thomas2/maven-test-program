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
    public void Test() throws SQLException, IOException {
        Connection con=mock(Connection.class);
        PreparedStatement st=mock(PreparedStatement.class);
        when(con.prepareStatement(anyString())).thenReturn(st);
        when(st.executeUpdate()).thenReturn(1);
        CsvReader sample=new CsvReader();
        sample.reader(con,"book1.csv");

        verify(con, times(1)).prepareStatement("INSERT INTO test VALUES(?,?,?,?,?,?,?,?,?,?)");

        verify(st).setInt(1, 2021);
        verify(st).setString(2, "Level 1");
        verify(st).setString(3, "99999");
        verify(st).setString(4, "All industries");
        verify(st).setString(5,"Dollars (millions)");
        verify(st).setString(6, "H01");
        verify(st).setString(7, "Total income");
        verify(st).setString(8, "Financial performance");
        verify(st).setString(9, "757,504");
        verify(st).setString(10, "ANZSIC06 divisions A-S (excluding classes K6330, L6711, O7552, O760, O771, O772, S9540, S9601, S9602, and S9603)");


        verify(st, times(2)).executeBatch();
    }
}
