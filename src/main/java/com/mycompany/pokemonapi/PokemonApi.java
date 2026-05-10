/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pokemonapi;

/**
 *
 * @author isabe
 */
import controlador.ControladorPokemon;
import vista.VistaPokemon;

public class PokemonApi {

    public static void main(String[] args) {

        VistaPokemon vista =
                new VistaPokemon();

        ControladorPokemon controlador =
                new ControladorPokemon(vista);

        vista.setVisible(true);
    }
}
