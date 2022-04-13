import java.util.Arrays;
import java.util.Scanner;
public class Polinomio {

    //  Main
    static Scanner tec = new Scanner(System.in);
    public static void main(String[] args) {
        Polinomio p = new Polinomio();
        int op = 10;
        do {
            System.out.println("Problema 1 menu\n1. Crear un polinomio vacío");
            System.out.println("2. Agregar un término al polinomio\n3. Convertir un objeto de polinomio a string");
            System.out.println("4. Sumar dos polinomios\n5. Multiplicar dos polinoios");
            System.out.println("6. Dado un valor, evaluar el polinomio\n7. Indicar el grado del polinomio");
            System.out.print("Opción: "); op = tec.nextInt();

            switch (op) {
                case 1: CreaPolinomio(); break;
                case 2: AgregaUnTermino();
                        System.out.println(p.Size());
                        break;
                case 3: convert(); break;
                case 4: suma(); break;
                case 5: multiplicar(); break;
                case 6: evaluar(); break;
                case 7: grado(); break;
                default:System.out.print("Cerrado");break;
            }
            System.out.println("\n\n");
        } while (op != 0);
    }

    //  Clases
    public static Nodo header;
    static Polinomio p = new Polinomio();

    public static class Nodo { 
        public int coeficiente;
        public int exponente;
        public Nodo next;
        public Nodo(int coeficiente, int exponente, Nodo next)
        {this.coeficiente=coeficiente; this.exponente = exponente; this.next = next;} 
        void Print(){ System.out.print(coeficiente + "x^" + exponente + " -- ");}
    }

    Polinomio() {
        header = null;
    }

    public static boolean isEmpty() {
        return header == null;
    }

    public int Size() {
        int tnodos=0;
        for(Nodo t = header; t !=null; t= t.next)  tnodos++;
        return tnodos;
    }

    public void InsertaInicio(int coeficiente, int exopoente, Nodo next) {
        if (isEmpty()) header=new Nodo(coeficiente, exopoente, null);
        else  header = new Nodo(coeficiente, exopoente, header);
    }

    static int cantPolinomios = 0;

    public static void CreaPolinomio() {
        Polinomio p = new Polinomio();
        System.out.println("\nPolinomio creado de tamaño: " + p.Size());
        cantPolinomios++;
        System.out.println(cantPolinomios);
    }

    public static void AgregaUnTermino() { //agregar addordenado
        //Polinomio p = new Polinomio();
        int coeficiente = 0, exponente = 0;

        System.out.print("\nCuantos coeficientes tendra su polinomio: "); int resp = tec.nextInt();
        int poli[] = new int[resp];

        System.out.println("\n\nIMPORTANTE: se preguntaran primero los coeficientes y luego los exponenetes\n\n");

        for (int i = 0; i < resp; i++) {
            System.out.print("Ingrese el coeficiente de su polinomio " + i + ": "); coeficiente = tec.nextInt();
            poli[i] = coeficiente;
        }

        int lista[] = IngresaOrdenado(poli);

        for (int i = 0; i < lista.length; i++ ){
            if (isEmpty()) {
                System.out.print("\nIngrese el exponente del polinomio de coeficiente " + lista[0] + ": "); exponente = tec.nextInt();
                p.InsertaInicio(lista[0],exponente,null);
                System.out.println("Polinomio añadido "+ lista[0] + "x^" + exponente);
    
            } else {
                System.out.print("\nIngrese el exponente del polinomio de coeficiente " + lista[i] + ": "); exponente = tec.nextInt();
                p.InsertaInicio(lista[i],exponente,header);
                System.out.println("Polinomio añadido " + lista[i] + "x^" + exponente);
            }
        }
    }

    void Print() {
        if(header!=null) Imprimir(header);
        else System.out.println("Lista Vacia");
    }
       
    void Imprimir(Nodo m ) {
        if(m !=null) {
            m.Print(); Imprimir(m.next);
        }
    }

    public static void convert() {
        if (isEmpty()) {
            System.out.println("No hay polinomios ingresados");
        } else {
            for (Nodo n = header; n != null; n = n.next) {
                n.Print();
            }
        }
    }

    public static void suma() {
        
    }

    public static void multiplicar() {
        
    }

    public static void evaluar() {
        Nodo n = header;
        int a = 0,b = 0,x = 0;
        int result = 0;

        System.out.print("Ingrese el valor de X: "); x = tec.nextInt();

        while (n != null) {
            a = n.coeficiente;
            b = n.exponente;
            int pot = (int) Math.pow(b, x);
            result = a*(pot);
            System.out.println("El resultado de evaluar el polinomio " + a+"*("+x+"^"+b + ") es: " + result);
            n = n.next;
        }
    }

    public static void grado() { //recorre todos los polinomios agregados y retorna la cantidad que hay
        int tam = 0;
        Nodo n = header;
        while (n != null) {
            tam++;
            n = n.next;
        }
        System.out.println("El grado es: " + tam);
    }

    public static int[] IngresaOrdenado(int[] datos) { //4,2,3
        Arrays.sort(datos);
        return datos;
    }

    //falta hacer
        //preguntar cuanto polinomios se ingresaran (polinomio != coeficiente) (en caso de que sean 2 o mas sumarlos)
        //suma y multiplicación

    // String[][] polinomio = new String[1][2];
    //     System.out.print("\n\nIngrese el coeficiente de su polinomio 1: "); a = tec.nextInt();
    //     System.out.print("Ingrese el exponente de su polinomio 1: "); b = tec.nextInt();
    //     System.out.println("\n");
    //     System.out.print("Ingrese el coeficiente de su polinomio 2: "); c = tec.nextInt();
    //     System.out.print("Ingrese el exponente de su polinomio 2: "); d = tec.nextInt();
    //     int coeficiente = a+c;
    //     int exopoente = 0;
    //     if (b == d) {
    //         exopoente = b;
    //     } else {
    //         exopoente = b*d;
    //     }
    //     polinomio[0][0] = String.valueOf(coeficiente);
    //     polinomio[0][1] = String.valueOf(exopoente);
    //     System.out.println("La suma de " + a +"x^"+ b + " y " + c +"x^"+ d + " es igual a: " + polinomio[0][0] + "x^" + polinomio[0][1]);



    // System.out.print("\n\nIngrese el coeficiente de su polinomio 1: "); a = tec.nextInt();
    //     System.out.print("Ingrese el exponente de su polinomio 1: "); b = tec.nextInt();
    //     System.out.println("\n");
    //     System.out.print("Ingrese el coeficiente de su polinomio 2: "); c = tec.nextInt();
    //     System.out.print("Ingrese el exponente de su polinomio 2: "); d = tec.nextInt();
    //     String[][] polinomio = new String[1][2];
    //     int coeficiente = a*c;
    //     int exopoente = b*d;;
    //     polinomio[0][0] = String.valueOf(coeficiente);
    //     polinomio[0][1] = String.valueOf(exopoente);
    //     System.out.println("La multiplicación de " + a +"x^"+ b + " y " + c +"x^"+ d + " es igual a: " + polinomio[0][0] + "x^" + polinomio[0][1]);
}
