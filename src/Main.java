import com.bys.gestor.GestorProducto;
import com.bys.gui.VentanaPrincipal;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        GestorProducto gestorProducto = new GestorProducto();
        SwingUtilities.invokeLater(() -> new VentanaPrincipal(gestorProducto).setVisible(true));
    }
}