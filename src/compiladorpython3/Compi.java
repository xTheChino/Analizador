package compiladorpython3;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Erik Ortiz
 */
public class Compi extends javax.swing.JFrame implements ActionListener {
    
    public Compi() {
        initComponents();
    }

    
    static List<Variables> TablaVariables = new ArrayList<>();
    static List<Operadores> TablaOperadores = new ArrayList<>();
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtInst = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableVariables = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableOperadores = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Creador de Tokens Python");
        setResizable(false);

        jLabel1.setText("Instruccion");

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(this);

        tableVariables.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Token", "Descripcion"
            }
        ));
        jScrollPane3.setViewportView(tableVariables);

        tableOperadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Token", "Descripcion"
            }
        ));
        jScrollPane4.setViewportView(tableOperadores);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("TABLA DE VARIABLES");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("TABLA DE OPERADORES");

        btnLimpiar.setText("Resetear");
        btnLimpiar.addActionListener(this);

        jLabel4.setText("Ortiz Quijano Erik Alexander");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtInst)
                        .addGap(18, 18, 18)
                        .addComponent(btnAceptar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtInst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAceptar)
                            .addComponent(jLabel1))
                        .addGap(38, 38, 38))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar)
                    .addComponent(jLabel4))
                .addGap(14, 14, 14))
        );

        pack();
        setLocationRelativeTo(null);
    }

    // Code for dispatching events from components to event handlers.

    public void actionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == btnAceptar) {
            Compi.this.btnAceptarActionPerformed(evt);
        }
        else if (evt.getSource() == btnLimpiar) {
            Compi.this.btnLimpiarActionPerformed(evt);
        }
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
       
        
        String instruccion = txtInst.getText();         //pedir la instruccion
        
        String[] token = instruccion.split("\\W+");                                         //dividir por tokens la instruccion
        
        for (int i=0; i<token.length;i++){      //para checar cada token
            checarVariable(token[i]);
            checarNOT(token[i]);
            checarAND(token[i]);
            checarOR(token[i]);   
            
        }   
        imprimirVariables();
        imprimirOperadores();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        limpiarTabla();
    }//GEN-LAST:event_btnLimpiarActionPerformed


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
            java.util.logging.Logger.getLogger(Compi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Compi().setVisible(true);
            }
        });
    }
    
    
    
    ///////////////////// METODOS ////////////////////////
    
    public static void checarVariable(String token){
        Pattern pat = Pattern.compile("[a-zA-Z]||[a-zA-Z]\\w*[^not ^and ^or]");
        Matcher mat = pat.matcher(token);
        
        Pattern patNOT = Pattern.compile("not");        //uso este para ignorar "not"
        Matcher matNOT = patNOT.matcher(token);         //uso este para ignorar "not"
        
        Pattern patAND = Pattern.compile("and");        //uso este para ignorar "and"
        Matcher matAND = patAND.matcher(token);         //uso este para ignorar "and"
        
        Pattern patOR = Pattern.compile("or");          //uso este para ignorar "or"
        Matcher matOR = patOR.matcher(token);           //uso este para ignorar "or"
        
        Variables var;
        
        if (mat.matches()){
            //agregar tabla correctas
            if (checarExistencia(token) == false){                  // si es falso no eciste el token el la tabla y agrega
                var = new Variables(token,"Varible Correcta"); 
                TablaVariables.add(var);
            }
            
        }else{
            
            if (matNOT.find()||matAND.find()||matOR.find())        //Ignorar tokens "not, and, or"
               return;
            //agregar en la tabla incorrectas
            if (checarExistencia(token) == false){                  // si es falso no eciste el token el la tabla y agrega
                var = new Variables(token,"Posible varible mal escrita"); 
                TablaVariables.add(var);
            }
            
        }
        
    }
     
    public static void checarNOT(String token){
        Pattern pat = Pattern.compile("not");
        Matcher mat = pat.matcher(token);
        Operadores oper;
        if (mat.matches()){
            //agregar en not correctas
            if (checarExistenciaOper(token) == false){                  // si es falso no eciste el token el la tabla y agrega
                oper = new Operadores(token,"Operador Correcto"); 
                TablaOperadores.add(oper);
            }
        }else{
            if ((mat.find())){      //si encuentra "not" quiere decur que es un not incorrecto
                //agregar a las incorrectas
                if (checarExistenciaOper(token) == false){                  // si es falso no eciste el token el la tabla y agrega
                    oper = new Operadores(token,"Posible operador mal escrito"); 
                    TablaOperadores.add(oper);
                }
            }
                
        }
        
    }
    
    public static void checarAND(String token){
        Pattern pat = Pattern.compile("and");
        Matcher mat = pat.matcher(token);   
        Operadores oper;
        if (mat.matches()){
            //agregar en and correctas
             if (checarExistenciaOper(token) == false){                  // si es falso no eciste el token el la tabla y agrega
                oper = new Operadores(token,"Operador Correcto"); 
                TablaOperadores.add(oper);
            }
        }else{
            if ((mat.find())){      //si encuentra "and" quiere decur que es un and incorrecto
               //agregar a las incorrectas
                if (checarExistenciaOper(token) == false){                  // si es falso no eciste el token el la tabla y agrega
                    oper = new Operadores(token,"Posible operador mal escrito"); 
                    TablaOperadores.add(oper);
                }
            }
        }
    }

    public static void checarOR(String token){
        Pattern pat = Pattern.compile("or");
        Matcher mat = pat.matcher(token);  
        Operadores oper;
        if (mat.matches()){
            //agregar en or correctas
            if (checarExistenciaOper(token) == false){                  // si es falso no eciste el token el la tabla y agrega
                oper = new Operadores(token,"Operador Correcto"); 
                TablaOperadores.add(oper);
            }
        }else{
            if ((mat.find())){      //si encuentra "or" quiere decur que es un or incorrecto
                //agregar a las incorrectas
                if (checarExistenciaOper(token) == false){                  // si es falso no eciste el token el la tabla y agrega
                    oper = new Operadores(token,"Posible operador mal escrito"); 
                    TablaOperadores.add(oper);
                }
            }
        }
    }
    
    public static boolean checarExistencia(String token){
        Variables var;
        for (int i=0; i<TablaVariables.size();i++){
            var = TablaVariables.get(i);
            if (var.getToken().equals(token))
                return true;
        }
        return false;
    }
    
    public static boolean checarExistenciaOper(String token){
        Operadores oper;
        for (int i=0; i<TablaOperadores.size();i++){
            oper = TablaOperadores.get(i);
            if (oper.getToken().equals(token))
                return true;
        }
        return false;
    }
    
    ////////////////////// IMPRESORES ////////////////////
    
    public static void imprimirVariables(){
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"TOKEN","Descripcion"});
        Object[] row = new Object[2];
        
        for(int i = 0; i < TablaVariables.size(); i++)
        {
            row[0] = TablaVariables.get(i).getToken();
            row[1] = TablaVariables.get(i).getDescripcion();
            model.addRow(row);
        }
       tableVariables.setModel(model);
    }
    
    public static void imprimirOperadores(){
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"TOKEN","Descripcion"});
        Object[] row = new Object[2];
        
        for(int i = 0; i < TablaOperadores.size(); i++)
        {
            row[0] = TablaOperadores.get(i).getToken();
            row[1] = TablaOperadores.get(i).getDescripcion();
            model.addRow(row);
        }
       tableOperadores.setModel(model);
    }
    
    public static void limpiarTabla(){
             //HACER QUE ME LIMPIE LAS TABLAS
             DefaultTableModel model = new DefaultTableModel();
             model.setColumnIdentifiers(new Object[]{"TOKEN","Descripcion"});
             model.setRowCount(0);
            tableOperadores.setModel(model);
            TablaOperadores.clear();
            tableVariables.setModel(model);
            TablaVariables.clear();
    
    }
    
    ////////////////////// CLASES ///////////////////
    
    public static class Variables {
        String token;
        String descripcion;

        public Variables(String token, String descripcion) {
            this.token = token;
            this.descripcion = descripcion;
        }

        public String getToken() {
            return token;
        }

        public String getDescripcion() {
            return descripcion;
        }

    }
    
    public static class Operadores {
        String token;
        String descripcion;

        public Operadores(String token, String descripcion) {
            this.token = token;
            this.descripcion = descripcion;
        }

        public String getToken() {
            return token;
        }

        public String getDescripcion() {
            return descripcion;
        }

    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private static javax.swing.JTable tableOperadores;
    private static javax.swing.JTable tableVariables;
    private javax.swing.JTextField txtInst;
    // End of variables declaration//GEN-END:variables
}
