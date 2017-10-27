/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
import Modelo.ClsCliente;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author JoalfeorAST
 */
public class FrmCliente extends javax.swing.JFrame {

    /**
     * Creates new form FrmCliente
     */
    public FrmCliente() {
        initComponents();
        this.setLocationRelativeTo(this);
    }
    
    //Creamos el objeto para conectar el formulario con la clase
    ClsCliente cliente = new ClsCliente();
    
    
    //método para validar las cajas de texto y llama al método guardar
    public void validar() {
        if (txtdoc_cli.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Falto digitar el documento");
            txtdoc_cli.grabFocus();

        } else if (txtnom_cli.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Falto digitar el nombre");
            txtnom_cli.grabFocus();

        } else if (txtape_cli.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Falto digitar el apellido");
            txtape_cli.grabFocus();

        } else if (txtdir_cli.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Falto digitar la direccion");
            txtdir_cli.grabFocus();

        } else if (txttel_cli.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Falto digitar el telefono");
            txttel_cli.grabFocus();

        } else {
            this.captura();
            cliente.guardar();
        }
    }
    
    //Metodo para comprobar que no se encuentre registrado el documento en la db
    public void testear() {
        try {          
            this.captura();
            cliente.Buscar();
            if (cliente.datos.next() == true) {
                JOptionPane.showMessageDialog(this, "El documento ya esta registrado");
                
            } else {
                JOptionPane.showMessageDialog(this, "El documento no esta registrado");
                txtnom_cli.grabFocus();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falta digitar el documento");
        }
    } 
    
    //metodo capturamos los datos 
    public void captura() {
            cliente.setDoc_cli(Integer.parseInt(txtdoc_cli.getText()));
            cliente.setNom_cli(txtnom_cli.getText());
            cliente.setApe_cli(txtape_cli.getText());
            cliente.setDir_cli(txtdir_cli.getText());
            cliente.setTel_cli(txttel_cli.getText());
    }
    
    
    //validar que el campo documento no se encuentre registrado
    public void duplicar() {
        try {           
            this.captura();
            cliente.Buscar();
            if (cliente.datos.next() == true) {
                JOptionPane.showMessageDialog(this, "El documento ya esta registrado");
                txtdoc_cli.setText("" + cliente.datos.getInt("doc_cli"));
                txtnom_cli.setText(cliente.datos.getString("nom_cli"));
                txtape_cli.setText(cliente.datos.getString("ape_cli"));
                txtdir_cli.setText(cliente.datos.getString("dir_cli"));
                txttel_cli.setText(cliente.datos.getString("tel_cli"));
            } else {
                this.validar();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fallas tecnicas al buscar");
        }
    }
    
    
    //Se va a llamar el método buscar de la clase 
    public void buscar() {
        try {
            String bus = JOptionPane.showInputDialog(null, "Digite el documento a buscar");
            cliente.setDoc_cli(Integer.parseInt(bus));
            cliente.Buscar();
            if (cliente.datos.next() == true) {
                txtdoc_cli.setText("" + cliente.datos.getInt("doc_cli"));
                txtnom_cli.setText(cliente.datos.getString("nom_cli"));
                txtape_cli.setText(cliente.datos.getString("ape_cli"));
                txtdir_cli.setText(cliente.datos.getString("dir_cli"));
                txttel_cli.setText(cliente.datos.getString("tel_cli"));
            } else {
                JOptionPane.showMessageDialog(null, "El cliente no existe");
            }
        } catch (Exception e) {
            System.out.println("Fallas tecnicas al buscar");
        }
    }
    
    //Se va a llamar el método actualizar de la clase 
    public void actualizar() {
        try {
            this.captura();
            cliente.Actualizar();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Fallas Tecnicas");
        }
    }

    //Se va a llamar el método eliminar de la clase   
    public void eliminar() { 
        int a = JOptionPane.showConfirmDialog(null, "Desea Eliminar los datos?", "Sistema", 0, 1);
        if (a == 0) //  Hace clic en el icono SI 
        {
            cliente.eliminar();
        }
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btneliminar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        btnbuscar = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btnnuevo = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txttel_cli = new javax.swing.JTextField();
        txtdir_cli = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtape_cli = new javax.swing.JTextField();
        txtnom_cli = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtdoc_cli = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btncomprobar = new javax.swing.JButton();
        btncomprobar1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cliente");
        setMaximumSize(new java.awt.Dimension(600, 300));
        setMinimumSize(new java.awt.Dimension(600, 300));
        setPreferredSize(new java.awt.Dimension(600, 300));
        setResizable(false);
        setSize(new java.awt.Dimension(600, 300));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btneliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btneliminar.setText("Eliminar");
        btneliminar.setEnabled(false);
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, 90, 30));

        btnactualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnactualizar.setText("Actualizar");
        btnactualizar.setEnabled(false);
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnactualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, -1, 30));

        btnmodificar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnmodificar.setText("Modificar");
        btnmodificar.setEnabled(false);
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 90, 30));

        btnbuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 80, 30));

        btnguardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));
        btnguardar.setBorderPainted(false);
        btnguardar.setEnabled(false);
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 90, 30));

        btnnuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btnnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 70, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("     Telefono  ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 80, 20));

        txttel_cli.setEnabled(false);
        txttel_cli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttel_cliActionPerformed(evt);
            }
        });
        txttel_cli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txttel_cliKeyPressed(evt);
            }
        });
        getContentPane().add(txttel_cli, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 160, -1));

        txtdir_cli.setEnabled(false);
        txtdir_cli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdir_cliActionPerformed(evt);
            }
        });
        getContentPane().add(txtdir_cli, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 160, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText(" Direccion");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 60, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("  Apellido");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 60, 20));

        txtape_cli.setEnabled(false);
        txtape_cli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtape_cliActionPerformed(evt);
            }
        });
        getContentPane().add(txtape_cli, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 160, -1));

        txtnom_cli.setEnabled(false);
        txtnom_cli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnom_cliActionPerformed(evt);
            }
        });
        getContentPane().add(txtnom_cli, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 160, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("    Nombre");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 70, 20));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("  Documento");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 80, 20));

        txtdoc_cli.setEnabled(false);
        txtdoc_cli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdoc_cliActionPerformed(evt);
            }
        });
        txtdoc_cli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtdoc_cliKeyPressed(evt);
            }
        });
        getContentPane().add(txtdoc_cli, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 160, -1));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 29)); // NOI18N
        jLabel6.setText("CLIENTE");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 120, 30));

        btncomprobar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btncomprobar.setText("Comprobar documento");
        btncomprobar.setEnabled(false);
        btncomprobar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncomprobarActionPerformed(evt);
            }
        });
        getContentPane().add(btncomprobar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 170, 30));
        btncomprobar.getAccessibleContext().setAccessibleName("Comprobar \ndocumento");

        btncomprobar1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btncomprobar1.setText("Contacto");
        btncomprobar1.setMaximumSize(new java.awt.Dimension(79, 23));
        btncomprobar1.setMinimumSize(new java.awt.Dimension(79, 23));
        btncomprobar1.setPreferredSize(new java.awt.Dimension(79, 23));
        btncomprobar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncomprobar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btncomprobar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 200, 90, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/fondo.jpg"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed

        //conectamos con la clase y metodo
        this.eliminar();

        //deshabilitar botone
        btnmodificar.setEnabled(false);
        btneliminar.setEnabled(false);
        btncomprobar.setEnabled(false);
        
        //limpiar campos
        txtdoc_cli.setText("");
        txtnom_cli.setText("");
        txtape_cli.setText("");
        txtdir_cli.setText("");
        txttel_cli.setText("");
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        // TODO add your handling code here:
        this.actualizar();

        //limpiar campos
        txtdoc_cli.setText("");
        txtnom_cli.setText("");
        txtape_cli.setText("");
        txtdir_cli.setText("");
        txttel_cli.setText("");

        //deshabilitar botones
        btnactualizar.setEnabled(false);
        btneliminar.setEnabled(false);
        btncomprobar.setEnabled(false);

        //habilitar boton
        btnbuscar.setEnabled(true);

        //habilitar campos
        txtdoc_cli.setEnabled(false);
        txtnom_cli.setEnabled(false);
        txtape_cli.setEnabled(false);
        txtdir_cli.setEnabled(false);
        txttel_cli.setEnabled(false);
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        // TODO add your handling code here:

        //habilitar campos
        txtdoc_cli.setEnabled(true);
        txtnom_cli.setEnabled(true);
        txtape_cli.setEnabled(true);
        txtdir_cli.setEnabled(true);
        txttel_cli.setEnabled(true);

        //habilitar botones
        btnactualizar.setEnabled(true);

        //deshabilitar botones
        btnmodificar.setEnabled(false);
        btnbuscar.setEnabled(false);
        btneliminar.setEnabled(false);
        btncomprobar.setEnabled(false);
    }//GEN-LAST:event_btnmodificarActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        
        txtdoc_cli.setText("");
        txtnom_cli.setText("");
        txtape_cli.setText("");
        txtdir_cli.setText("");
        txttel_cli.setText("");

        this.buscar();

        if (txtdoc_cli.getText().isEmpty())
        {
            txtdoc_cli.setEnabled(false);
            txtnom_cli.setEnabled(false);
            txtape_cli.setEnabled(false);
            txtdir_cli.setEnabled(false);
            txttel_cli.setEnabled(false);

        }
        else
        {

            //habilitar botones
            btnmodificar.setEnabled(true);
            btneliminar.setEnabled(true);

            //deshabilitar botones
            btnactualizar.setEnabled(false);
            btncomprobar.setEnabled(false);
        }

    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        
        this.validar();

        //deshabilitar campos
        txtdoc_cli.setEnabled(false);
        txtnom_cli.setEnabled(false);
        txtape_cli.setEnabled(false);
        txtdir_cli.setEnabled(false);
        txttel_cli.setEnabled(false);

        //limpiar campos
        txtdoc_cli.setText("");
        txtnom_cli.setText("");
        txtape_cli.setText("");
        txtdir_cli.setText("");
        txttel_cli.setText("");

        //deshabilitar botones
        btnguardar.setEnabled(false);
        btncomprobar.setEnabled(false);

        //habilitar botones
        btnbuscar.setEnabled(true);
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed

        //foco al documento
        txtdoc_cli.grabFocus();

        //limpiar campos
        txtdoc_cli.setText("");
        txtnom_cli.setText("");
        txtape_cli.setText("");
        txtdir_cli.setText("");
        txttel_cli.setText("");

        //habilitar campos
        txtdoc_cli.setEnabled(true);
        txtnom_cli.setEnabled(true);
        txtape_cli.setEnabled(true);
        txtdir_cli.setEnabled(true);
        txttel_cli.setEnabled(true);

        //habilitar botones
        btnguardar.setEnabled(true);
        btncomprobar.setEnabled(true);

        //deshabilitar botones
        btnbuscar.setEnabled(false);
        btnmodificar.setEnabled(false);
        btnactualizar.setEnabled(false);
        btneliminar.setEnabled(false);
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void txttel_cliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttel_cliActionPerformed

    }//GEN-LAST:event_txttel_cliActionPerformed

    private void txttel_cliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttel_cliKeyPressed

        //Validar para que solo reciba numeros
        txttel_cli.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)))) {
                    getToolkit().beep();
                    e.consume();
                }
            }
        });
    }//GEN-LAST:event_txttel_cliKeyPressed

    private void txtdir_cliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdir_cliActionPerformed

    }//GEN-LAST:event_txtdir_cliActionPerformed

    private void txtape_cliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtape_cliActionPerformed

    }//GEN-LAST:event_txtape_cliActionPerformed

    private void txtnom_cliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnom_cliActionPerformed

    }//GEN-LAST:event_txtnom_cliActionPerformed

    private void txtdoc_cliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdoc_cliActionPerformed

    }//GEN-LAST:event_txtdoc_cliActionPerformed

    private void txtdoc_cliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdoc_cliKeyPressed

        // validar solo recibir numeros
        txtdoc_cli.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)))) {
                    getToolkit().beep();
                    e.consume();
                }
            }
        });
    }//GEN-LAST:event_txtdoc_cliKeyPressed

    private void btncomprobarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncomprobarActionPerformed
        this.testear();
    }//GEN-LAST:event_btncomprobarActionPerformed

    private void btncomprobar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncomprobar1ActionPerformed
        FrmContacto obj=new FrmContacto();
          obj.setVisible(true);
          dispose();
    }//GEN-LAST:event_btncomprobar1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncomprobar;
    private javax.swing.JButton btncomprobar1;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtape_cli;
    private javax.swing.JTextField txtdir_cli;
    private javax.swing.JTextField txtdoc_cli;
    private javax.swing.JTextField txtnom_cli;
    private javax.swing.JTextField txttel_cli;
    // End of variables declaration//GEN-END:variables
}
