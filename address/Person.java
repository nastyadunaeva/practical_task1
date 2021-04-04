package address;

import java.util.Calendar;

public class Person {
	String firstName;
	String lastName;
	Address address;
	Calendar calendar;
	
	public Person(String firstName, String lastName, Address address, Calendar calendar) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.calendar = calendar;
	}
	/*
	 * Получение полного имени
	 */
	public String getFullName() {
		return firstName + " " + lastName;
	}
	/*
	 * Вывод данных о человеке
	 */
	public void print() {
		System.out.println(this.getFullName());
		System.out.println(address.toString());
		System.out.println(calendar.get(Calendar.YEAR) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.DAY_OF_MONTH));
	}
	public boolean isBetween(Calendar begin, Calendar end) {
		if (calendar.before(end) && calendar.after(begin)) {
			return true;
		} else {
			return false;
		}
	}
}
