
package Controlador;

import Modelo.Carrera;
import bd.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author USRVI-LC2
 */
public class Registro {
    
    public boolean agregarCarrera(Carrera carrera)
    {
        
        try {
            Conexion con = new Conexion();
            Connection conx = con.obtenerConexion();
            
            String query = "Insert into carrera (idCarrera,nombre) values (?,?)";
            PreparedStatement stmt = conx.prepareStatement(query);
            stmt.setInt(1, carrera.getIdCarrera());
            stmt.setString(2, carrera.getNombre());
            
            stmt.executeUpdate();
            stmt.close();
            conx.close();
            
            return true;
            
            
        } catch (SQLException e) {
            
            System.out.println("Error de SQL al ingresar carrera " + e.getMessage());
            return false;
        }
        
        
    }
    
}
