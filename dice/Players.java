package dice;

public class Players {
	/*
	 * количество игроков
	 */
	int players; 
	/*
	 * Массив очков каждого игрока на каждом коне
	 */
	int points[];
	/*
	 * Массив счетчиков выигрышей для каждого игрока
	 */
	int wins[];
	/*
	 * Поле, в котором хранится последний победитель (от 1 до players)
	 */
	int lastWinner;
	
	public Players(int players) {
		this.players = players;
		lastWinner = 1;
		points = new int[players];
		wins = new int[players];
	}
	/*
	 * Заполнение массива очков нулями
	 * Нужно для каждого нового кона игры
	 */
	public void updateZeros() {
		for (int i = 0; i < points.length; i++) {
			points[i] = 0;
		}
	}
	/*
	 * Проверка на то, набрал ли кто-то из игроков 7 выигрышей
	 */
	public int isSomeoneWins() {
		for (int i = 0; i < players; i++) {
			if (wins[i] == 7) {
				return i + 1;
			}
		}
		return 0;
	}
}
