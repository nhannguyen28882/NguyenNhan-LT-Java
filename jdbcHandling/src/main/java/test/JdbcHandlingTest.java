package test;

import data.JdbcPerson;
import domain.Person;
import java.util.List;

public class JdbcHandlingTest {
	public static void main(String[] args) {
		JdbcPerson jdbcPerson = new JdbcPerson();
		
		//Test of the insert method
		//jdbcPerson.insert("Charly");

		//Test of the update method
		//jdbcPerson.update(1, "John");

		//Test the delete method, the id_person must exist in the database
		//jdbcPerson.delete(1);

		//Select method test
		//Use of a person object to encapsulate the information
		
		List<Person> people = jdbcPerson.select();
		for (Person person : people) {
			System.out.print(person);
			System.out.print("");
		}
	}
}
