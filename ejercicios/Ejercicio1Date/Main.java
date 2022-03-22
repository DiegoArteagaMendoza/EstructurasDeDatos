package ejercicios.Ejercicio1Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Ejercicio1Date fechaDate = new Ejercicio1Date();

        int dia, mes, anio, hora, minuto;

        Scanner tec = new Scanner(System.in);
        System.out.print("Ingrese dia: "); dia = tec.nextInt();
        System.out.print("Ingrese mes: "); mes = tec.nextInt();
        System.out.print("Ingrese año: "); anio = tec.nextInt();
        System.out.print("Ingrese hora: "); hora = tec.nextInt();
        System.out.print("Inrgese minuto: "); minuto = tec.nextInt();

        fechaDate.setDia(dia);
        fechaDate.setMes(mes);
        fechaDate.setAnio(anio);
        fechaDate.setHora(hora);
        fechaDate.setMinuto(minuto);
        System.out.println(fechaDate.toString());
    }
}
