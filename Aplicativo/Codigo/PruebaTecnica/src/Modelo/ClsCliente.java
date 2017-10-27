/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import Controlador.ClsConexion;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author JoalfeorAST
 */
public class ClsCliente {
    
    //Creamos un objeto la conexion con la db
        ClsConexion objConec = new ClsConexion();
        public ResultSet datos;

    //Declaración de variables
        private int doc_cli;
        private String nom_cli;
        private String ape_cli;
        private String dir_cli;
        private String tel_cli;
        
    //Encapsulacion de variables   
        public int getDoc_cli() {
            return doc_cli;
        }

        public void setDoc_cli(int doc_cli) {
            this.doc_cli = doc_cli;
        }

        public String getNom_cli() {
            return nom_cli;
        }

        public void setNom_cli(String nom_cli) {
            this.nom_cli = nom_cli;
        }

        public String getApe_cli() {
            return ape_cli;
        }

        public void setApe_cli(String ape_cli) {
            this.ape_cli = ape_cli;
        }

        public String getDir_cli() {
            return dir_cli;
        }

        public void setDir_cli(String dir_cli) {
            this.dir_cli = dir_cli;
        }

        public String getTel_cli() {
            return tel_cli;
        }

        public void setTel_cli(String tel_cli) {
            this.tel_cli = tel_cli;
        }        
      
           
    //Metodo para guardar registros en la db
        public void guardar() {
        try {
            objConec.conectar();
            objConec.Sql = objConec.con.prepareStatement("insert into cliente values(null,?,?,?,?,?)");
            objConec.Sql.setInt(1, getDoc_cli());
            objConec.Sql.setString(2, getNom_cli());
            objConec.Sql.setString(3, getApe_cli());
            objConec.Sql.setString(4, getDir_cli());
            objConec.Sql.setString(5, getTel_cli());
            objConec.Sql.executeUpdate();
            objConec.cerrar();
            JOptionPane.showMessageDialog(null, "Registro guardado con éxito");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar");

        }

    }
        
    //Metodo para buscar registros en la db
        public void Buscar() {
        try {
            objConec.conectar();
            objConec.Sql = objConec.con.prepareStatement("SELECT * FROM cliente WHERE doc_cli=?");
            objConec.Sql.setInt(1, getDoc_cli());
            objConec.Sql.executeQuery();
            datos = objConec.Sql.getResultSet();
        } catch (Exception ex) {
            System.out.println("Error al buscar");
        }
    }
        
    //Metodo para actualizar registros en la db
        public void Actualizar() {
        try {
            objConec.conectar();
            objConec.Sql = objConec.con.prepareStatement("UPDATE cliente SET nom_cli=?, ape_cli=?, dir_cli=?, tel_cli=?, doc_cli=?");
            objConec.Sql.setString(1, getNom_cli());
            objConec.Sql.setString(2, getApe_cli());
            objConec.Sql.setString(3, getDir_cli());
            objConec.Sql.setString(4, getTel_cli());
            objConec.Sql.setInt(5, getDoc_cli());
            objConec.Sql.executeUpdate();
            objConec.cerrar();
            JOptionPane.showMessageDialog(null, "Registro actualizado con éxito");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar");
        }
    }
        
    //Metodo para eliminar registros en la db
        public void eliminar() {
        try {
            objConec.conectar();
            objConec.Sql = objConec.con.prepareStatement("delete from cliente where doc_cli=?");
            objConec.Sql.setInt(1, getDoc_cli());
            objConec.Sql.executeUpdate();
            objConec.cerrar();
            JOptionPane.showMessageDialog(null, "Registro eliminado con éxito");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar");
        }
    }
}
