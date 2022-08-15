import java.util.Stack;

/**
 * 
 * @author Martita
 * 
 * Para m�s info, visitar https://es.stackoverflow.com/questions/26907/infijo-a-posfijo-en-java
 * Y http://informatica.uv.es/iiguia/AED/laboratorio/P6/pr_06_2005.html
 *
 */

public class Parsing {

	public static String fromInfijoToPostfijo(String infijo) {

		//crear simbol es una pila
		Stack<Character> simbol = new Stack<>();
		//pasar infijo a char
		char[] charInfijo;
		charInfijo = infijo.toCharArray();

		//string posfijo
		String salida = "";

		for (char s: charInfijo) {
			if (isANumber(s)) {
				salida += s;
			} else if (s == '(') {
					//meter a la pila s
					simbol.push(s);
				} else if (s == ')') {
						//desempilar toda la pila y organizarlo en el nuevo orden
						//detenerese en cuanto salga "("
						String pila = "";
						char[] pilaArr = pila.toCharArray();
						while (simbol.peek() != '(') {	
							pila += simbol.pop();
						}
						for (char c : pilaArr) {
							simbol.push(c);
						}
					} else if (!isANumber(s)) {
								if (simbol.size() == 0) {
									simbol.push(s);
								} else {
									if (prioridad(s) > prioridad(simbol.peek())) {
										simbol.push(s);
									} else {
										//concatenar el ultimo dato agregado en la pila a posfijo
										salida += simbol.pop();
										simbol.push(s);
									}
								}
							}
		}
		while (simbol.empty() == false) {
			salida += simbol.pop();
		}
		return salida; //retornar posfijo
	}
	
	private static boolean isANumber(char symbol) {
		return symbol == '0' || symbol == '1' || symbol == '2' || symbol == '3' || 
				symbol == '4' || symbol == '5' || symbol == '6' || symbol == '7' || 
				symbol == '8' || symbol == '9';
	}
	
	private static int prioridad(char symbol) {
		if(symbol == '(') return 0;
		if(symbol == '+' || symbol == '-') return 1;
		if(symbol == '*' || symbol == '/') return 2;
		return -1;
	}

	
	public static ArbolExpresion getArbol(String postfijo) {
		Stack<ArbolExpresion> pilaA = new Stack<>();
		char[] posfijoChar = postfijo.toCharArray();
		for (char s: posfijoChar) {
			//agregar s como como raiz de un arbol sin hijos
			ArbolExpresion arbol = new ArbolExpresion(s);
			if (isANumber(s)) {
				pilaA.push(arbol);
			} else {
				arbol.left = pilaA.pop();
				arbol.right = pilaA.pop();
				pilaA.push(arbol);
			}
		}
		return pilaA.peek();
	}

	public static int calculo (ArbolExpresion i) {
		if (i == null) {
			return 0;
		}
		int val = calculo(i.right);
		int result = 0;
		if (isANumber(i.symbol)) {
			result = Character.getNumericValue(i.symbol);
		} else {
			if (prioridad(i.symbol) == 1 || prioridad(i.symbol) == 2) {
				switch (i.symbol) {
					case 'x': result = val * calculo(i.left);break;
					case '/': result = val / calculo(i.left);break;
					case '+': result = val + calculo(i.left);break;
					case '-': result = val - calculo(i.left);break;
				}
			}
		}
		return result;
	}
}