package kodlama.io.programmingLanguages.dataAccess.abstracts;

import java.util.List;

import kodlama.io.programmingLanguages.entities.concretes.ProgrammingLanguages;

public interface ProgrammingLanguagesRepository {

	List<ProgrammingLanguages> getAll();

	ProgrammingLanguages getById(int id) throws Exception;

	void create(ProgrammingLanguages programmingLanguages) throws Exception;

	void uptade(ProgrammingLanguages programmingLanguages, int id) throws Exception;

	void delete(int id) throws Exception;
}
