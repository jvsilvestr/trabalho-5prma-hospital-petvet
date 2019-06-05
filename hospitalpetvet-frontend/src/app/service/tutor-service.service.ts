import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Tutor } from '../model/tutor';
 
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class TutorService {
 
  constructor(private http:HttpClient) {}

  private tutorUrl = 'http://localhost:8080/tutor';

  public getTutores() {
    return this.http.get<Tutor[]>(this.tutorUrl);
  }

  public getTutorById(id: number){
    return this.http.get<Tutor>(this.tutorUrl + "/" + id);
  }

  public updateTutor(tutor: Tutor){
    return this.http.put(this.tutorUrl, tutor);
  }

  public deleteTutor(tutor: Tutor) {
    return this.http.delete(this.tutorUrl + "/"+ tutor.codigo);
  }

  public createTutor(tutor: Tutor) {
    return this.http.post<Tutor>(this.tutorUrl, tutor);
}
}