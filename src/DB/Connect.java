package DB;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Connect {
    // database URL
    static final String DATABASE_URL = "jdbc:mysql://47.101.217.136/fakeqq";
    static private Connection connection = null; // manages connection
    static private Statement statement = null; // query statement
    static private ResultSet resultSet = null; // manages results

    public Connect() throws ClassNotFoundException, SQLException {   //构造函数
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DATABASE_URL, "root", "password");
            statement = connection.createStatement();
        }
        catch (SQLException | ClassNotFoundException sqlException ) {
            sqlException.printStackTrace();
        } // end catch
    }

    public void queryUser()
    {
        try {
            // query database
            resultSet = statement.executeQuery(
                    "SELECT * from user" );
            // process query results
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            System.out.println( "Authors Table of Books Database:\n" );

            for ( int i = 1; i <= numberOfColumns; i++ )
                System.out.printf( "%-8s\t", metaData.getColumnName( i ) );
            System.out.println();

            while ( resultSet.next() )
            {
                for ( int i = 1; i <= numberOfColumns; i++ )
                    System.out.printf( "%-8s\t", resultSet.getObject( i ) );
                System.out.println();
            } // end while
        }  // end try
        catch (SQLException sqlException )
        {
            sqlException.printStackTrace();
        } // end catch
        finally // ensure resultSet, statement and connection are closed
        {
            try
            {
                resultSet.close();
                statement.close();
                connection.close();
            } // end try
            catch ( Exception exception )
            {
                exception.printStackTrace();
            } // end catch
        } // end finally
    }


    // launch the application
    public static void main( String args[] ) throws SQLException, ClassNotFoundException {
        Connect conn = new Connect();
        conn.queryUser();
    } // end main
} // end class DisplayAuthors






