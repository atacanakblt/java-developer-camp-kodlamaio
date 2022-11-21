package kodlama.io.programmingLanguages.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.programmingLanguages.business.abstracts.ProgrammingLanguagesService;
import kodlama.io.programmingLanguages.entities.concretes.ProgrammingLanguages;

@RestController
@RequestMapping("/api/programmingLanguages")

public class ProgrammingLanguagesController {

	private ProgrammingLanguagesService programmingLanguagesService;

	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguagesService programmingLanguageService) {
		super();
		this.programmingLanguagesService = programmingLanguageService;
	}

	@GetMapping("/getall")
	public List<ProgrammingLanguages> getAll() {
		return programmingLanguagesService.getAll();
	}

	@GetMapping("/{id}")
	public ProgrammingLanguages getById(@PathVariable() int id) throws Exception {
		return programmingLanguagesService.getById(id);
	}

	@PostMapping("/add")
	public void create(@RequestBody ProgrammingLanguages programminglanguages) throws Exception {
		programmingLanguagesService.create(programminglanguages);
	}

	@PostMapping("/uptade")
	public void uptade(@RequestBody ProgrammingLanguages programminglanguages, @PathVariable int id) throws Exception {
		programmingLanguagesService.uptade(programminglanguages, id);

	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable(name = "id") int id) throws Exception {
		programmingLanguagesService.delete(id);
	}
}
