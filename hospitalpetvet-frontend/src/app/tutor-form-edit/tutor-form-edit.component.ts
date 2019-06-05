import { Component, OnInit } from '@angular/core';
import { switchMap } from 'rxjs/operators';
import { ActivatedRoute, Router } from '@angular/router';
import { TutorService } from '../service/tutor-service.service';
import { Tutor } from '../model/tutor';
import { Observable } from 'rxjs';
import { TutorListComponent } from '../tutor-list/tutor-list.component';

@Component({
  selector: 'app-tutor-form-edit',
  templateUrl: './tutor-form-edit.component.html',
  styleUrls: ['./tutor-form-edit.component.css']
})
export class TutorFormEditComponent implements OnInit {

  tutor: Tutor
  selectedCodigoTutor: number;

  constructor(private route: ActivatedRoute, private router: Router, private tutorService: TutorService) { 
  }

  onUpdate(tutor: Tutor){
    this.tutorService.updateTutor(tutor).subscribe(data =>{
        this.gotoTutorList();
    }); 
  }

  ngOnInit() {
    this.route.queryParams.subscribe(params =>{
      this.selectedCodigoTutor = params["codigoTutor"];
      this.tutorService.getTutorById(this.selectedCodigoTutor).subscribe(data => {
        this.tutor = data;
      });
    })
  }

  gotoTutorList(){
    this.router.navigate(['/tutor']);
  }
}