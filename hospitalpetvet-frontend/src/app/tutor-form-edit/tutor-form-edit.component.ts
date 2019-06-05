import { Component, OnInit } from '@angular/core';
import { switchMap } from 'rxjs/operators';
import { ActivatedRoute, Router } from '@angular/router';
import { TutorService } from '../service/tutor-service.service';
import { Tutor } from '../model/tutor';
import { Observable } from 'rxjs';
import { TutorListComponent } from '../tutor-list/tutor-list.component';
import { Animal } from '../model/animal';

@Component({
  selector: 'app-tutor-form-edit',
  templateUrl: './tutor-form-edit.component.html',
  styleUrls: ['./tutor-form-edit.component.css']
})
export class TutorFormEditComponent implements OnInit {

  tutor: Tutor;
  animal: Animal;
  selectedCodigoTutor: number;

  constructor(private route: ActivatedRoute, private router: Router, private tutorService: TutorService) { 
    this.animal = new Animal();
  }

  onAddAnimal(animal : Animal){
    this.tutor.animais.push(animal);
    this.animal = new Animal();
  }
  
  onUpdate(tutor: Tutor){
    this.tutorService.updateTutor(tutor).subscribe(data =>{
        this.gotoTutorList();
    }); 
  }

  onRemoveAnimal(animal: Animal){
    this.tutor.animais.filter(obj => obj !== animal);
  }

  ngOnInit() {
    this.route.queryParams.subscribe(params =>{
      this.selectedCodigoTutor = params["codigoTutor"];
      this.tutorService.getTutorById(this.selectedCodigoTutor).subscribe(data => {
        this.tutor = data;
        this.tutor.animais = new Array();
      });
    })
  }

  gotoTutorList(){
    this.router.navigate(['/tutor']);
  }
}