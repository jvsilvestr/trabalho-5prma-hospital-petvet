import { Component, OnInit } from '@angular/core';
import { Tutor } from '../model/tutor';
import { TutorService } from '../service/tutor-service.service';
import { ActivatedRoute, Router, NavigationExtras } from '@angular/router';
import { TutorFormEditComponent } from '../tutor-form-edit/tutor-form-edit.component';

@Component({
  selector: 'app-tutor-list',
  templateUrl: './tutor-list.component.html',
  styleUrls: ['./tutor-list.component.css']
})

export class TutorListComponent implements OnInit {

  tutores: Tutor[];

  constructor(private tutorService: TutorService, private router: Router) {
  }

  ngOnInit() {
    this.tutorService.getTutores().subscribe(data => {
      this.tutores = data;
    });
  }

  onCallUpdate(tutor: Tutor){
    let navigationExtras: NavigationExtras = {
        queryParams: {
            "codigoTutor": tutor.codigo
        }
    };
    this.router.navigate(['/updatetutor'], navigationExtras);
  }

  onRemove(tutor: Tutor){
      if(confirm("Você realmente deseja excluir esse registro?")) {
        this.tutorService.deleteTutor(tutor).subscribe(data =>{
          this.tutores = this.tutores.filter(obj => obj !== tutor);
        });
      }    
  }
  
  gotoTutorList(){
    this.router.navigate(['/tutor']);
  }

}
