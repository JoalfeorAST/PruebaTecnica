/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author JoalfeorAST
 */

//Importamos librerías para el manejo de la sintaxis de SQL
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;


/**
 *
 * @author Sena CSET
 */
public class ClsConexion {
    public PreparedStatement Sql;
    public Connection con = null;

//metodo que controla la conexión
    public void conectar() {
        String db = "jdbc:mysql://localhost:3306/PruebaTecnica";
        String usuario = "root";
        String password = "";//la contraseña de la BD
        try {
            String Controlador = "com.mysql.jdbc.Driver";
            Class.forName(Controlador);
            con = DriverManager.getConnection(db, usuario, password);           
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
        }
    }

    public void cerrar() {
        if (con == null) {
            try {
                con.close();
            } catch (Exception ex) {
  JOptionPane.showMessageDialog(null, "No se ha cerrado la conexión con la base de datos");
            }
        }
    }
}


