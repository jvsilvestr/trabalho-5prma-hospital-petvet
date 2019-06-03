package br.edu.unifanor.hospitalpetvet.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.unifanor.hospitalpetvet.entity.Animal;
import br.edu.unifanor.hospitalpetvet.entity.Tutor;
import br.edu.unifanor.hospitalpetvet.repository.AnimalRepository;
import br.edu.unifanor.hospitalpetvet.repository.TutorRepository;

@Controller
@RequestMapping("/tutores/")
public class TutorController {
	
	private final TutorRepository tutorRepository;
	private final AnimalRepository animalRepository;

	private List<Animal> animais;
	
	@Autowired
	public TutorController(TutorRepository tutorRepository, AnimalRepository animalRepository) {
		this.tutorRepository = tutorRepository;
		this.animalRepository = animalRepository;
		this.animais = new ArrayList<Animal>();
	}
	
	@GetMapping("/signup")
	public String showSignUpForm(Tutor tutor, Animal animal) {
		return "add-tutor";
	}
	
	@GetMapping("/list")
	public String showUpdateForm(Model model) {
		model.addAttribute("tutores", tutorRepository.findAll());
		return "index";
	}
	
	@PostMapping("/add")
	public String addTutor(@Valid Tutor tutor, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-tutor";
		}

		tutorRepository.save(tutor);	
		animalRepository.saveAll(animais);	
		return "redirect:list";
	}

	@PostMapping("/add-animal")
	public String addTutor(@Valid Tutor tutor, @Valid Animal animal, BindingResult result, Model model) {
		// if (result.hasErrors()) {
		// 	return "add-tutor";
		// }
		animal.setTutor(tutor);
		animais.add(animal);
		// tutorRepository.save(tutor);		
		return "redirect:add-tutor";
	}
	
	@GetMapping("/edit/{codigo}")
	public String showUpdateForm(@PathVariable("codigo") long codigo, Model model) {
		Tutor tutor = tutorRepository.findById(codigo)
				.orElseThrow(() -> new IllegalArgumentException("Código do tutor inválido:" + codigo));

		model.addAttribute("tutor", tutor);
		return "update-tutor";
	}
	
	@PostMapping("/update/{codigo}")
    public String updateTutor(@PathVariable("codigo") long codigo, @Valid Tutor tutor, BindingResult result,
        Model model) {
        if (result.hasErrors()) {
        	tutor.setCodigo(codigo);
            return "update-tutor";
        }

        tutorRepository.save(tutor);
        model.addAttribute("tutores", tutorRepository.findAll());
        return "index";
    }
	
	@GetMapping("/delete/{codigo}")
	public String deleteTutor(@PathVariable("codigo") long codigo, Model model) {
		Tutor tutor = tutorRepository.findById(codigo)
				.orElseThrow(() -> new IllegalArgumentException("Código do tutor inválido:" + codigo));
		
		tutorRepository.delete(tutor);
		model.addAttribute("tutores", tutorRepository.findAll());
		return "index";
	}
}
