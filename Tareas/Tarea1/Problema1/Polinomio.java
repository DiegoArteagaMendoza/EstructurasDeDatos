import java.util.*;
public class Polinomio {

    //  Main
    static Scanner tec = new Scanner(System.in);
    public static void main(String[] args) {
        int op = 10;
        do {
            System.out.println("Problema 1 menu\n1. Crear un polinomio vacío");
            System.out.println("2. Agregar un término al polinomio\n3. Convertir un objeto de polinomio a string");
            System.out.println("4. Sumar dos polinomios\n5. Multiplicar dos polinoios");
            System.out.println("6. Dado un valor, evaluar el polinomio\n7. Indicar el grado del polinomio");
            System.out.print("Opción: "); op = tec.nextInt();

            switch (op) {
                case 1: CreaPolinomio(); break;
                case 2: AgregaUnTermino(); break;
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
    public static Polinomio.Nodo header;
    static Polinomio p = new Polinomio();

    public static class Nodo { 
        public int coeficiente;
        public int exponente;
        public Nodo next;
        public Nodo(int coeficiente, int exponente, Nodo next)
        {this.coeficiente=coeficiente; this.exponente = exponente; this.next = next;} 
        void Print(){ System.out.print(coeficiente + "x^" + exponente + " \n");}
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

    public void InsertaInicio(int coeficiente, int exoponente, Nodo next) {
        if (isEmpty()) header=new Nodo(coeficiente, exoponente,null);
        else header = new Nodo(coeficiente, exoponente, header);
    }

    static int cantPolinomios = 0;

    public static void CreaPolinomio() {
        Polinomio p = new Polinomio();
        System.out.println("\nPolinomio creado de tamaño: " + p.Size());
        cantPolinomios++;
        System.out.println(cantPolinomios);
    }

    public static void AgregaUnTermino() {
        System.out.print("\nCuantos coeficientes tendra su polinomio: "); int resp = tec.nextInt();
        int coeficientes[] = new int[resp];
        int exponentes[] = new int[resp];

        for (int i = 0; i < resp; i++) {
            System.out.print("Ingrese el coeficiente del polinomio " + (i+1) + ": "); coeficientes[i] = tec.nextInt();
        }
        coeficientes =  IngresaOrdenado(coeficientes);

        for (int i = 0; i < resp; i++) {
            System.out.print("Ingrese el exponente del coeficiente " + coeficientes[i] + "x^: "); exponentes[i] = tec.nextInt();
            p.InsertaInicio(coeficientes[i], exponentes[i], header);
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
        Nodo n = header;
        Nodo m = header.next;
        int resultados[][] = new int[p.Size()][2];
        while (m != null) {
            int i = 0;
            if (n.exponente == m.exponente) {
                int coeficiente = n.coeficiente + m.coeficiente;
                int exoponente = n.exponente;
                resultados[i][0] = coeficiente;
                resultados[i][1] = exoponente;
                i++;
            } else {
                if (n.coeficiente > m.coeficiente) {
                    resultados[i][0] = n.coeficiente;
                    resultados[i][1] = n.exponente;
                    i++;
                } else {
                    resultados[i][0] = m.coeficiente;
                    resultados[i][1] = m.exponente;
                    i++;
                }
            }
            n = n.next;
            m = m.next;
        }
        for (int j = 0; j < resultados.length; j++) {
            System.out.print(resultados[j][0] + "x^" + resultados[j][1] + " + ");
        }
    }

    public static void multiplicar() {
        Nodo n = header;
        Nodo m = header.next;
        int resultados[][] = new int[p.Size()][2];
        while (m != null) {
            int i = 0;
            if (n.exponente == m.exponente) {
                int coeficiente = n.coeficiente * m.coeficiente;
                int exoponente = n.exponente * m.exponente;
                resultados[i][0] = coeficiente;
                resultados[i][1] = exoponente;
                i++;
            } else {
                if (n.coeficiente > m.coeficiente) {
                    resultados[i][0] = n.coeficiente;
                    resultados[i][1] = n.exponente;
                    i++;
                } else {
                    resultados[i][0] = m.coeficiente;
                    resultados[i][1] = m.exponente;
                    i++;
                }
            }
            n = n.next;
            m = m.next;
        }
        for (int j = 0; j < resultados.length; j++) {
            System.out.print(resultados[j][0] + "x^" + resultados[j][1] + " + ");
        }
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
        //duplicados
}
