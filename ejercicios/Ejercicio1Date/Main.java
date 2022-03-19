package ejercicios.Ejercicio1Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Ejercicio1Date fechaDate = new Ejercicio1Date();

        int dia, mes, anio;

        Scanner tec = new Scanner(System.in);
        System.out.print("Ingrese dia: "); dia = tec.nextInt();
        System.out.print("Ingrese mes: "); mes = tec.nextInt();
        System.out.print("Ingrese año: "); anio = tec.nextInt();

        fechaDate.setDia(dia);
        fechaDate.setMes(mes);
        fechaDate.setAnio(anio);
        System.out.println(fechaDate.toString());
    }
}
