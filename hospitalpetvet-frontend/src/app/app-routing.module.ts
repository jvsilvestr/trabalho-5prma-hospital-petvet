import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TutorListComponent } from './tutor-list/tutor-list.component';
import { TutorFormComponent } from './tutor-form/tutor-form.component';
import { TutorFormEditComponent } from './tutor-form-edit/tutor-form-edit.component';

const routes: Routes = [
  { path: 'tutor', component: TutorListComponent },
  { path: 'addtutor', component: TutorFormComponent },
  { path: 'updatetutor', component: TutorFormEditComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
