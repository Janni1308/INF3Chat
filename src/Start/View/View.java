/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Start.View;

/**
 *
 * @author schel
 */
public class View extends javax.swing.JFrame
{

    /**
     * @return the taHistory
     */
    public javax.swing.JTextArea getTaHistory()
    {
        return taHistory;
    }

    /**
     * @return the tfInput
     */
    public javax.swing.JTextField getTfInput()
    {
        return tfInput;
    }

    /**
     * Creates new form View
     */
    public View()
    {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jToolBar1 = new javax.swing.JToolBar();
        btnClient = new javax.swing.JButton();
        btnServer = new javax.swing.JButton();
        lblState = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        grafikView = new Start.View.GrafikView();
        jPanel1 = new javax.swing.JPanel();
        tfInput = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        taHistory = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat with Drawings");

        jToolBar1.setRollover(true);

        btnClient.setText("Client");
        btnClient.setFocusable(false);
        btnClient.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnClient.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnClient);

        btnServer.setText("Server");
        btnServer.setFocusable(false);
        btnServer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnServer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnServer);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        lblState.setText("Select Client or Server to connect");
        getContentPane().add(lblState, java.awt.BorderLayout.PAGE_END);

        jPanel2.setLayout(new java.awt.BorderLayout());
        jPanel2.add(grafikView, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.BorderLayout());
        jPanel1.add(tfInput, java.awt.BorderLayout.PAGE_END);

        taHistory.setColumns(20);
        taHistory.setRows(5);
        jScrollPane1.setViewportView(taHistory);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.LINE_END);

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_END);

        setSize(new java.awt.Dimension(911, 483));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClient;
    private javax.swing.JButton btnServer;
    private Start.View.GrafikView grafikView;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblState;
    private javax.swing.JTextArea taHistory;
    private javax.swing.JTextField tfInput;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the btnClient
     */
    public javax.swing.JButton getBtnClient()
    {
        return btnClient;
    }

    /**
     * @return the btnServer
     */
    public javax.swing.JButton getBtnServer()
    {
        return btnServer;
    }

    /**
     * @return the grafikView
     */
    public Start.View.GrafikView getGrafikView()
    {
        return grafikView;
    }

    /**
     * @return the lblState
     */
    public javax.swing.JLabel getLblState()
    {
        return lblState;
    }


}
