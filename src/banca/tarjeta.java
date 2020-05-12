/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banca;

import java.time.LocalDate;

/**
 *
 * @author Usuario
 */
public class tarjeta extends Cliente{
    private double limiteCajero;
    private double limiteInternet;

    public tarjeta(double limiteCajero, double limiteInternet, String nombre, String apellidos, String direccion, String nif, int telefono, int edad, double saldo, double limite, int cuenta, LocalDate fechaApertura) {
        super(nombre, apellidos, direccion, nif, telefono, edad, saldo, limite, cuenta, fechaApertura);
        this.limiteCajero = limiteCajero;
        this.limiteInternet = limiteInternet;
    }

    
 
    public double getLimiteCajero() {
        return limiteCajero;
    }
    public void setLimiteCajero(double limiteCajero) {
        this.limiteCajero = limiteCajero;
    }
    public double getLimiteInternet() {
        return limiteInternet;
    }
    public void setLimiteInternet(double limiteInternet) {
        this.limiteInternet = limiteInternet;
    }
    public boolean retirarDinero(double dinero){
        if( saldo>=dinero && dinero<=limiteCajero){
        saldo=saldo-dinero;
        System.out.println("Se ha realizado con éxito");
        return true; 
        }else{
            System.out.println("El dinero es superior al límite o al que hay en la cuenta");
            return false;
        }
    }
    public boolean pagoInternet(double dinero){
        if( saldo>=dinero && dinero<=limiteInternet){
        saldo=saldo-dinero;
        System.out.println("Se ha realizado con éxito");
        return true;
        }else{
            System.out.println("El dinero es superior al límite o al que hay en la cuenta");
            return false;
        }
    }
}
