package address;

public class Address {
	String country;
	String city;
	String street;
	int building;
	int apartment;
	
	public Address(String country, String city, String street, int building, int apartment) {
		this.country = country;
		this.city = city;
		this.street = street;
		this.building = building;
		this.apartment = apartment;
	}
	
	public boolean equals(Address other) {
		if ((other.country.equals(country)) && (other.city.equals(city)) && (other.street.equals(street)) 
				&& (other.building == building) && (other.apartment == apartment)) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return apartment + " apt, " + building + ", " + street + ", " + city + ", " + country;
	}
}
