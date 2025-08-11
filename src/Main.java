import com.bys.gestor.GestorProducto;
import com.bys.gui.VentanaPrincipal;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        GestorProducto gestorProducto = new GestorProducto();
        SwingUtilities.invokeLater(() -> new VentanaPrincipal(gestorProducto).setVisible(true));
    }
}
