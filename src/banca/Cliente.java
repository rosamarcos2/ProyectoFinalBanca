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
public class Cliente{
    private String nombre;
    private String apellidos;
    private String direccion;
    private String nif;
    private int telefono;
    private int edad;
    double saldo;
    double limite;
    LocalDate fechaApertura;
    int cuenta;

    public Cliente(String nombre, String apellidos, String direccion, String nif, int telefono, int edad, double saldo, double limite, int cuenta, LocalDate fechaApertura) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.nif = nif;
        this.telefono = telefono;
        this.edad = edad;
        this.saldo = saldo;
        this.limite = limite;
        this.cuenta= cuenta;
        this.fechaApertura = fechaApertura;
    }

    public int getCuenta() {
        return cuenta;
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getNif() {
        return nif;
    }
    public void setNif(String nif) {
        this.nif = nif;
    }
    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public boolean ingresar(double dinero){
        saldo=saldo+dinero;
        return true;
    }
    public boolean retirar(double dinero){
        if( saldo>=dinero){
        saldo=saldo-dinero;
        return true;
        }else{
            return false;
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    @Override
    public String toString() {
        return "El cliente de nombre " + nombre + ", apellidos " + apellidos + ", con direccion en " + direccion + ", su DNI" + nif + ", con telefono " + telefono + ", y de edad" + edad + ",\n"
                + "en su cuenta tiene de saldo " + saldo + "€ , con un limite de " + limite + ", y su fecha de apertura " + fechaApertura + '}';
    }
    
}
