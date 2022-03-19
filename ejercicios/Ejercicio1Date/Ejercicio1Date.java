package ejercicios.Ejercicio1Date;

import java.util.Scanner;

public class Ejercicio1Date {
    
    private static int data;

    public void Ejercicio1Date() {
        data = 0;
    }

    public int getDia() {
        int dia = (data << 16) >>> 27;
        return dia;
    }

    public int getMes() {
        int mes = (data << 12) >>> 28;
        return mes;
    }

    public int getAnio() {
        int anio = (data >>> 20);
        return anio;
    }

    //año      //mes //dia //vacio
//000000000000 1111  11111 00000000000 

    public static void setDia(int dia) { //deja solo los bits del dia
        if (dia > 0 && dia <= 31) {
            int mask = 63488 | (1 << 31); //00000000000000001111100000000000
            data = (data & mask) | (dia << 11);
            System.out.println("Data: " + Long.toBinaryString(data) + "\nFecha: " + dia + "\n");
        } else {
            System.out.println("Dia no ingresado");
        }
    }

    public static void setMes(int mes) {
        if (mes > 0 && mes <= 15) {
            int mask = 983040 | (1 << 31); //00000000000011110000000000000000
            data = (data & mask) | (mes << 16);
            System.out.println("Data: " + Long.toBinaryString(data) + "\nMes: " + mes + "\n");
        } else {
            System.out.println("Mes no ingresado");
        }
    }

    public static void setAnio(int anio) {
        if (anio > 0 && anio <= 4096) {
            int mask = 1048575;
            data = (data & mask) | (anio << 20);
            System.out.println("Data: " + Long.toBinaryString(data) + "\nAnio " + anio + "\n");
        } else {
            System.out.println("Año no ingresado");
        }
    }

    public String toString() {
        if (getMes()<10) {
            return getDia() + "/0" + getMes() + "/" + getAnio();
        } else {
            return getDia() + "/" + getMes() + "/" + getAnio();
        }
    }
}
