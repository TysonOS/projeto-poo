package aplicacao;

/**
 * @author tysonos
 */
import com.formdev.flatlaf.*;
import dao.DAOFactory;
import dao.AssuntoDAO;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.swing.JLabel;
import modelo.Assunto;

public class telaPrincipal extends javax.swing.JFrame {
    AssuntoDAO assuntoDAO = DAOFactory.criarAssuntoDAO();
    Properties userProps = new Properties();
    // Verificar se o sistema não mudou a extensão do arquivo de configuração
    InputStream defaultPropsFile = telaPrincipal.class.getResourceAsStream("/recursos/defaultConfigs.properties");
    String mainPath;
    public telaPrincipal() {
        initComponents();
        try {
            mainPath = new File(telaPrincipal.class.getProtectionDomain()
                    .getCodeSource().getLocation().toURI()).getParent();
            File userPropsFile = new File(mainPath  +"/userConfigs.properties");
            if (userPropsFile.exists()) {
                userProps.load(new FileReader(userPropsFile));
            } else {
                userProps.load(defaultPropsFile);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        carregarTema();
        carregarAssuntos();
        
    }

    public void carregarAssuntos() {
        for (Assunto assunto : assuntoDAO.listar()) {
            addAssunto(assunto);
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

        mainJPanel = new javax.swing.JPanel();
        mainTabbedPanel = new javax.swing.JTabbedPane();
        dashboardPanel = new javax.swing.JPanel();
        toggleTema = new javax.swing.JToggleButton();
        btnNovoAssunto = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("StudyTracker");
        setSize(new java.awt.Dimension(600, 350));
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        mainJPanel.setPreferredSize(new java.awt.Dimension(600, 350));

        mainTabbedPanel.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        mainTabbedPanel.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                mainTabbedPanelComponentRemoved(evt);
            }
        });
        mainTabbedPanel.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                mainTabbedPanelStateChanged(evt);
            }
        });
        mainTabbedPanel.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                mainTabbedPanelVetoableChange(evt);
            }
        });

        javax.swing.GroupLayout dashboardPanelLayout = new javax.swing.GroupLayout(dashboardPanel);
        dashboardPanel.setLayout(dashboardPanelLayout);
        dashboardPanelLayout.setHorizontalGroup(
            dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 533, Short.MAX_VALUE)
        );
        dashboardPanelLayout.setVerticalGroup(
            dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );

        mainTabbedPanel.addTab("Dashboard", null, dashboardPanel, this.getTitle());

        toggleTema.setToolTipText("Alternar tema");
        toggleTema.setPreferredSize(new java.awt.Dimension(32, 32));
        toggleTema.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                toggleTemaMouseClicked(evt);
            }
        });
        toggleTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleTemaActionPerformed(evt);
            }
        });

        btnNovoAssunto.setText("Novo Assunto");
        btnNovoAssunto.setPreferredSize(new java.awt.Dimension(125, 32));
        btnNovoAssunto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNovoAssuntoMouseClicked(evt);
            }
        });
        btnNovoAssunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoAssuntoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainJPanelLayout = new javax.swing.GroupLayout(mainJPanel);
        mainJPanel.setLayout(mainJPanelLayout);
        mainJPanelLayout.setHorizontalGroup(
            mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainJPanelLayout.createSequentialGroup()
                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainJPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(mainTabbedPanel))
                    .addGroup(mainJPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(toggleTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNovoAssunto, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)))
                .addGap(6, 6, 6))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2)
                .addContainerGap())
        );
        mainJPanelLayout.setVerticalGroup(
            mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainTabbedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnNovoAssunto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toggleTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus

    }//GEN-LAST:event_formWindowGainedFocus

    private void btnNovoAssuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoAssuntoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNovoAssuntoActionPerformed

    private void btnNovoAssuntoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNovoAssuntoMouseClicked
        new EditorAssunto(this, true, null).setVisible(true);
    }//GEN-LAST:event_btnNovoAssuntoMouseClicked

    private void toggleTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleTemaActionPerformed

    }//GEN-LAST:event_toggleTemaActionPerformed

    private void toggleTemaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toggleTemaMouseClicked
        if (userProps.getProperty("tema").equals("claro")) {
            userProps.replace("tema", "escuro");
        } else {
            userProps.replace("tema", "claro");
        }
        mudarTema();
        salvarTema();
    }//GEN-LAST:event_toggleTemaMouseClicked

    private void mainTabbedPanelStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_mainTabbedPanelStateChanged
        // TODO add your handling code here:
       
    }//GEN-LAST:event_mainTabbedPanelStateChanged

    private void mainTabbedPanelVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_mainTabbedPanelVetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_mainTabbedPanelVetoableChange

    private void mainTabbedPanelComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_mainTabbedPanelComponentRemoved
        // TODO add your handling code here:]
        System.out.println("Removido COmp: "+ mainTabbedPanel.getTabCount());  
    }//GEN-LAST:event_mainTabbedPanelComponentRemoved

    /**
     * @param args the command line arguments
     */
    public static void addAssunto(Assunto assunto) {
        int larguraTab = 216;
        PainelAssuntoGenerico novoPainelAssunto = new PainelAssuntoGenerico(assunto);
        JLabel titulo = new JLabel(assunto.getTitulo());
        titulo.setPreferredSize(new Dimension(larguraTab, titulo.getFont().getSize()));
        mainTabbedPanel.addTab(assunto.getTitulo(), novoPainelAssunto);
        if (mainTabbedPanel.getTabCount() > 1) {
            mainTabbedPanel.setTabComponentAt((mainTabbedPanel.getTabCount() - 1), titulo);
            mainTabbedPanel.setToolTipTextAt(mainTabbedPanel.getTabCount() - 1, assunto.getTitulo());
        }
    }

    public static void removeAssunto(Component assuntoPanel) {
        mainTabbedPanel.remove(assuntoPanel);
    }

    public static void updateAssunto(Assunto assunto) {
        JLabel titulo = JLabel.class.cast(mainTabbedPanel.getTabComponentAt(mainTabbedPanel.getSelectedIndex()));
        titulo.setText(assunto.getTitulo());
        mainTabbedPanel.setTabComponentAt(mainTabbedPanel.getSelectedIndex(), titulo);
        mainTabbedPanel.setToolTipTextAt(mainTabbedPanel.getSelectedIndex(), assunto.getTitulo());
    }

    public void salvarTema() {
        try {
            File configFile = new File(mainPath);
            configFile.mkdir();
            if (configFile.exists()) {
                FileWriter configWriter = new FileWriter(configFile + "/userConfigs.properties");
                //FileWriter configWriter = new FileWriter(configFile);
                userProps.store(configWriter, null);
                configWriter.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void carregarTema() {
        try {
            String tema = userProps.getProperty("tema", "escuro");
            switch (tema) {
                case "claro":
                    mudarTema();
                    break;
                case "escuro":
                    mudarTema();
                    break;
                default:
                    throw new AssertionError();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mudarTema() {
        if ((userProps.getProperty("tema", "escuro").equals("escuro"))) {
            toggleTema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/icones/sun.png")));
            FlatDarkLaf.setup();
            FlatDarkLaf.updateUI();
            userProps.replace("tema", "escuro");
        } else {
            toggleTema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/icones/moon.png")));
            FlatLightLaf.setup();
            FlatLightLaf.updateUI();
            userProps.replace("tema", "claro");
        }
    }

    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaPrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNovoAssunto;
    private javax.swing.JPanel dashboardPanel;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel mainJPanel;
    private static javax.swing.JTabbedPane mainTabbedPanel;
    private javax.swing.JToggleButton toggleTema;
    // End of variables declaration//GEN-END:variables
}
