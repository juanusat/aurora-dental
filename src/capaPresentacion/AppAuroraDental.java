/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package capaPresentacion;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Dimension;
import javax.swing.UIManager;

/**
 *
 * @author Antonio
 */
public class AppAuroraDental {

    /**
     * @param args the command line arguments
     */
    public AppAuroraDental() {
    }

    public static void main(String[] args) {
        if (1 == 1) {
            try {
                UIManager.setLookAndFeel(new FlatLightLaf());
            } catch (Exception ex) {
                System.err.println("Failed to initialize LaF");
            }

        }
        Frm_Principal objPRc = new Frm_Principal();
        objPRc.setSize(772, 436);
        objPRc.setMinimumSize(new Dimension(500, 300));
        if (1 == 1) {
            objPRc.setLocationRelativeTo(null);
        }
        objPRc.setVisible(true);
    }
    
}
