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
@RequestMapping({"tutor"})
@CrossOrigin(origins = "http://localhost:4200")
public class TutorController {

    private final TutorRepository tutorRepository;
    private final AnimalRepository animalRepository;

    @Autowired
    public TutorController(TutorRepository tutorRepository, AnimalRepository animalRepository){
        this.tutorRepository = tutorRepository;
        this.animalRepository = animalRepository;
    }

    @PostMapping
    public Tutor create(@RequestBody Tutor tutor) {
        Tutor tutorReturn = tutorRepository.save(tutor);
        for (Animal animal : tutor.getAnimais()){
            animal.setTutor(tutor);
            animalRepository.save(animal);
        }
        return tutorReturn;
    }

    @GetMapping("/{codigo}")
    public Tutor findOne(@PathVariable("codigo") long codigo) {
        Tutor tutor;
        tutor = tutorRepository.findById(codigo).get();
        tutor.setAnimais(animalRepository.findAllByTutor(tutor));
        return tutor;
    }

    @PutMapping
    public Tutor update(@RequestBody Tutor tutor) {
        Tutor tutorReturn = tutorRepository.save(tutor);
        if(tutor.getAnimais() != null) {
            for (Animal animal : tutor.getAnimais()) {
                animal.setTutor(tutor);
                animalRepository.save(animal);
            }
        }
        return tutorReturn;
    }

    @DeleteMapping("/{codigo}")
    public Tutor delete(@PathVariable("codigo") long codigo) {
        Tutor tutor = tutorRepository.findById(codigo).get();
        if (tutor != null){
            List<Animal> animaisTutor = animalRepository.findAllByTutor(tutor);
            if (animaisTutor != null)
                animalRepository.deleteAll(animaisTutor);
            tutorRepository.delete(tutor);
        }
        return tutor;
    }

    @GetMapping
    public List<Tutor> findAll() {
        List<Tutor> tutores = (List<Tutor>) tutorRepository.findAll();
        for (Tutor tutor : tutores) {
            tutor.setAnimais(animalRepository.findAllByTutor(tutor));
        }
        return tutores;
    }

}