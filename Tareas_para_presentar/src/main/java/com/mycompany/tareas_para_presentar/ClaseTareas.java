
package com.mycompany.tareas_para_presentar;
import java.util.Scanner;

public class ClaseTareas {
 ////////////////////////////////////////////////////////// OBJETOS //////////////////////////////////////////////////////////////////////////////   
    
   Scanner entrada = new Scanner (System.in);
   
   PrintErrores verificador = new PrintErrores ();
    
    
    
    
/////////////////////////////////////////////////////////// VARIABLES //////////////////////////////////////////////////////////////////////////////////////////////
    int opciones;
    
////////////////////////////////////////////////// ATRIBUTOS ///////////////////////////////////////////////////////////////////////////////////////////////////////    
    private int id = 0; 
    private String nombre = "";
    private String descripcion = "";
    private int estado = 0 ;// 0 no ha sido rellenda o ha sido eliminada || 1 la tarea esta en curso || 2 esta pendiente || 3 esta terminada || 4 esta cancelada || 
    
 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
    
    public void ClaseTarea(){
    }

    
    public void rellenoDeDatos(int id , String nombre , String descripcion, int estado ){ // Constructor
        
        this.id=id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public int getEstado(){
     return this.estado;   
    }
    
     public int getId(){
     return this.id;   
    }
     
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public void mostrarTareas(){
        
        if(estado!=0){
            
            System.out.println("ID: " + this.id);
            System.out.println("Nombre: " + this.nombre);
            System.out.println("Descripcion: " + this.descripcion);
            switch(estado){
            
                case 1:
                System.out.println("Tarea en curso ");
                break;
                case 2:
                System.out.println("Tarea pendiente ");
                break;
                case 3:
                System.out.println("Tarea terminada ");
                break;
                case 4: 
                System.out.println("Tarea Cancelada");
            }
        }
    }
    
    public void cambioDeEstado(){
        switch(this.estado){
            case 1 :
                System.out.println("El estado de la tarea " +this.id+ " es EN CURSO");
                System.out.println("Puede pasarla a");
                System.out.println("1. Terminada");
                System.out.println("2. Cancelada");
                
                opciones = entrada.nextInt();
                
                opciones = verificador.errorConCondicion(opciones, 2);
                
                if(opciones == 1){
                    opciones = 3;
                }
                else{
                    opciones = 4;
                }
                
                this.estado=opciones;
                break;
                
            case 2 :
                System.out.println("El estado de la tarea " +this.id+ " es PENDIENTE");
                System.out.println("Puede pasarla a");
                System.out.println("1. En curso");
                System.out.println("2. Cancelada");
                
                opciones = entrada.nextInt();  
                opciones = verificador.errorConCondicion(opciones, 2);
                if(opciones == 2){
                    opciones = 4;
                }
                this.estado=opciones;
                
                break;
            
            case 3 :
                System.out.println("El estado de la tarea " +this.id+ " es TERMINADA");
                System.out.println("Puede pasarla a");
                System.out.println("1. pendiente");
                
                
                opciones = entrada.nextInt();  
                opciones = verificador.errorConCondicion(opciones, 1);
                if(opciones == 1){
                    opciones = 2;
                }
                this.estado=opciones;
                break;
            
            case 4:
                
                System.out.println("El estado de la tarea " +this.id+ " es CANCELADA");
                System.out.println("Puede pasarla a");
                System.out.println("1. pendiente");
                
                opciones = entrada.nextInt();  
                opciones = verificador.errorConCondicion(opciones, 1);
                if(opciones == 1){
                    opciones = 2;
                }
                this.estado=opciones;
                break;
                
        }
    }
}
