
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Frame extends javax.swing.JFrame {
    
    private static final String dbURL = "jdbc:derby://localhost:1527/User;create=true"; // create=true -> base de donné cree si inexistante
    private static final String tableName = "Users"; // Table ou l'on va mettre les données
    
    // jdbc Connection
    private static Connection conn = null;
    private static Statement stmt = null;
    
    
    public Frame() {
        initComponents();
        createConnection();
        initTable();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Enregistrer_Btn = new javax.swing.JButton();
        Nom_Text = new javax.swing.JTextField();
        Prenom_Text = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        OperationResult_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestionnaire utilisateur");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        Enregistrer_Btn.setBackground(new java.awt.Color(153, 153, 153));
        Enregistrer_Btn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Enregistrer_Btn.setForeground(new java.awt.Color(0, 102, 102));
        Enregistrer_Btn.setText("Enregistrer");
        Enregistrer_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Enregistrer_BtnActionPerformed(evt);
            }
        });

        Nom_Text.setBackground(new java.awt.Color(204, 204, 204));
        Nom_Text.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Nom_Text.setForeground(new java.awt.Color(0, 102, 102));
        Nom_Text.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Nom_Text.setText("Hard");
        Nom_Text.setCaretColor(new java.awt.Color(255, 255, 255));
        Nom_Text.setSelectionColor(new java.awt.Color(204, 255, 255));

        Prenom_Text.setBackground(new java.awt.Color(204, 204, 204));
        Prenom_Text.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Prenom_Text.setForeground(new java.awt.Color(0, 102, 102));
        Prenom_Text.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Prenom_Text.setText("Clément");
        Prenom_Text.setCaretColor(new java.awt.Color(255, 255, 255));
        Prenom_Text.setSelectionColor(new java.awt.Color(204, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Nom :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Prénom :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("Gestionnaire Utilisateurs");
        jLabel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        OperationResult_label.setForeground(new java.awt.Color(153, 153, 255));
        OperationResult_label.setText("Status : OK");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 247, Short.MAX_VALUE)
                        .addComponent(Enregistrer_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Prenom_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Nom_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel3)
                            .addComponent(OperationResult_label))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(OperationResult_label)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nom_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Prenom_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(24, 24, 24)
                .addComponent(Enregistrer_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Enregistrer_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Enregistrer_BtnActionPerformed
        // On recupere le nom et le prénom des champs de texte
        // On Verifie que le texte est valide pour être mis dans la base de donné
        // On le met dans la base de donnée
        
        String prenom = Prenom_Text.getText();
        String nom = Nom_Text.getText();
        
        // On supprime les espaces
        prenom = prenom.trim();
        nom = nom.trim();
        
        // On verifie que l'on a bien quelque chose a enregistrer
        if(prenom.length() == 0 || nom.length() == 0){
            System.out.println("Champs prenom ou nom vide");
            OperationResult_label.setText("Erreurs : Nom ou prenom vide..");
            return;
        }
        
        // On verifie que le nom et le prenom comporte au moins 3 caracteres.
        if(prenom.length() < 3 || nom.length() < 3){
            System.out.println("prenom ou nom trop court");
            OperationResult_label.setText("Erreurs : Nom ou prenom invalide.");
            return;
        }
        
        insertUser(nom, prenom);
    }//GEN-LAST:event_Enregistrer_BtnActionPerformed
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Frame().setVisible(true);
        });
    }

    private static void insertUser(String nom, String prenom)
    {
        try
        {
            stmt = conn.createStatement();
            //" + nom + "," + prenom +"
            stmt.execute("INSERT INTO " + tableName + "(Nom, prenom) VALUES ('" + nom + "','" + prenom +"')");
            stmt.close();
            
            OperationResult_label.setText("Utilisateur enregistré !");
            Prenom_Text.setText("");
            Nom_Text.setText("");
        }
        catch (SQLException sqlExcept)
        {
            System.out.println("Erreur creation utilisateur : " + sqlExcept.getMessage());
            OperationResult_label.setText("Erreur création Utilisateur");
        }
    }
    
    private static void initTable(){
        try{
            stmt = conn.createStatement();
            
            String query = "CREATE TABLE Users( "
            + "Id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
            + "Nom VARCHAR(100) NOT NULL, "
            + "Prenom VARCHAR(100) NOT NULL, "
            + "CONSTRAINT primary_key PRIMARY KEY (Id))";
      
            stmt.execute(query);
            System.out.println("Table Users created");
        }
        catch(SQLException except){
            // Code erreur 30000 -> Table deja existente
            if(except.getErrorCode() != 30000){
                System.out.println("Erreur creation table : " + except.getMessage());
                OperationResult_label.setText("Erreur création table");
            }
        }
    }
    
    private static void createConnection()
    {
        try
        {
            try {
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");// or may be it is "org.apache.derby.jdbc.EmbeddedDriver"? Not sure. Check the correct name and put it here.
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
            }
            conn = DriverManager.getConnection(dbURL, "Admin_", "1234"); 
            System.out.println("Connexion BDD : OK");
        }
        catch (SQLException except)
        {
            String errMsg = except.getMessage();
            System.out.println(errMsg);
            OperationResult_label.setText("Erreur connexion base de donné");
        }
    }
    
    private static void shutdown()
    {
        try
        {
            if (stmt != null)
                stmt.close();
            
            if (conn != null)
            {
                DriverManager.getConnection(dbURL + ";shutdown=true");
                conn.close();
            }           
        }
        catch (SQLException sqlExcept)
        {
            System.out.println("Erreur ShutDown fonction : " + sqlExcept.getMessage());
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Enregistrer_Btn;
    private static javax.swing.JTextField Nom_Text;
    private static javax.swing.JLabel OperationResult_label;
    private static javax.swing.JTextField Prenom_Text;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
