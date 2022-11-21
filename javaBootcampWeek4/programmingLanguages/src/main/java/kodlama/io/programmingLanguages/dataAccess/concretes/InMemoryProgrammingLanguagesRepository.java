package kodlama.io.programmingLanguages.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.programmingLanguages.dataAccess.abstracts.ProgrammingLanguagesRepository;
import kodlama.io.programmingLanguages.entities.concretes.ProgrammingLanguages;

@Repository
public class InMemoryProgrammingLanguagesRepository implements ProgrammingLanguagesRepository {

	List<ProgrammingLanguages> programmingLanguages;

	public InMemoryProgrammingLanguagesRepository() {
		programmingLanguages = new ArrayList<ProgrammingLanguages>();
		programmingLanguages.add(new ProgrammingLanguages(1, "Java"));
		programmingLanguages.add(new ProgrammingLanguages(2, "Python"));
		programmingLanguages.add(new ProgrammingLanguages(3, "JavaScript"));
		programmingLanguages.add(new ProgrammingLanguages(4, "C"));
		programmingLanguages.add(new ProgrammingLanguages(5, "PHP"));

	}

	@Override
	public List<ProgrammingLanguages> getAll() {
		return programmingLanguages;
	}

	@Override
	public ProgrammingLanguages getById(int id) throws Exception {
		for (ProgrammingLanguages programminglanguages : programmingLanguages) {
			if (programminglanguages.getId() == id) {
				return programminglanguages;
			}
		}
		throw new Exception("Böyle bir kayıt bulunamadı");
	}

	@Override
	public void create(ProgrammingLanguages programminglanguages) throws Exception {
		programmingLanguages.add(programminglanguages);

	}

	@Override
	public void uptade(ProgrammingLanguages programminglanguages, int id) throws Exception {
		ProgrammingLanguages programminglanguages1 = getById(programminglanguages.getId());
		programminglanguages1.setName(programminglanguages.getName());
	}

	@Override
	public void delete(int id) throws Exception {
		ProgrammingLanguages programminglanguages1 = getById(id);
		programmingLanguages.remove(programminglanguages1);

	}

}
