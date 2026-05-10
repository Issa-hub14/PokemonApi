/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author isabe
 */
import org.json.JSONObject;

public class Criatura {

    private int orden;
    private int peso;
    private String nombre;
    private String poderes;
    private String imagen;

    public Criatura(JSONObject json) {
        this.peso = json.getInt("weight");
        this.orden = json.getInt("order");
        this.nombre = json.getString("name");

        this.poderes = json.getJSONArray("abilities")
                .getJSONObject(0)
                .getJSONObject("ability")
                .getString("name");
        this.imagen = json.getJSONObject("sprites")
                .getString("front_default");
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPoderes() {
        return poderes;
    }

    public void setPoderes(String poderes) {
        this.poderes = poderes;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {

        return "Pokemon{" + "Orden: " + orden + "," + "nombre: " + nombre + "," + "peso:" + peso + "," + " Habilidad:" + poderes + ", Imagen: " + imagen + "}";
    }

}
