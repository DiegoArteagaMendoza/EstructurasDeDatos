import java.util.Scanner;
public class Polinomio {
    //definimos la estructura del polinomio como: ax^n+bx^n+cx+d (por temas practicos usaremos 4 valores int como coeficiente,
    //ademas el valor x y un total de 3 exponenetes (e1, e2 y e3 respectivamente)).

    //  Main
    static Scanner tec = new Scanner(System.in);
        //  Variables
            //coeficiente
                static int a = 0;
                static int b = 0;
                static int c = 0;
                static int d = 0;
            //exponentes
                int e1 = 0, e2 = 0, e3 = 0;
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

    //  QUE SE HARA

    //1. crear un polinomio vacio
    //2. agregar un termino al polinomio (un = 1)
    //3. convertir un objeto de tipo polinomio a string
    //4. sumar dos polinomios
    //5. multiplicar dos polinomios
    //6. dado un valor, evaluar el polinomio (hacer el calculo entregando el valor de x)
    //7. Indicar el grado del polinomio (cantidad de termino)

    //utilizar lista enlazada donde cada nodo almacene el coeficiente, el exopoente y un puntero al siguente nodo
            //ej: 2x^3 + 3x^2 + 4x + 5 (se concidera exponente 0 para llenar el valor) == nodo 1: 23 -> nodo 2: 32 -> nodo 3: 45 -> nodo 4: 50
            //el puntero debe indicar el primer nodo, el cual debe apuntar al segundo y asi sucesibamente hasta que sea null
            //mantener la lista ordenada de mayor a menor en todo momento (coeficientes NO potencias)
            //no pueden haber nodos iguales, por lo cual antes de agregar cada nodo debe buscarse uno igual en caso de que hayan
            //en caso de que se ingresen 2 o mas polinomios a la ves, estos tiene que sumarse para ingresar solo uno al final

    //  Clases
    public static Nodo header;

    public static class Nodo { 
        public int coeficiente;
        public int exponente;
        public Nodo next;
        public Nodo(int coeficiente, int exponente, Nodo next)
        {this.coeficiente=coeficiente; this.exponente = exponente; this.next = next;} 
        void Print(){ System.out.print("Polinomio: " + coeficiente + "x^" + exponente + "\n");}
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

    public static void CreaPolinomio() {
        Polinomio p = new Polinomio();
        System.out.println(p.Size());
    }

    public static void AgregaUnTermino(/*int coeficiente, int exponente*/) { //agregar addordenado
        int coeficiente = 0;
        int exponente = 0;
        System.out.print("\n\nIngrese el coeficiente de su polinomio: "); coeficiente = tec.nextInt();
        System.out.print("Ingrese el exponente de su polinomio: "); exponente = tec.nextInt();
        if (isEmpty()) {
            header = new Nodo(coeficiente, exponente, null);
            System.out.println("Polinomio añadido");
        } else {
            header = new Nodo(coeficiente, exponente, header);
            System.out.println("Polinomio añadido");
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

    public static void convert() { //Imprime la lista enlazada completa
        if (isEmpty()) {
            System.out.println("No hay polinomios ingresados");
        } else {
            for (Nodo n = header; n != null; n = n.next) {
                n.Print();
            }
        }
    }

    public static void suma(/*int a, int b, int c, int d*/) { //a y b son un polinomio, c y d otro
        String[][] polinomio = new String[1][2];
        System.out.print("\n\nIngrese el coeficiente de su polinomio 1: "); a = tec.nextInt();
        System.out.print("Ingrese el exponente de su polinomio 1: "); b = tec.nextInt();
        System.out.println("\n");
        System.out.print("Ingrese el coeficiente de su polinomio 2: "); c = tec.nextInt();
        System.out.print("Ingrese el exponente de su polinomio 2: "); d = tec.nextInt();
        int coeficiente = a+c;
        int exopoente = 0;
        if (b == d) {
            exopoente = b;
        } else {
            exopoente = b*d;
        }
        polinomio[0][0] = String.valueOf(coeficiente);
        polinomio[0][1] = String.valueOf(exopoente);
        System.out.println("La suma de " + a +"x^"+ b + " y " + c +"x^"+ d + " es igual a: " + polinomio[0][0] + "x^" + polinomio[0][1]);
    }

    public static void multiplicar(/*int a, int b, int c, int d*/) { //a y b son un polinomio, c y d otro
        System.out.print("\n\nIngrese el coeficiente de su polinomio 1: "); a = tec.nextInt();
        System.out.print("Ingrese el exponente de su polinomio 1: "); b = tec.nextInt();
        System.out.println("\n");
        System.out.print("Ingrese el coeficiente de su polinomio 2: "); c = tec.nextInt();
        System.out.print("Ingrese el exponente de su polinomio 2: "); d = tec.nextInt();
        String[][] polinomio = new String[1][2];
        int coeficiente = a*c;
        int exopoente = b*d;;
        polinomio[0][0] = String.valueOf(coeficiente);
        polinomio[0][1] = String.valueOf(exopoente);
        System.out.println("La multiplicación de " + a +"x^"+ b + " y " + c +"x^"+ d + " es igual a: " + polinomio[0][0] + "x^" + polinomio[0][1]);
    }

    public static void evaluar(/*int a, int b, int x*/) {
        int a = 0,b = 0,x = 0;
        int result = 0;

        System.out.print("\n\nIngrese el coeficiente del polinomio: "); a = tec.nextInt();
        System.out.print("Ingrese el valor de X: "); x = tec.nextInt();
        System.out.print("Ingrese el exponenete del polinomoi: "); b = tec.nextInt();

        int pot = (int) Math.pow(b, x);
        //System.out.println(pot);
        result = a*(pot + 1);
        System.out.println("El resultado de evaluar el polinomio es: " + result);
    }

    public static void grado() { //recorre todos los polinomios agregados y restorna la cantidad que hay
        int tam = 0;
        Nodo n = header;
        while (n != null) {
            tam++;
            n = n.next;
        }
        System.out.println("El grado es: " + tam);
    }

    //falta hacer
        //ingresa ordenado de mayor a menor
        //grado
        //volver un bucle preguntando cuantos datos por polinomio
}
