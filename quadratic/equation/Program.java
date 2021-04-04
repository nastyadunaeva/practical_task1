package quadratic.equation;

public class Program {
	public static void main(String[] args) {
		Equation eq1 = new Equation(3, -4, 1);
		System.out.println(eq1.toString());
		eq1.solution();
		System.out.println();
		
		Equation eq2 = new Equation(0, -4, 1);
		System.out.println(eq2.toString());
		eq2.solution();
		System.out.println();
		
		Equation eq3 = new Equation(0, 0, 1);
		System.out.println(eq3.toString());
		eq3.solution();
		System.out.println();
		
		Equation eq4 = new Equation(1, 1, 1);
		System.out.println(eq4.toString());
		eq4.solution();
		System.out.println();
		
		Equation eq5 = new Equation(2, -8, 0);
		System.out.println(eq5.toString());
		eq5.solution();
	}
}
