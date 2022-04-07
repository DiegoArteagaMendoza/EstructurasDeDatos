public class Polinomio {
    //Crear un plinomio vacio                           ready
    //Agregar un término al polinomio                   ready
    //Convertir un objeto de tipo polinomio a String    ready
    //Sumar dos polinomios                              
    //Dado un valor, evalua el polinomio
    //Indicar el grado del polinomio    

    //reemplazar todo lo creado como polinomio por int

    Polinomio p;
    private Nodo header;
    private void polinomio() {
        header = null;
    }

    private class Polinomio {
        public int valor;
        public Polinomio next;
        public Polinomio (Polinomio newObj, Polinomio next);
        {this.valor = newObj; this.next = next;}
        void Print() {
            System.out.print("Val agregado: " + valor);
        }
    }

    public void addPolinomioInicio(Polinomio date) {
        if (date != null && isEmpty()) {
            header = new Polinomio(date, null);
        } else {
            header = new Polinomio(date, header);
        }
    }

    public void addPolinomioFinal(Polinomio date) {
        if (date != null && isEmpty()) {
            header = new Polinomio(date, null);
        } else {
            Nodo n;
            for (n = header; n.next != null; n = n.next) {
                n.next = new Polinomio(date, null);
            }
        }
    } 

    public String convert(Polinomio date) {
        if (date != null && isEmpty()) {
            String polinomioString;
            Nodo n;
            for (n = header; n != null; n = n.next) {
                polinomioString = date;
                return polinomioString;
            }
        }
    }

    public int suma(Polinomio date1, Polinomio date2) {
        if (date1 != null && date2 != null) {
            int result = 0;
            return result;
        }
    }

    public int Size() {
        int nodosN = 0;
        for (Noto n = header; n != null; n = n.next) {
            nodosN++;
        }
        return nodosN;
    }

    private Boolean isEmpty() {
        return header == null;
    }

}
