
public class AvlTreeMain {

	public static void main(String[] args) {
		System.out.println("CASO A: \n");
		AvlTree a = new AvlTree();
		for(int i = 0; i < 10; i++) {
			a.insert(i);
		}
		a.print();
		
		System.out.println("\nCASO B: \n");
		AvlTree b = new AvlTree();
		for(int i = 9; i >= 0; i--) {
			b.insert(i);
		}
		b.print();
		
		System.out.println("\nCASO C: \n");
		AvlTree c = new AvlTree();
		c.insert(0);
		c.insert(9);
		c.insert(1);
		c.insert(8);
		c.insert(2);
		c.insert(7);
		c.insert(3);
		c.insert(6);
		c.insert(4);
		c.insert(5);
		c.print();
		
		System.out.println("\nCASO D: \n");
		AvlTree d = new AvlTree();
		d.insert(5);
		d.insert(4);
		d.insert(6);
		d.insert(3);
		d.insert(7);
		d.insert(2);
		d.insert(8);
		d.insert(1);
		d.insert(9);
		d.insert(0);
		d.print();
		
	}

}
