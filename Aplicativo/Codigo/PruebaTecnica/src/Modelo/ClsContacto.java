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
public class ClsContacto {
    
    //Creamos un objeto la conexion con la db
        ClsConexion objConec = new ClsConexion();
        public ResultSet datos;

    //Declaración de variables
        private String nom_con;
        private int tel_con;
        private String ema_con;
        private String asu_con;
        private String men_con;
        
    //Encapsulamiento    
        public String getNom_con() {
            return nom_con;
        }

        public void setNom_con(String nom_con) {
            this.nom_con = nom_con;
        }

        public int getTel_con() {
            return tel_con;
        }

        public void setTel_con(int tel_con) {
            this.tel_con = tel_con;
        }

        public String getEma_con() {
            return ema_con;
        }

        public void setEma_con(String ema_con) {
            this.ema_con = ema_con;
        }

        public String getAsu_con() {
            return asu_con;
        }

        public void setAsu_con(String asu_con) {
            this.asu_con = asu_con;
        }

        public String getMen_con() {
            return men_con;
        }

        public void setMen_con(String men_con) {
            this.men_con = men_con;
        }

    //Metodo para guardar registros en la db
        public void guardar() {
        try {
            objConec.conectar();
            objConec.Sql = objConec.con.prepareStatement("insert into contacto values(null,?,?,?,?,?)");
            objConec.Sql.setString(1, getNom_con());
            objConec.Sql.setInt(2, getTel_con());           
            objConec.Sql.setString(3, getEma_con());
            objConec.Sql.setString(4, getAsu_con());
            objConec.Sql.setString(5, getMen_con());
            objConec.Sql.executeUpdate();
            objConec.cerrar();
            JOptionPane.showMessageDialog(null, "Mensaje enviado correctamente");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al enviar el mensaje");

        }

    }        
        
    
}
