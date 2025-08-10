package com.bys.gui;

import com.bys.gestor.GestorProducto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VentanaAgregarProducto extends JFrame {
    private GestorProducto gestorProducto;
    private VentanaPrincipal ventanaPrincipal;

    public VentanaAgregarProducto(VentanaPrincipal ventanaPrincipal, GestorProducto gestorProducto) {
        this.ventanaPrincipal = ventanaPrincipal;
        this.gestorProducto = gestorProducto;

        setTitle("Agregar Producto");
        setSize(300, 400);
        setLayout(new GridLayout(6, 2));

        JLabel nombreLabel = new JLabel("Nombre:");
        JTextField nombreField = new JTextField();

        JLabel descripcionLabel = new JLabel("Descripción:");
        JTextField descripcionField = new JTextField();

        JLabel precioLabel = new JLabel("Precio:");
        JTextField precioField = new JTextField();

        JLabel categoriaLabel = new JLabel("Categoría:");
        String[] categorias = {"Higiene", "Medicamentos", "Vitaminas y Suplementos"};
        JComboBox<String> categoriaComboBox = new JComboBox<>(categorias);

        JButton agregarButton = new JButton("Agregar");
        agregarButton.addActionListener((ActionEvent e) -> {
            try {
                String nombre = nombreField.getText();
                String descripcion = descripcionField.getText();
                double precio = Double.parseDouble(precioField.getText());
                String categoria = (String) categoriaComboBox.getSelectedItem();

                gestorProducto.agregarProducto(nombre, descripcion, precio, categoria);
                JOptionPane.showMessageDialog(this, "Producto agregado exitosamente.");
                ventanaPrincipal.actualizarTabla(); // Refrescar la tabla
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        add(nombreLabel);
        add(nombreField);
        add(descripcionLabel);
        add(descripcionField);
        add(precioLabel);
        add(precioField);
        add(categoriaLabel);
        add(categoriaComboBox);
        add(new JLabel());
        add(agregarButton);
    }
}