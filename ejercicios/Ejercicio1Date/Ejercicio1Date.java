package ejercicios.Ejercicio1Date;

import java.util.Scanner;

public class Ejercicio1Date {
    public static void main(String[] args) {
        //[0,11] 12 bits año
        //[12,15] 4 bits mes
        //[16,20] 5 bits dia
        Scanner tec = new Scanner(System.in);
        System.out.println("Ingrese dia: "); int dia = tec.nextInt();
        System.out.println("Ingrese mes: "); int mes = tec.nextInt();
        System.out.println("Ingrese año: "); int anio = tec.nextInt();
    }

    private int data;

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

    public void setDia(int dia) {
        if (dia > 0 && dia <= 31) {
            int mask = 
        }
    }

}
