import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { TutorListComponent } from './tutor-list/tutor-list.component';
import { TutorFormComponent } from './tutor-form/tutor-form.component';
import { TutorFormEditComponent } from './tutor-form-edit/tutor-form-edit.component'
import { TutorService } from './service/tutor-service.service';

@NgModule({
  declarations: [
    AppComponent,
    TutorListComponent,
    TutorFormComponent,
    TutorFormEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [TutorService],
  bootstrap: [AppComponent]
})
export class AppModule { }
