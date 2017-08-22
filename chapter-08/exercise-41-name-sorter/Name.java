public class Name implements Comparable<Name> {

	private String firstName;
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public int compareTo(Name other) {
		if (this == other) {
			return 0;
		} else if (lastName.equals(other.getLastName())) {
			return firstName.compareTo(other.getFirstName());
		} else {
			return lastName.compareTo(other.getLastName());
		}
	}

	@Override
	public String toString() {
		return String.format("%s, %s", lastName, firstName);
	}
}
