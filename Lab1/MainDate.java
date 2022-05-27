import java.util.Scanner;

public class MainDate {
    public static void main(String[] args) {

        Date fechaDate = new Date();

        int dia, mes, anio, hora, minuto;

        Scanner tec = new Scanner(System.in);
        System.out.print("Ingrese dia: "); dia = tec.nextInt();
        Date.setDia(dia);
        System.out.print("Ingrese mes: "); mes = tec.nextInt();
        Date.setMes(mes);
        System.out.print("Ingrese año: "); anio = tec.nextInt();
        Date.setAnio(anio);
        // System.out.print("Ingrese hora: "); hora = tec.nextInt();
        // TimeDate.setHora(hora);
        // System.out.print("Inrgese minuto: "); minuto = tec.nextInt();
        // TimeDate.setMinuto(minuto);

        System.out.println(fechaDate.toString());
    }
}
