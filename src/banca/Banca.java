/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Banca {
static Scanner sc= new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList();
        ArrayList<tarjeta> tar=new ArrayList();
        clientes.add(new Cliente("Rosa","Marcos", "Gran Via","45345658L",658753458,19,1000,100,34567,LocalDate.of(2018, 10, 9)));
        tar.add(new tarjeta(100,50,"Rosa","Marcos", "Gran Via","45345658L",658753458,19,1000,100,34567,LocalDate.of(2018, 10, 9)));
        ArrayList<Gestor> gestores= new ArrayList();
        gestores.add(new Gestor("Raul","clave"));
        int n=clientes.size();
        int opc;
        do{
            opc=mostrarMenu();
            switch(opc){
                case 1:
                    int u;
                    do{
                    u=menuUsu();
                    switch(u){
                        case 1:
                            System.out.println("Introduce su nombre de usuario: ");
                            String nombre=sc.next();
                            System.out.println("Introduce su dni: ");
                            String dni= sc.next();
                            System.out.println("Introduce su número de cuenta: ");
                            int cuenta=sc.nextInt();
                            for (int i = 0; i < clientes.size(); i++) {
                                if(clientes.get(i).getNombre().equals(nombre) && clientes.get(i).getNif().equals(dni) && clientes.get(i).getCuenta()==cuenta){
                                    System.out.println("Introduce la cantidad de dinero que desea ingresar: ");
                                    double dinero= sc.nextDouble();
                                    if(clientes.get(i).ingresar(dinero)){
                                        System.out.println("El dinero se ha ingresado con exito");
                                    }else{
                                        System.out.println("No se ha podido ingresar");
                                    
                                    } 
                                }
                            }
                            break;
                        case 2:
                            System.out.println("Introduce su nombre de usuario: ");
                            nombre=sc.next();
                            System.out.println("Introduce su dni: ");
                            dni= sc.next();
                            System.out.println("Introduce su número de cuenta: ");
                            cuenta=sc.nextInt();
                            for (int i = 0; i < clientes.size(); i++) {
                                if(clientes.get(i).getNombre().equals(nombre) && clientes.get(i).getNif().equals(dni) && clientes.get(i).getCuenta()==cuenta){
                                    System.out.println("Introduce la cantidad de dinero que desea retirar: ");
                                    double dinero= sc.nextDouble();
                                    if(clientes.get(i).retirar(dinero)){
                                        System.out.println("El dinero se ha retirado con exito");
                                    }else{
                                        System.out.println("No se ha podido retirar, porque no contiene ese dinero la cuenta");
                                    }
                                }
                            }
                            break;
                        case 3:
                            System.out.println("Introduce su nombre de usuario: ");
                            nombre=sc.next();
                            System.out.println("Introduce su dni: ");
                            dni= sc.next();
                            System.out.println("Introduce su número de cuenta: ");
                            cuenta=sc.nextInt();
                            for (int i = 0; i < clientes.size(); i++) {
                                if(clientes.get(i).getNombre().equals(nombre) && clientes.get(i).getNif().equals(dni) && clientes.get(i).getCuenta()==cuenta){
                                    System.out.println(clientes.get(i).toString());
                                }
                            }
                            break;
                        case 4:
                            System.out.println("Introduce su nombre de usuario: ");
                            nombre=sc.next();
                            System.out.println("Introduce su dni: ");
                            dni= sc.next();
                            System.out.println("Introduce su número de cuenta: ");
                            cuenta=sc.nextInt();
                            System.out.println("1. Pago internet");
                            System.out.println("2. Pago efectivo");
                            System.out.println("Introduce la opción: ");
                             n=sc.nextInt();
                            if(n==1){
                            for (int i = 0; i < clientes.size(); i++) {
                                if(tar.get(i).getNombre().equals(nombre) && tar.get(i).getNif().equals(dni) && tar.get(i).getCuenta()==cuenta){
                                    System.out.println("Introduce la cantidad del pago: ");
                                    double cant=sc.nextDouble();
                                    boolean t=tar.get(i).pagoInternet(i); 
                                }
                            }
                            }else if(n==2){
                               for (int i = 0; i < clientes.size(); i++) {
                                if(tar.get(i).getNombre().equals(nombre) && tar.get(i).getNif().equals(dni) && tar.get(i).getCuenta()==cuenta){
                                    System.out.println("Introduce la cantidad del pago: ");
                                    double cant=sc.nextDouble();
                                    tar.get(i).retirarDinero(i);
                                }
                            } 
                            }
                            break;
                        case 5:
                            System.out.println("Hasta la proxima.");
                            break;
                        default:
                            System.out.println("No ha elegido un número correcto");
                             break;   
                    }
                    }while(u!=5);
                    break;
                //Menu del gestor
                case 2:
                    int g;
                    do{
                    g=menuGes();
                    switch(g){
                        case 1:
                            System.out.println("Introduce el nombre de usuario: ");
                            String usuario=sc.next();
                            System.out.println("Introduce la clave: ");
                            String clave=sc.next();
                            for (int i = 0; i < gestores.size(); i++) {
                                if(gestores.get(i).getNombre().equals(usuario) && gestores.get(i).getClave().equals(clave)){
                                    clientes.add(gestores.get(i).crear());
                                    System.out.println("El cliente quiere tarjeta? [s,n]");
                                    String s= sc.next();
                                    if(s.equals(s)){
                                        tar.add(gestores.get(i).crearTarjeta());
                                    }
                                }
                            }
                            
                            break;
                        case 2:
                            int op=submenu();
                            System.out.println("Introduce el nombre de usuario: ");
                            usuario=sc.next();
                            System.out.println("Introduce la clave: ");
                            clave=sc.next();
                            for (int i = 0; i < gestores.size(); i++) {
                                if(gestores.get(i).getNombre().equals(usuario) && gestores.get(i).getClave().equals(clave)){
                                    switch(op){
                                        case 1:
                                            mostrar(clientes);
                                            System.out.println("Introduce el nombre del cliente que desea cambiar: ");
                                            String nombre= sc.next();
                                            System.out.println("Introduce el dni del cliente que desea cambiar: ");
                                            String dni= sc.next();
                                            for (int j = 0; j < clientes.size(); j++) {
                                                if(clientes.get(j).getNombre().equals(nombre) && clientes.get(j).getNif().equals(dni)){
                                                    clientes.get(j).setNombre(gestores.get(i).modificarS(op));
                                                }
                                            }
                                            break;
                                        case 2:
                                            mostrar(clientes);
                                            System.out.println("Introduce los apellidos del cliente que desea cambiar: ");
                                            String apellidos= sc.next();
                                            System.out.println("Introduce el dni del cliente que desea cambiar: ");
                                            dni= sc.next();
                                            for (int j = 0; j < clientes.size(); j++) {
                                                if(clientes.get(j).getApellidos().equals(apellidos)  && clientes.get(j).getNif().equals(dni)){
                                                    clientes.get(j).setApellidos(gestores.get(i).modificarS(op));
                                                }
                                            }
                                            break;
                                        case 3:
                                            mostrar(clientes);
                                            System.out.println("Introduce la dirección del cliente que desea cambiar: ");
                                            String direccion= sc.next();
                                            System.out.println("Introduce el dni del cliente que desea cambiar: ");
                                            dni= sc.next();
                                            for (int j = 0; j < clientes.size(); j++) {
                                                if(clientes.get(j).getDireccion().equals(direccion) && clientes.get(j).getNif().equals(dni)){
                                                    clientes.get(j).setDireccion(gestores.get(i).modificarS(op));
                                                }
                                            }
                                            break;
                                        case 4:
                                            mostrar(clientes);
                                            System.out.println("Introduce el dni del cliente que desea cambiar: ");
                                            dni= sc.next();
                                            for (int j = 0; j < clientes.size(); j++) {
                                                if(clientes.get(j).getNif().equals(dni)){
                                                    clientes.get(j).setNif(gestores.get(i).modificarS(op));
                                                }
                                            }
                                            break;
                                        case 5:
                                            mostrar(clientes);
                                            System.out.println("Introduce el telefono del cliente que desea cambiar: ");
                                            int telefono= sc.nextInt();
                                            System.out.println("Introduce el dni del cliente que desea cambiar: ");
                                            dni= sc.next();
                                            for (int j = 0; j < clientes.size(); j++) {
                                                if(clientes.get(j).getTelefono()==telefono && clientes.get(j).getNif().equals(dni)){
                                                    clientes.get(j).setTelefono(gestores.get(i).modificarT(op));
                                                }
                                            }
                                            break;
                                        case 6:
                                            mostrar(clientes);
                                            System.out.println("Introduce la edad del cliente que desea cambiar: ");
                                            int edad= sc.nextInt();
                                            System.out.println("Introduce el dni del cliente que desea cambiar: ");
                                            dni= sc.next();
                                            for (int j = 0; j < clientes.size(); j++) {
                                                if(clientes.get(j).getEdad()==edad  && clientes.get(j).getNif().equals(dni)){
                                                    clientes.get(j).setEdad(gestores.get(i).modificarT(op));
                                                }
                                            }
                                            break;
                                         case 7:
                                            mostrar(clientes);
                                            System.out.println("Introduce el saldo del cliente que desea cambiar: ");
                                            double saldo= sc.nextDouble();
                                            System.out.println("Introduce el dni del cliente que desea cambiar: ");
                                            dni= sc.next();
                                            for (int j = 0; j < clientes.size(); j++) {
                                                if(clientes.get(j).getSaldo()==saldo && clientes.get(j).getNif().equals(dni)){
                                                    clientes.get(j).setSaldo(gestores.get(i).modificarT(op));
                                                }
                                            }
                                            break;
                                        case 8:
                                            mostrar(clientes);
                                            System.out.println("Introduce el limite del cliente que desea cambiar: ");
                                            int limite= sc.nextInt();
                                            System.out.println("Introduce el dni del cliente que desea cambiar: ");
                                            dni= sc.next();
                                            for (int j = 0; j < clientes.size(); j++) {
                                                if(clientes.get(j).getLimite()==limite && clientes.get(j).getNif().equals(dni)){
                                                    clientes.get(j).setLimite(gestores.get(i).modificarT(op));
                                                }
                                            }
                                            break;
                                            
                                    }
                                }
                            }
                            break;
                        case 3:
                            System.out.println("Hasta la proxima");
                            break;
                        default:
                            System.out.println("Opción incorrecta");
                        break;
                    }
                    }while(g!=3);
                    break;
                case 3: 
                    System.out.println("Hasta la proxima");
                    break;
                default:
                    System.out.println("Opción incorrecta");
                    break;
            }
        }while(opc!=3);
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println(clientes.get(i).toString());
        }
        
        
    }
    public static int mostrarMenu(){
        System.out.println("BANCO CAÑAV");
        System.out.println("1. Usuario");
        System.out.println("2. Gestor");
        System.out.println("3. Salir");
        System.out.println("Introduce una opción");
        int o=sc.nextInt();
        return o;
    }
    public static int menuUsu(){
        System.out.println("Menu Usuario");
        System.out.println("1. Ingresar dinero");
        System.out.println("2. Retirar dinero");
        System.out.println("3. Ver información");
        System.out.println("4. Pagar con tarjeta");
        System.out.println("5. Salir");
        System.out.println("Introduce una opción: ");
        int o=sc.nextInt();
        return o;
    }
    public static int menuGes(){
        System.out.println("Menu Gestores");
        System.out.println("1. Crear nueva cuenta y usuario");
        System.out.println("2. Modificar cuenta");
        System.out.println("3. Salir");
        System.out.println("Introduce una opción: ");
        int o=sc.nextInt();
        return o;
    }
   public static int submenu(){
       System.out.println("Que desea modificar? ");
        System.out.println("1. Nombre");
        System.out.println("2. Apellidos");
        System.out.println("3. Dirección");
        System.out.println("4. Dni");
        System.out.println("5. Telefono");
        System.out.println("6. Edad");
        System.out.println("7. Cantidad");
        System.out.println("8. Limite");
        System.out.println("Introduce una opción: ");
        int opc= sc.nextInt();
        return opc;
   }
   public static void mostrar(ArrayList clientes){
       for (int i = 0; i < clientes.size(); i++) {
            System.out.println(clientes.get(i).toString());
        }
   }
}
