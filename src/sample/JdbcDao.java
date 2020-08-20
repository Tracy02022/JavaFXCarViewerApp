package sample;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcDao {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/movie?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "root1234";
    private static final String SELECT_QUERY = "SELECT * FROM registration WHERE email_id = ? and password = ?";
    private static final String INSERT_QUERY = "INSERT INTO registration (email_id, password) values (?, ?)";
    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;


    public boolean validate(String emailId, String password) throws SQLException {
        try {
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

            preparedStatement = connection.prepareStatement(SELECT_QUERY);
                preparedStatement.setString(1, emailId);
                preparedStatement.setString(2, password);

                System.out.println(preparedStatement);

                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return true;
                }

            } catch (SQLException e) {
                printStackTrace(e);
        }
        return false;
    }

    public void createUser(String emailId, String password) throws SQLException {
        try {
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

            preparedStatement = connection.prepareStatement(INSERT_QUERY);
            preparedStatement.setString(1, emailId);
            preparedStatement.setString(2, password);

            System.out.println(preparedStatement);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            printStackTrace(e);
        }

    }
    
    public Cars searchCar(int id) throws SQLException {
        try {
            String name = null;
            String desc = null;
            int year = 0;
            
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

            String search_query = "select * from cars where id = ? ";
            preparedStatement = connection.prepareStatement(search_query);
            preparedStatement.setInt(1, id);


            System.out.println(preparedStatement);

            resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                desc = resultSet.getString(2);
                name = resultSet.getString(1);
                year = resultSet.getInt(3);
                 System.out.println("name : " + name + " desc : " + desc + " year : " + year);
                
                
            }
            
            Cars car = new Cars(id, name, year, desc);
            return car;
 
        } catch (SQLException e) {
            printStackTrace(e);
        }
          return null;
    }

    public void closeConn() {
        try {
            connection.close();
            if (preparedStatement != null)
                preparedStatement.close();
            if (resultSet != null)
                resultSet.close();
        } catch (SQLException e) {
            printStackTrace(e);
        }
    }

    private void printStackTrace(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }

    }
}
