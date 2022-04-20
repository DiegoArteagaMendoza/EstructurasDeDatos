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
            System.out.println("6. Dado un valor, evaluar el polinomio\n7. Indicar el grado del polinomio\n0. Salir");
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
    public static Nodo header;
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
        if (isEmpty()){
            header=new Nodo(coeficiente, exoponente,null);
        } else {
            boolean op = buscaIguales(coeficiente, exoponente);
            if (op == true) {
                header = new Nodo(coeficiente, exoponente, header);
            } else {
                System.out.println("Polinomio ingresado antes...");
            }
        }
    }

    private boolean buscaIguales(int coeficiente, int exoponente) { //funcion que busca si hay algun polinomio igual 
        Nodo n = header;
        while (n != null) {
            if (n.coeficiente == coeficiente) {
                if (n.exponente == exoponente) {
                    n = n.next;
                } else {
                    return true;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    static int cantPolinomios = 0;

    public static void CreaPolinomio() { //Orden (1)
        Polinomio p = new Polinomio();
        System.out.println("\nPolinomio creado de tamaño: " + p.Size());
        cantPolinomios++;
        System.out.println(cantPolinomios);
    }

    public static void AgregaUnTermino() { //Orden (n2)
        System.out.print("\nCuantos polinomios ingresara: "); int op = tec.nextInt();
        if (op > 1) {
            System.out.println("\nSe agregaran polinomios de formato monomio...");
            int coeficientes[] = new int[op];
            int exponentes[] = new int[op];

            for (int i = 0; i < op; i++) {
                System.out.print("Ingrese el coeficiente del polinomio " + (i+1) + ": "); coeficientes[i] = tec.nextInt();
            }
            coeficientes =  IngresaOrdenado(coeficientes);

            for (int i = 0; i < op; i++) {
                System.out.print("Ingrese el exponente del coeficiente " + coeficientes[i] + "x^: "); exponentes[i] = tec.nextInt();
            }
            int agrega[][] = suma2(coeficientes, exponentes); //agrega en pos 1 = coeficiente suma y pos 2 = exponenete mayor

            p.InsertaInicio(agrega[0][0], agrega[0][1], header);

        } else {
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
    }

    public static int[][] suma2(int coeficientes[], int exponentes[]) { //aplica para cuando se ingresan mas de 1 polinomio a la ves, en las cuales hay que sumarlos para ingersar el final
        int retorno[][] = new int [1][2];
        int coeficiente = 0;
        int exoponente = 0;
        for (int i = 0; i < coeficientes.length; i++) {
            coeficiente = coeficiente + coeficientes[i];
        }
        int exponentesOrd[] = IngresaOrdenado(exponentes);
        exoponente = exponentesOrd[exponentesOrd.length-1];

        retorno[0][0] = coeficiente;
        retorno[0][1] = exoponente;
        return retorno;
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

    public static void convert() { //Orden (n), convierte de int a srting
        if (isEmpty()) {
            System.out.println("No hay polinomios ingresados");
        } else {
            for (Nodo n = header; n != null; n = n.next) {
                n.Print();
            }
        }
    }

    public static void suma() { //Orden (n)
        Nodo n = header;
        int resultados[][] = new int[1][2];
        int exponentes[] = new int[p.Size()];
        int i = 0;
        while (n != null) {
            resultados[0][0] = resultados[0][0] + n.coeficiente;
            exponentes[i] = n.exponente;
            i++;
            n = n.next;
        }
        int exponentesOrd[] = IngresaOrdenado(exponentes);
        resultados[0][1] = exponentesOrd[exponentesOrd.length-1];

        System.out.println(resultados[0][0] + "x^" + resultados[0][1]);
    }

    public static void multiplicar() { //Orden(n)
        Nodo n = header;
        int coef = 1;
        int exp = 0;
        while (n != null) {
            coef = coef * n.coeficiente;
            exp += n.exponente;
            n = n.next;
        }
        System.out.println(coef + "x^" + exp);
    }

    public static void evaluar() { //Orden(n)
        Nodo n = header;
        int a = 0,b = 0,x = 0;
        int result = 0;

        System.out.print("Ingrese el valor de X: "); x = tec.nextInt();

        while (n != null) {
            a = n.coeficiente;
            b = n.exponente;
            int pot = (int) Math.pow(x, b);
            result = a*(pot);
            System.out.println("El resultado de evaluar el polinomio " + a+"*("+x+"^"+b + ") es: " + result);
            n = n.next;
        }
    }

    public static void grado() { //recorre todos los polinomios agregados y retorna la suma de los exponentes Orden(n)
        int i = 0;;
        int exp[] = new int[p.Size()];
        Nodo n = header;
        while (n != null) {
            //grade += n.exponente;
            exp[i] = n.exponente;
            i++;
            n = n.next;
        }
        exp = IngresaOrdenado(exp);
        System.out.println("El grado mayor es: " + exp[exp.length-1]);
    }

    public static int[] IngresaOrdenado(int[] datos) { //funcion que ordena de mayor a menor
        Arrays.sort(datos);
        return datos;
    }
}