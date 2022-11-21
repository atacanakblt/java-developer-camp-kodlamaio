package kodlama.io.programmingLanguages.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.programmingLanguages.business.abstracts.ProgrammingLanguagesService;
import kodlama.io.programmingLanguages.dataAccess.abstracts.ProgrammingLanguagesRepository;
import kodlama.io.programmingLanguages.entities.concretes.ProgrammingLanguages;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguagesService {

	 ProgrammingLanguagesRepository programmingLanguagesRepository;
	
	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguagesRepository programmingLanguagesRepository) {
		super();
		this.programmingLanguagesRepository = programmingLanguagesRepository;
	}

	@Override
	public List<ProgrammingLanguages> getAll() {	
		return programmingLanguagesRepository.getAll();
	}

	@Override
	public ProgrammingLanguages getById(int id) throws Exception {
		return programmingLanguagesRepository.getById(id);
	}

	@Override
	public void create(ProgrammingLanguages programmingLanguages) throws Exception {
		if(programmingLanguages.getName().isEmpty()) {
			throw new Exception("Bu alan boş bırakılamaz");
		}
		for(ProgrammingLanguages programmingLanguages1 : getAll()) {
			if(programmingLanguages1.getId()==programmingLanguages.getId())
				throw new Exception("Aynı isim tekrar edemez");
		}
		programmingLanguagesRepository.create(programmingLanguages);
	}

	@Override
	public void uptade(ProgrammingLanguages programmingLanguages, int id) throws Exception {
		if(programmingLanguagesRepository.getById(id)==null) {
			throw new Exception("Bu programlama dili sistemde mevcut değildir");
		}
		programmingLanguagesRepository.uptade(programmingLanguages,id);
	}

	@Override
	public void delete(int id) throws Exception {
		programmingLanguagesRepository.delete(id);
	}

	
	
	
}
