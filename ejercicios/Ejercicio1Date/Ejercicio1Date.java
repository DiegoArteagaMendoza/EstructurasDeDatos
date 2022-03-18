package ejercicios.Ejercicio1Date;

import java.util.Scanner;

public class Ejercicio1Date {
    public static void main(String[] args) {
        //[0,11] 12 bits año
        //[12,15] 4 bits mes
        //[16,20] 5 bits dia
        Scanner tec = new Scanner(System.in);
        System.out.print("Ingrese dia: "); int dia = tec.nextInt();
        System.out.print("Ingrese mes: "); int mes = tec.nextInt();
        System.out.print("Ingrese año: "); int anio = tec.nextInt();

        setDia(dia);
        setMes(mes);

    }

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
            int mask = 63488; //00000000000000001111100000000000
            data = (data & mask) | (dia << 16);
            System.out.println("Data: " + Long.toBinaryString(data) + "\nFecha: " + dia + "\n");
        } else {
            System.out.println("Dia no ingresado");
        }
    }

    public static void setMes(int mes) {
        if (mes > 0 && mes <= 12) {
            int mask = 983040; //00000000000011110000000000000000
            data = (data & mask) | (mes << 17);
            System.out.println("Data: " + Long.toBinaryString(data) + "\nMes: " + mes + "\n");
        } else {
            System.out.println("Mes no ingresado");
        }
    }

    public static void setAnio(int anio) {
        if (anio > 0 && anio <= 2022) {
            //11111111111100000000000000000000
        }
    }
}
