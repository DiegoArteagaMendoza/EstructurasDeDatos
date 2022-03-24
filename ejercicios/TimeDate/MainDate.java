package ejercicios.TimeDate;
import java.util.Scanner;

public class MainDate {
    public static void main(String[] args) {

        TimeDate fechaDate = new TimeDate();

        int dia, mes, anio, hora, minuto;

        Scanner tec = new Scanner(System.in);
        System.out.print("Ingrese dia: "); dia = tec.nextInt();
        TimeDate.setDia(dia);
        System.out.print("Ingrese mes: "); mes = tec.nextInt();
        TimeDate.setMes(mes);
        System.out.print("Ingrese año: "); anio = tec.nextInt();
        TimeDate.setAnio(anio);
        System.out.print("Ingrese hora: "); hora = tec.nextInt();
        TimeDate.setHora(hora);
        System.out.print("Inrgese minuto: "); minuto = tec.nextInt();
        TimeDate.setMinuto(minuto);

        System.out.println(fechaDate.toString());
    }
}
