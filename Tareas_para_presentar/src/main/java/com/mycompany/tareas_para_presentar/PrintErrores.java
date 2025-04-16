
package com.mycompany.tareas_para_presentar;
import java.util.Scanner;



public class PrintErrores {

    private int lugar =0; // retorna el lugar del arreglo que exite 
    private boolean aprobado = false; 
    
    Scanner entrada = new Scanner(System.in);
    
    public int errorConCondicion(int datoOpcion , int datoCondicion){ //cuando tiene la condicion de que el dato sea mayor a 0 y menor que algo 
        while(datoOpcion>datoCondicion || datoOpcion<0){
            System.out.println("----------  Las opcion ingresada no existe ----------");
            System.out.println("----------       Vuelva a intentarlo       ----------");
            datoOpcion  = entrada.nextInt(); 
        }
    return datoOpcion;}
    
    public int errorSinCondicion(int datoOpcion){ //cuando el dato tiene la condicion de que tiene que ser mayor a 0 
        
     while(datoOpcion<=0){
            System.out.println("----------  Las opcion ingresada no existe ----------");
            System.out.println("----------       Vuelva a intentarlo       ----------");
            datoOpcion  = entrada.nextInt(); 
        }
    return datoOpcion;}
    
 
    public int verificadorDeId(ClaseTareas t[] , int id ){
        while(aprobado != true){
            for( ClaseTareas tareas : t){
                if(id == tareas.getId()){
                aprobado = true;
                break;
                } 
                lugar++;
            }
            if(aprobado != true){
                System.out.printf("El id ingresado es incorrecto, porfavor ingrese uno que exista: ");
                id  = entrada.nextInt();
                lugar=0;
            }
        }     
    return lugar ;}
    
    
    
    
}
