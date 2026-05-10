/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author isabe
 */
import modelo.Criatura;
import servicio.ServicioApi;
import vista.VistaPokemon;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class ControladorPokemon {

    private VistaPokemon vista;
    private ServicioApi api;

    public ControladorPokemon(VistaPokemon vista) {
        this.vista = vista;
        this.api = new ServicioApi();
        iniciarEventos();
    }

    public void iniciarEventos() {
        vista.getBtnBuscar().addActionListener(e -> {
            String nombre = vista.getTxtPokemon().getText().trim();
            try {
                Criatura pokemon
                        = api.getPokemon(nombre);
                vista.getLblNombre().setText(pokemon.getNombre());
                vista.getLblPeso().setText(String.valueOf(pokemon.getPeso()));
                vista.getLblAltura().setText(String.valueOf(pokemon.getAltura()));
                vista.getLblOrden().setText(String.valueOf(pokemon.getOrden()));
                vista.getTxtHabilidades().setText(pokemon.getPoderes());

                ImageIcon icono = new ImageIcon(new URL(pokemon.getImagen()));
                Image img = icono.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);

                vista.getLblImagen().setIcon(new ImageIcon(img));
                vista.getLblEstado()
                        .setText("Pokemon encontrado");
            } catch (Exception ex) {
                vista.getLblEstado()
                        .setText("Pokemon no encontrado");
            }
        });
    }
}
