import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TutorService } from '../service/tutor-service.service';
import { Tutor } from '../model/tutor';
import { Animal } from '../model/animal';

@Component({
  selector: 'app-tutor-form',
  templateUrl: './tutor-form.component.html',
  styleUrls: ['./tutor-form.component.css']
})
export class TutorFormComponent implements OnInit {

  tutor: Tutor;
  animal: Animal;

  constructor(private route: ActivatedRoute, private router: Router, private tutorService: TutorService) { 
    this.tutor = new Tutor();
    this.animal = new Animal();
  }

  ngOnInit() {
  }

  onSubmit() {
    this.tutorService.createTutor(this.tutor).subscribe(result => this.gotoTutorList());
  }

  onAddAnimal(animal : Animal){
    this.tutor.animais.push(animal);
    this.animal = new Animal();
  }

  onUpdateAnimal(animal: Animal){

  }

  onRemoveAnimal(animal: Animal){
    this.tutor.animais.filter(obj => obj !== animal);
  }

  gotoTutorList(){
    this.router.navigate(['/tutor']);
  }

}
