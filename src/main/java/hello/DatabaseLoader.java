package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final PersonRepository repository;

	@Autowired
	public DatabaseLoader(PersonRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... strings) throws Exception {
		this.repository.save(new Person("Murray", "Bodor"));
		this.repository.save(new Person("Brenda", "Bodor"));
		this.repository.save(new Person("Emily", "Bodor"));
		this.repository.save(new Person("Rachel", "Bodor"));
	}
}