package clases;

import java.sql.*;

public class Conexion {
    
    //Conexion a la base de datos local
    public static Connection conectar() {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/school_system", "root", "");
            return cn;
        } catch (SQLException e) {
            System.out.println("Error en conexión local" + e);
        }
        return null;
    }
}
