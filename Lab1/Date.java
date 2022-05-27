import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

public class Date {
    private static int data;

    public void Date() {
        data = 0;
    }

    public int getDia() {
        int dia = (data << 17) >>> 27;
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
/*
    public int getHora() {
        int hora = (data << 21) >>> 27;
        return hora;
    }

    public int getMinuto() {
        int minuto = (data << 26) >>> 25;
        return minuto;
    }
*/
    public boolean sameDate(Date t) {
        LocalDate now = LocalDate.now();
        if (now.equals(t)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isBefore(Date t) {
        LocalDate now = LocalDate.now();
        if (now.isBefore((ChronoLocalDate)t)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isAfter(Date t) {
        LocalDate now = LocalDate.now();
        if (now.isAfter((ChronoLocalDate)t)) {
            return true;
        } else {
            return false;
        }
    }

    //año      //mes //dia //hora //minuto
//111111111111 1111  11111 11111  111111 

    public static void setDia(int dia) { //deja solo los bits del dia
        if (dia > 0 && dia <= 31) {
            int mask = 63489 | (1 << 31); //11111111111111110000011111111111
            data = (data & mask) | (dia << 19);
            // data = ~(data & mask);
            // data = data | (dia << 12);
            System.out.println("Data: " + Long.toBinaryString(data) + "\nFecha: " + dia + "\n");
        } else {
            System.out.println("Dia no ingresado");
        }
    }

    public static void setMes(int mes) {
        if (mes > 0 && mes <= 12) {
            int mask = -983041; //11111111111100001111111111111111
            data = (data & mask) | (mes << 16);
            // data = ~(data & mask);
            // data = data | (mes << 17);
            System.out.println("Data: " + Long.toBinaryString(data) + "\nMes: " + mes + "\n");
        } else {
            System.out.println("Mes no ingresado");
        }
    }

    public static void setAnio(int anio) {
        if (anio > 0 && anio <= 4095) {
            int mask = 1048575; //00000000000011111111111111111111
            data = (data & mask) | (anio << 20);
            System.out.println("Data: " + Long.toBinaryString(data) + "\nAnio " + anio + "\n");
        } else {
            System.out.println("Año no ingresado");
        }
    }

/*    public static void setHora(int hora) {
        if (hora >= 00 && hora < 24) {
            int mask = 992 | (1 << 31); //0000000000000000000001111100000
            data = ~(data & mask);
            data = data | (hora << 21);
            System.out.println("Data: " + Long.toBinaryString(data) + "\nHora " + hora + "\n");
        } else {
            System.out.println("Hora no ingresada");
        }
    }

    public static void setMinuto(int minuto) {
        if (minuto >= 0 && minuto < 60) {
            int mask = 63 | (1 << 31); //00000000000000000000000000111111
            data = ~(data & mask);
            data = data | (minuto << 26);
            System.out.println("Data: " + Long.toBinaryString(data) + "\nMinuto " + minuto + "\n");
        } else {
            System.out.println("Minuto no ingresado");
        }
    }
*/
    public String toString() {
        // return getDia() + "/" + getMes() + "/" + getAnio() + "\nHora: " + getHora() + "\nMinuto: " + getMinuto();
        return getDia() + "/" + getMes() + "/" + getAnio();
    }
}