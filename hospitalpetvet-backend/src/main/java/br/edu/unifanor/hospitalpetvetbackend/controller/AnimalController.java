package br.edu.unifanor.hospitalpetvetbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unifanor.hospitalpetvetbackend.entity.Animal;
import br.edu.unifanor.hospitalpetvetbackend.entity.Tutor;
import br.edu.unifanor.hospitalpetvetbackend.repository.AnimalRepository;
import br.edu.unifanor.hospitalpetvetbackend.repository.TutorRepository;

@RestController
@RequestMapping("/animal")
@CrossOrigin(origins = "http://localhost:4200")
public class AnimalController {

    private final AnimalRepository animalRepository;
    private final TutorRepository tutorRepository;

    @Autowired
    public AnimalController(AnimalRepository animalRepository, TutorRepository tutorRepository) {
        this.animalRepository = animalRepository;
        this.tutorRepository = tutorRepository;
    }

    @GetMapping
    public List<Animal> findAll() {
        return (List<Animal>) animalRepository.findAll();
    }

    @GetMapping("/tutor/{codigo}")
    public List<Animal> findAllByTutor(@PathVariable("codigo") Long codigo) {
        Tutor tutor = tutorRepository.findById(codigo).get();
        return (List<Animal>) animalRepository.findAllByTutor(tutor);
    }

    @PostMapping
    public Animal create(@RequestBody Animal animal) {
        return animalRepository.save(animal);
    }

    @GetMapping("/{codigo}")
    public Animal findOne(@PathVariable("codigo") Long codigo) {
        return animalRepository.findById(codigo).get();
    }

    @PutMapping
    public Animal update(@RequestBody Animal animal) {
        return animalRepository.save(animal);
    }

    @DeleteMapping("/{codigo}")
    public Animal delete(@PathVariable("codigo") Long codigo) {
        Animal animal = animalRepository.findById(codigo).get();
        animalRepository.delete(animal);
        return animal;
    }
}