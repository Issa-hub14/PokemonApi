/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pokemonapi;

/**
 *
 * @author isabe
 */
import modelo.Criatura;
import servicio.ServicioApi;

import java.io.IOException;

public class PokemonApi {

    public static void main(String[] args) {

        System.out.println("Consumiendo API Pokémon");

        ServicioApi ServicioApi =
                new ServicioApi();

        try {

            Criatura pokemon =
                    ServicioApi.getPokemon("pikachu");

            if (pokemon != null) {

                System.out.println("Pokemon recibido");

                System.out.println("Nombre: "
                        + pokemon.getNombre());

                System.out.println("Peso: "
                        + pokemon.getPeso());

                System.out.println("Orden: "
                        + pokemon.getOrden());

                System.out.println("Habilidad: "
                        + pokemon.getPoderes());

                System.out.println("Imagen: "
                        + pokemon.getImagen());
            }

        } catch (IOException | InterruptedException e) {

            e.printStackTrace();
        }
    }
}
