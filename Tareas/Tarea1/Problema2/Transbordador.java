import java.util.Scanner;

//Diego Arteaga
//Rodrigo Jara
//Sebastian Jouannet
public class Transbordador{

    private Cola left = new Cola();
    private Cola right = new Cola();
    private Listas Autos = new Listas();
    private Listas tiempos = new Listas();
    private final int tamanioAutos;
    private final int tiempoLlegada;


     public Transbordador (int Autos, int Tiempo){
            this.tamanioAutos = Autos;
            this.tiempoLlegada = Tiempo;
        }


    public void agregaAuto(int llegada, String ubicacionAuto){
        Auto a = new Auto(llegada);
        Autos.add(a);
        if(ubicacionAuto.equals("left")){
            left.add(a);
        }else if (ubicacionAuto.equals("right")){
            right.add(a);
        }
    }
   
    public Listas Emulador(){
        int demora = 0;
        Cola lado1 = left;
        Cola lado2 = right;
        while (!left.estaVacia() || !right.estaVacia()){
            int contenido = 0;
            while(contenido < tamanioAutos && !lado1.estaVacia() && lado1.peek().horaLlegada <= demora){
                Autos.add(lado1.vehiculoss());
                tiempos.add(Integer.toString(demora + tiempoLlegada));
                contenido++;
            }
            
            if (contenido > 0 || (!lado2.estaVacia() && lado2.peek().horaLlegada <= demora)){
                demora += tiempoLlegada;
               Cola v = lado1;
                lado1 = lado2;
                lado2 = v;
            }else{
                Integer siguienteTiempo = null;
                if(!lado1.estaVacia()){
                    siguienteTiempo = lado1.peek().horaLlegada;
                }
                if(!lado2.estaVacia() && (siguienteTiempo == null || siguienteTiempo > lado2.peek().horaLlegada)){
                    siguienteTiempo = lado2.peek().horaLlegada;
                }
                if (siguienteTiempo != null){
                    demora = siguienteTiempo;
                }
            }
        }
        return tiempos;
    }

    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el numero de casos");
        int casos = teclado.nextInt();
        while (casos-- > 0){
            System.out.println("Ingrese Carga");
            int contenido = teclado.nextInt();
            System.out.println("Ingrese el tiempo que se tarda en minutos");
            int demora = teclado.nextInt();
            System.out.println("Ingrese la cantidad de autos");
            int cantidad = teclado.nextInt();
            Transbordador main = new Transbordador(contenido, demora);
            while(cantidad-- > 0){
                System.out.println("Tiempo en que llego el vehiculo");
                int minuto = teclado.nextInt();
                System.out.println("Ubicacion de el Vehiculo");
                String ubicacionVehiculo = teclado.next();
                main.agregaAuto(minuto,ubicacionVehiculo);
            }

            Listas emulator = main.Emulador();
            Nodo valor = emulator.head;
            while (valor!=null){
                System.out.println(valor.valor);
                valor = valor.next;
            }

        }
    }

    

    //Clase Auto
    private class Auto{
        public int horaLlegada;
        //Constructor Auto
        public Auto(int valor){
                this.horaLlegada = valor;
        }
    }

    //Clase Cola
    private class Cola{
        Nodo rear;
        Nodo front;

        //Constructor Cola
        public Cola(){
            front = null;
            rear = null;
        }

        public void add(Object valor){
            if(rear == null || front == null){
                rear = front = new Nodo(valor);
            }else{
                rear.next = new Nodo(valor);
                rear = rear.next;
            }
        }

        public Auto vehiculoss(){
            if(estaVacia()){
                return null;
            }else{
                Auto a = (Auto) front.valor;
                front = front.next;
                return a;
            }
        }

        public Auto peek(){
            if(estaVacia()){
                return null;
            }else{
                Auto a = (Auto) front.valor;
                return a;
            }
        }

        public boolean estaVacia(){
            return front == null || rear == null;
        } 
    }

    //Clase Listas
    private class Listas{
        Nodo head;

        //Constructor Listas
        public Listas(){
            head = null;
        }

        public void add(Object valor){
            if(estaVacia()){
                head = new Nodo(valor);
            }else{
                Nodo a = head;
                while(a.next != null){
                    a = a.next;
                }
                a.next = new Nodo(valor);
            }
        }

        public boolean estaVacia(){
            return head == null;
        }
    }

    //Clase Nodo
    private class Nodo{
        Object valor;
        Nodo next;

        //Constructor Nodo (con next)
        public Nodo(Object nuevoValor, Nodo next){
            this.valor = nuevoValor;
            this.next = next;
        }

        //Constructor Nodo (sin next)
        public Nodo(Object nuevoValor){
            this.valor = nuevoValor;
            this.next = null;
        }
    }
 }
