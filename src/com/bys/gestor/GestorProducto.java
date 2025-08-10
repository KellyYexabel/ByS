package com.bys.gestor;

import com.bys.model.Producto;

import java.util.ArrayList;
import java.util.List;

public class GestorProducto {
    private List<Producto> productos = new ArrayList<>();
    private int siguienteId = 1;

    public GestorProducto() {
        // Inicializar con 10 productos
        agregarProducto("Paracetamol", "Analgésico", 5.50, "Medicamento");
        agregarProducto("Ibuprofeno", "Antiinflamatorio", 8.00, "Medicamento");
        agregarProducto("Omeprazol", "Protector gástrico", 12.00, "Medicamento");
        agregarProducto("Amoxicilina", "Antibiótico", 15.00, "Medicamento");
        agregarProducto("Vitamina C", "Suplemento", 3.50, "Vitaminas");
        agregarProducto("Jarabe para la tos", "Alivio de tos", 6.00, "Medicamento");
        agregarProducto("Alcohol en gel", "Desinfectante", 2.50, "Higiene");
        agregarProducto("Termómetro", "Medición de temperatura", 25.00, "Instrumento");
        agregarProducto("Mascarilla", "Protección", 1.00, "Higiene");
        agregarProducto("Guantes", "Protección", 0.50, "Higiene");
    }

    public List<Producto> listarProductos() {
        return productos;
    }

   /* public Producto buscarProductoPorId(int id) {
        return productos.stream()
                .filter(producto -> producto.getId() == id)
                .findFirst()
                .orElse(null);
    }*/

    public Producto buscarProductoPorId(int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null; // Retorna null si no se encuentra el producto
    }

    public void agregarProducto(String nombre, String descripcion, double precio, String categoria) {
        Producto nuevoProducto = new Producto(siguienteId++, nombre, descripcion, precio, categoria);
        productos.add(nuevoProducto);
    }
}