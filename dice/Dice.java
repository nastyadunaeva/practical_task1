package dice;

import java.util.Random;

public class Dice {
	/*
	 * количество кубиков
	 */
	private int cubes; 
	
	public void setCubes(int value) {
		cubes = value;
	}
	public int getCubes() {
		return cubes;
	}
	/*
	 * Бросание кубиков
	 * Возвращает сумму выпавших чисел
	 */
	public int roll() {
		int sum = 0;
		final Random random = new Random();
		for (int i = 0; i < cubes; i++) {
			int num = random.nextInt(6) + 1;
			sum += num;
		}
		System.out.println(sum);
		return sum;
	}
	
}
