package sql;

import java.sql.*;

public class Conexion {
    public static Connection getConexion() {

        Connection connection = null;
        try {
           String driverClassName = "oracle.jdbc.OracleDriver";
           String driverUrl="jdbc:oracle:thin:@//localhost:1521/XE";
           Class.forName(driverClassName);
           connection = DriverManager.getConnection(driverUrl,"frutos","frutos");
        }catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

}