import java.util.Scanner;
public class testKdTree {
    public static void main(String[] args) {
        appKdTree a = new appKdTree();
        a.insert(5,5);
        a.insert(6,5);
        a.insert(3,2);
        a.insert(7,1);
        a.insert(1,1);
        a.insert(1,2);
        a.insert(6,4);

        a.Imprimir();
        System.out.println("\n");
        a.busca(6,4);

        System.out.println("\n");

        Scanner tec = new Scanner(System.in);
        int i = 0;
        while (i < 2){
            System.out.println("Ingrese un punto nuevo:");
            System.out.print("x: "); int x = tec.nextInt();
            System.out.print("y: "); int y = tec.nextInt();
            System.out.println("\n");
            a.insert(x,y);
            a.Imprimir();
            i++;
        }
    }
}
