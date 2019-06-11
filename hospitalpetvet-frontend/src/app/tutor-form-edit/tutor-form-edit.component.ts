import { Component, OnInit } from '@angular/core';
// import { switchMap } from 'rxjs/operators';
import { ActivatedRoute, Router } from '@angular/router';
import { TutorService } from '../service/tutor-service.service';
import { Tutor } from '../model/tutor';
// import { Observable } from 'rxjs';
// import { TutorListComponent } from '../tutor-list/tutor-list.component';
import { Animal } from '../model/animal';
import { AnimalService } from '../service/animal-service.service';

@Component({
  selector: 'app-tutor-form-edit',
  templateUrl: './tutor-form-edit.component.html',
  styleUrls: ['./tutor-form-edit.component.css']
})
export class TutorFormEditComponent implements OnInit {

  tutor: Tutor;
  animal: Animal;
  selectedCodigoTutor: number;

  constructor(private route: ActivatedRoute, private router: Router, private tutorService: TutorService,
              private animalService: AnimalService) { 
    this.animal = new Animal();
  }

  onAddAnimal(animal : Animal){
    this.tutor.animais.push(animal);
    this.animal = new Animal();
  }
  
  onUpdate(tutor: Tutor){

    this.tutorService.updateTutor(tutor).subscribe(data =>{
      var animais = new Array<Animal>();

      /* Obtêm os animais cadastrados para o tutor */
      this.animalService.getAnimalByTutorId(Number.parseInt(tutor.codigo)).subscribe(data => {
        animais = data;
      });

      /* Se a lista não tiver nenhum animal, remove todos */
      if (tutor.animais == null || tutor.animais.length == 0){
        animais.forEach((animal: Animal) => {
          this.animalService.deleteAnimal(animal);
        });
      }else{
        tutor.animais.forEach((animal: Animal) => {
          /* Se o registro não possuir um código, cria o registro */
          if (animal.codigo == 0){
            this.animalService.createAnimal(animal).subscribe((animalAux:Animal) => {
              animal.codigo = animalAux.codigo;
            });
          /* Verifica se o registro foi eliminado, se sim, elimina do banco */  
          }else{
            var index = animais.findIndex((animalAux:Animal) => { 
              if (animalAux.codigo == animal.codigo)
                return true;
              else
                return false;
            });
            if (index <= -1)
              this.animalService.deleteAnimal(animal).subscribe();
            else 
              this.animalService.updateAnimal(animal).subscribe();
          }
        });
      }
      this.gotoTutorList();
    }); 
  }

  onRemoveAnimal(animal: Animal){
    const index: number = this.tutor.animais.indexOf(animal);
    if (index !== -1) 
        this.tutor.animais.splice(index, 1); 
  }

  ngOnInit() {
    this.route.queryParams.subscribe(params =>{
      this.selectedCodigoTutor = params["codigoTutor"];
      this.tutorService.getTutorById(this.selectedCodigoTutor).subscribe(data => {
        this.tutor = data;
        // this.tutor.animais = new Array();
      });
    })
  }

  gotoTutorList(){
    this.router.navigate(['/tutor']);
  }
}