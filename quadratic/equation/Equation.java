package quadratic.equation;

public class Equation {
	/*
	 * Коэффициенты уравнения - закрытые поля
	 * 
	 */
	private double a;
	private double b;
	private double c;
	Discriminant discriminant;
	/*
	 * Значения коэффициентов по умолчанию - нули
	 */
	public Equation() {
		a = 0;
		b = 0;
		c = 0;
		discriminant = new Discriminant();
	}
	public Equation(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
		discriminant = new Discriminant();
	}
	public double getA() {
		return a;
	}
	public double getB() {
		return b;
	}
	public double getC() {
		return c;
	}
	/*
	 * Вложенный класс для нахождения дискриминанта.
	 * Экземпляр вложенного класса невозможно создать без экземпляра внешнего класса, так как дискриминант без квадратного уравнения не имеет смысла.
	 * Выделение отдельного класса реализует один из основных принципов ООП - инкапсуляцию, и позволяет абстрагироваться от вычислений.
	 *
	 */
	private class Discriminant {
		double value;
		/*
		 * Считаем значение дискриминанта в конструкторе
		 */
		Discriminant() {
			value = b * b - 4 * a * c;
		}
	}
	@Override
	public String toString() {
		return "a = " + a + "    b = " + b + "    c = " + c;
	}
	/*
	 * Метод, реализующий решение уравнения
	 * Отдельно обрабатывает случаи нулевых коэффициентов
	 */
	public void solution() {
		if (a == 0) {
			if (b == 0) {
				System.out.println("The equation has 1 root: " + 0);
			} else {
				System.out.println("The equation has 1 root: " + -c / b);
			}
			return;
		}
		if (discriminant.value > 0) {
			double x1 = (-b + Math.sqrt(discriminant.value)) / (2 * a);
			double x2 = (-b - Math.sqrt(discriminant.value)) / (2 * a);
			if (x1 > x2) {
				double tmp = x1;
				x1 = x2;
				x2 = tmp;
			}
			System.out.println("The equation has 2 roots: " + x1 + " " + x2);
		} else if (discriminant.value == 0) {
			double x = -b / (2 * a);
			System.out.println("The equation has 1 root: " + x);
		}
		else {
			System.out.println("Equation has no real roots");
		}
	}
}
