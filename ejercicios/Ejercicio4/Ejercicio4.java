package ejercicios.Ejercicio4;

import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {

        System.out.print(ComprobarSiUnBitEstaPrendido() + "\n");


        Scanner tec = new Scanner(System.in);
        int x = tec.nextInt();
        if (CambiaElValorDelBit(x) == true) {
            System.out.print("El bit en la pocision " + x + " ha cambiado");
        } else {
            System.out.print("El bit de la pocision " + x + " no ha cambiado");
        }

    }

    public static String ComprobarSiUnBitEstaPrendido() {
        int n = 3; //cantidad de bits a desplazar
        int num = 14; //numero a trabajar
        int mask = 1; //mascara
        mask = mask << (n-1); //desplaza el bit n-1 espacios a la izquierda
        if ((mask & num) != 0) {
            return "El bit esta prendido";
        } else {
            return "El bit esta apagado";
        }
    }

    public static Boolean CambiaElValorDelBit(int x) {
        int n = x;
        int num = 13;
        int num2 = 13;
        int mask = 1;
        mask = mask << n;
        num = num | mask; //todo lo que es 1 en mask ahora lo es en el num
        if ((num | num2) != 0) {
            return true;
        } else {
            return false;
        }
    }


}