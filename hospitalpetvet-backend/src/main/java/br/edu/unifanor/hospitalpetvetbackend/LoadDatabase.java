package br.edu.unifanor.hospitalpetvetbackend;

import lombok.extern.slf4j.Slf4j;

import java.sql.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.edu.unifanor.hospitalpetvetbackend.entity.Animal;
import br.edu.unifanor.hospitalpetvetbackend.entity.Tutor;
import br.edu.unifanor.hospitalpetvetbackend.repository.AnimalRepository;
import br.edu.unifanor.hospitalpetvetbackend.repository.TutorRepository;

@Configuration
@Slf4j
class LoadDatabase {

  @Bean
  CommandLineRunner initDatabase(TutorRepository tutorRepository, AnimalRepository animalRepository) {
    return args -> {
      Tutor tutor;
      Animal animal;
      
      for (int i = 0; i < 5; i++) {
        tutor = getFilledTutor(i);
        log.info("Preloading " + tutorRepository.save(tutor));

        for (int j = 0; j <= i; j++) {
          animal = getFilledAnimal(tutor, j);
          log.info("Preloading " + animalRepository.save(animal));
        }
      }

    };
  }

  Tutor getFilledTutor(int id){
    return new Tutor(0l, "Teste"+id, "12312312312", "1122223333", "teste"+id+"@domain.com", "Estado"+id, "Cidade"+id, "1234512", id, "Complemento"+id, null);
  }

  Animal getFilledAnimal(Tutor tutor, int id){
    return new Animal(0l, tutor, "Animal"+id, new Date(2015, 10, 10), 15.0f);
  }
}