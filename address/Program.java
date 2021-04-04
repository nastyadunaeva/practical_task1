package address;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Address ad1 = new Address("Russia", "Moscow", "Lomonosovskiy prospect", 27, 638);
		Calendar cal1 = new GregorianCalendar(2000, Calendar.SEPTEMBER, 9);
		Person person1 = new Person("Anastasia", "Dunaeva", ad1, cal1);
		
		Address ad2 = new Address("Russia", "Nizhniy Novgorod", "prospect Gagarina", 104, 7);
		Calendar cal2 = new GregorianCalendar(1999, Calendar.JANUARY, 4);
		Person person2 = new Person("Dmitry", "Popov", ad2, cal2);
		
		Address ad3 = new Address("USA", "New York", "Brighton Beach Ave", 5, 1);
		Calendar cal3 = new GregorianCalendar(1960, Calendar.JULY, 4);
		Person person3 = new Person("Maria", "Ivanova", ad3, cal3);
		
		Address ad4 = new Address("Spain", "Barcelona", "Diagonal Mar", 7, 2);
		Calendar cal4 = new GregorianCalendar(1985, Calendar.AUGUST, 25);
		Person person4 = new Person("Elena", "Grigoryeva", ad4, cal4);
		
		Address ad5 = new Address("Russia", "Nizhniy Novgorod", "prospect Gagarina", 118, 65);
		Calendar cal5 = new GregorianCalendar(2001, Calendar.APRIL, 20);
		Person person5 = new Person("Stepan", "Gladkov", ad5, cal5);
		
		Person []persons = new Person[] {person1, person2, person3, person4, person5};
		
		Scanner in = new Scanner(System.in);
		/*
		 * Поиск человека по фамилии
		 */
		System.out.print("Enter last name:  ");
		String lastNameFind = in.nextLine();
		
		boolean notFound = true;
		for (int i = 0; i < persons.length; i++) {
			if (persons[i].lastName.equals(lastNameFind)) {
				persons[i].print();
				notFound = false;
			}
		}
		if (notFound == true) {
			System.out.println("Person not found");
		}
		System.out.println();
		
		/*
		 * Поиск человека по адресу
		 */
		System.out.print("Enter country:  ");
		String country = in.nextLine();
		System.out.print("Enter city:  ");
		String city = in.nextLine();
		System.out.print("Enter street:  ");
		String street = in.nextLine();
		System.out.print("Enter building:  ");
		int building = in.nextInt();
		System.out.print("Enter apartment:  ");
		int apartment = in.nextInt();
		Address addressFind = new Address(country, city, street, building, apartment);
		notFound = true;
		for (int i = 0; i < persons.length; i++) {
			if (persons[i].address.equals(addressFind)) {
				persons[i].print();
				notFound = false;
			}
		}
		if (notFound == true) {
			System.out.println("Address not found");
		}
		System.out.println();
		
		/*
		 * Поиск людей, родившихся между двумя датами
		 */
		System.out.println("Beginnig date");
		System.out.print("Enter year:  ");
		int beg_year = in.nextInt();
		System.out.print("Enter month:  ");
		int beg_month = in.nextInt() - 1;
		System.out.print("Enter day:  ");
		int beg_day = in.nextInt();
		System.out.println("End date");
		System.out.print("Enter year:  ");
		int end_year = in.nextInt();
		System.out.print("Enter month:  ");
		int end_month = in.nextInt() - 1;
		System.out.print("Enter day:  ");
		int end_day = in.nextInt();
		Calendar cal_beg = new GregorianCalendar(beg_year, beg_month, beg_day);
		Calendar cal_end = new GregorianCalendar(end_year, end_month, end_day);
		for (int i = 0; i < persons.length; i++) {
			if (persons[i].isBetween(cal_beg, cal_end)) {
				persons[i].print();
			}
		}
		System.out.println();
		
		/*
		 * Самый старый
		 */
		System.out.println(">The oldest person");
		Calendar min = persons[0].calendar;
		Person oldest = persons[0];
		for (int i = 1; i < persons.length; i++) {
			if (persons[i].calendar.before(min)) {
				min = persons[i].calendar;
				oldest = persons[i];
			}
		}
		oldest.print();
		System.out.println();
		
		/*
		 * Самый молодой
		 */
		System.out.println(">The youngest person");
		Calendar max = persons[0].calendar;
		Person youngest = persons[0];
		for (int i = 1; i < persons.length; i++) {
			if (persons[i].calendar.after(max)) {
				max = persons[i].calendar;
				youngest = persons[i];
			}
		}
		youngest.print();
		System.out.println();
		
		/*
		 * Поиск людей, проживающих на одной улице
		 */
		notFound = true;
		System.out.println(">Live on the same street");
		for (int i = 0; i < persons.length; i++) {
			for (int j = i + 1; j < persons.length; j++) {
				if (persons[i].address.street.equals(persons[j].address.street)) {
					persons[i].print();
					persons[j].print();
					notFound = false;
				}
			}
		}
		if (notFound == true) {
			System.out.println("Persons not found");
		}
		in.close();
	}
}
