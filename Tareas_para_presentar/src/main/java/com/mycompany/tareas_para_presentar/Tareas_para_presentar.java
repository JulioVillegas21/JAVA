package com.mycompany.tareas_para_presentar;
import java.util.Scanner;
public class Tareas_para_presentar {
    public static void main(String[] args) {
        
        ////////////////////////////////////// Lista de variables //////////////////////////////////////
        
        int cantDeTareas; // Variable que utilizo para crear el arreglo
        int cant = 0; // variable que se utiliza en la seleccion de cantidad de tareas a rellenar 
        int op = 0;
        int contadorDeTareas = 0; // contador para poder tener un registro en de cuantas tareas se han rellenado
        int opSwitch; // variable que utilizare para opciones que esten dentro del switch
        int b = 0; // variables aux case 1 , 2 , 3 y 4 
        int c = 0; // variables aux case 1 , 2 y 3 
        
        // variables para rellenar en cada tarea 
        int rellenoId;
        String rellenoNombre;
        String rellenoDescripcion;
        int rellenoEstado;
        
        
        ///////////////////////////////////// Lista de objetos //////////////////////////////////////////  
        
        Scanner entrada = new Scanner(System.in); // Creo el scanner 
        
        PrintErrores verificador = new PrintErrores(); // Whiles para no generar miles de lineas 
        
        //////////////////////////////////////////////////////////////////////////////////////////////
        
        System.out.println("\n-------------------------------------------");
        System.out.println("-----------  Lista de tareas  -------------");
        System.out.println("-------------------------------------------\n");
        
        System.out.print("Cuantas tareas desea agendar?: ");
        cantDeTareas = entrada.nextInt();
        // No es necesario limpiador de buffer acá ya que no leemos nextLine() inmediatamente
        
        cantDeTareas = verificador.errorSinCondicion(cantDeTareas);
        
        ClaseTareas[] conjDeTareas = new ClaseTareas[cantDeTareas]; // Creo los arreglos que puede contener la clase "ClaseTareas"
        
        for (int i = 0; i < cantDeTareas; i++) {
            conjDeTareas[i] = new ClaseTareas(); // Instancio cada posición del arreglo
        }
        
        do {
            System.out.println("\n\n");// Espaciadores para separar texto
            System.out.println("\n-------------------------------------------");
            System.out.println("-----------  Lista de tareas  -------------");
            System.out.println("-------------------------------------------\n");
            System.out.println("1. Agregar tareas al sistema (Disponibles " + (cantDeTareas - contadorDeTareas) + ")");
            System.out.println("2. Modificar datos de las tareas");
            System.out.println("3. Modificar el estado de las tareas");
            System.out.println("4. Mostrar tareas");
            System.out.println("5. Cerrar el programa");
            System.out.println("-------------------------------------------\n\n");
            System.out.print("Porfavor determine su opcion:");
            
            op = entrada.nextInt(); // lectura de la opción 
            // No se limpia buffer acá porque luego no se utiliza nextLine() inmediatamente
            
            op = verificador.errorConCondicion(op, 5); // (Opcion a elegir, limite de las opciones)
            
            System.out.println("\n\n");// Espaciadores para separar texto
            
            switch (op) {
                case 1:
                    if ((cantDeTareas - contadorDeTareas) == 0) {
                        System.out.println("\n\n");// Espaciadores para separar texto
                        System.out.println("No hay tareas disponibles para ingresar, Porfavor elimine una para poder ingresar nuevas ");
                        break;
                    }
                    System.out.println("\n\n");// Espaciadores para separar texto 
                    
                    System.out.println("Porfavor indique la cantidad de tareas que desea rellenar ( disponibles: " + (cantDeTareas - contadorDeTareas) + ")");
                    
                    opSwitch = entrada.nextInt();
                    // No se limpia buffer acá porque luego no se invoca inmediatamente un nextLine()
                    
                    opSwitch = verificador.errorConCondicion(opSwitch, (cantDeTareas - contadorDeTareas)); // Verifica si hay tareas disponibles 
                    
                    b = 0;
                    while (b != opSwitch) { 
                      /*el buscador, busca una tarea que no este rellenada o no exista para poder ingresar datos, el while se repite hasta que la cantidad de tareas rellenadas
                        sea la adecuada, por otro lado, el for busca la tarea que esta libre, si la encuentra almacena el indice en c y c lo que hace es que le da el lugar del arreglo
                        el cual está disponible para cargar la tarea
                        */
                      
                        c = 0;
                        for (int i = 0; i < cantDeTareas; i++) {
                            if (conjDeTareas[i].getEstado() == 0) {
                                c = i;
                                break; // Salgo al encontrar la primera libre
                            }
                        }
                        
                        System.out.println("Porfavor ingrese el id de la tarea (" + (b + 1) + "/" + opSwitch + ")");
                        rellenoId = entrada.nextInt();
                        entrada.nextLine(); // limpiador de buffer
                        
                        rellenoId = verificador.errorSinCondicion(rellenoId); // verifica que la id no sea igual o menor a 0 
                        
                        System.out.println("\n\n");// Espaciadores para separar texto
                        
                        System.out.println("Porfavor ingrese el nombre de la tarea ( 1/" + opSwitch + ")");
                        rellenoNombre = entrada.nextLine();
                        
                        System.out.println("\n\n");// Espaciadores para separar texto
                        
                        System.out.println("Porfavor ingrese descripcion de la tarea ( 1/" + opSwitch + ")");
                        rellenoDescripcion = entrada.nextLine();
                        
                        System.out.println("\n\n");// Espaciadores para separar texto
                        conjDeTareas[c].rellenoDeDatos(rellenoId, rellenoNombre, rellenoDescripcion, 2);
                        
                        b++;
                        contadorDeTareas++;
                    }
                    
                    break;
                    
                case 2:
                    
                    if (contadorDeTareas == 0) { // condición para que no ingresar al caso si no hay tareas
                        System.out.println("\n\n");// Espaciadores para separar texto
                        break;
                    }
                    
                    b = 1;
                    for (ClaseTareas t : conjDeTareas) { // recorre todas los arreglos
                        if (t.getEstado() == 0) { 
                            // no se imprime el cuadro de tareas 
                        } else {
                            System.out.println("--------- TAREA N " + (b) + "--------"); 
                            t.mostrarTareas(); // método que imprime los datos 
                            System.out.println("--------------------------------");
                            
                            b++;
                        }
                    }
                    
                    System.out.println("\n\n");// Espaciadores para separar texto
                    
                    System.out.println("Porfavor ingrese el id de la tarea que desea modificar");
                    
                    rellenoId = entrada.nextInt(); // lector de id para modificar la tarea con esa id
                    
                    c = verificador.verificadorDeId(conjDeTareas, rellenoId); // me da el índice del arreglo de donde está la tarea 
              
                    System.out.println("\n\n");// Espaciadores para separar texto 
                    
                    System.out.println("Cual dato desea modificar?");
                    System.out.println("1. ID");
                    System.out.println("2. Nombre");
                    System.out.println("3. Descripcion");
                    
                    System.out.println("\n\n");// Espaciadores para separar texto 
                    
                    b = entrada.nextInt(); // datos que se quiere modificar
      
                    b = verificador.errorConCondicion(b, 3);
                    
                    System.out.println("\n\n");// Espaciadores para separar texto
                    
                    
                    switch (b) { // cosa escogida 
                        case 1:
                            
                            System.out.println("Porfavor introdzca la nueva id de la tarea con id " + conjDeTareas[c].getId());// Espaciadores para separar texto
                            rellenoId = entrada.nextInt();
                            entrada.nextLine(); // limpiador de buffer
                            
                            rellenoId = verificador.errorSinCondicion(rellenoId);
                            
                            conjDeTareas[c].setId(rellenoId);
                            
                            System.out.println("\n\n");// Espaciadores para separar texto 
                            
                            System.out.println("Id cambiado Correctamente");
                            
                            break;
                        case 2:
                            System.out.println("Porfavor introdzca el nuevo nombre de la tarea con id " + conjDeTareas[c].getId());
                            entrada.nextLine(); // limpiador de buffer
                            rellenoNombre = entrada.nextLine();
                            
                            conjDeTareas[c].setNombre(rellenoNombre);
                            
                            System.out.println("\n\n");// Espaciadores para separar texto 
                            
                            System.out.println("Nombre cambiado Correctamente");
                            
                            break;
                        case 3:
                            entrada.nextLine(); // limpiador de buffer
                            System.out.println("Porfavor introdzca el nuevo nombre de la tarea con id " + conjDeTareas[c].getId());
                            
                            rellenoDescripcion = entrada.nextLine();
                            
                            conjDeTareas[c].setDescripcion(rellenoDescripcion);
                            
                            System.out.println("\n\n");// Espaciadores para separar texto 
                            
                            System.out.println("Descripcion cambiada Correctamente");
                            break; 
                    } // fin del switch del caso 2
                    break;
                    
                case 3:
                    
                    if (contadorDeTareas == 0) { // condición para que no ingresar al caso si no hay tareas
                        System.out.println("\n\n");// Espaciadores para separar texto
                        break;
                    }
                    
                    b = 1;
                    for (ClaseTareas t : conjDeTareas) { // recorre todas los arreglos
                        if (t.getEstado() == 0) {
                            // no se imprime el cuadro de tareas 
                        } else {
                            System.out.println("--------- TAREA N " + (b) + "--------"); 
                            t.mostrarTareas();
                            System.out.println("--------------------------------");
                            
                            b++;
                        }
                    }
                    
                    System.out.println("\n\n");// Espaciadores para separar texto
                    
                    System.out.println("Porfavor ingrese el id de la tarea que desea modificar");
                    
                    rellenoId = entrada.nextInt();
                    
                    c = verificador.verificadorDeId(conjDeTareas, rellenoId);
                    
                    conjDeTareas[c].cambioDeEstado();
                    
                    break;
                    
                case 4:
                    if (contadorDeTareas == 0) {
                        System.out.println("\n\n");// Espaciadores para separar texto
                        break;
                    }
                    b = 1;
                    for (ClaseTareas t : conjDeTareas) {
                        if (t.getEstado() == 0) {
                            // no se imprime el cuadro de tareas 
                        } else {
                            System.out.println("--------- TAREA N " + (b) + "--------"); 
                            t.mostrarTareas();
                            System.out.println("--------------------------------");
                            
                            b++;
                        }
                    }
                    break;    
                    
            } // fin del switch
        } while (op != 5); // condición para cerrar el programa 
    }
}