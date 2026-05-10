/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

/**
 *
 * @author isabe
 */
import  modelo.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import static one.xingyi.core.http.JavaHttpClient.httpClient;
import org.json.JSONObject;

public class ServicioApi {
    private static final  HttpClient httpclient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
    
    private static final String API_URL = "https://pokeapi.co/api/v2/pokemon/";
    
    public Criatura getPost(String nombre) throws IOException, InterruptedException{
    HttpRequest request = HttpRequest.newBuilder()
                          .GET()
                          .uri(URI.create(API_URL +nombre.toLowerCase()))
                          .header("Accept","Application/json")
                          .build();
    
    HttpResponse <String> response = httpClient.send(request,HttpResponse.BodyHandlers.ofString());
   
    if(response.statusCode()!=200){
        System.out.println("error : "+response.statusCode());
    }
    
    String jsonString = response.body();
    
    JSONObject jsonObject = new JSONObject(jsonString);
    
    Criatura criatura = new Criatura (jsonObject);
    
    return criatura;
    }
}
