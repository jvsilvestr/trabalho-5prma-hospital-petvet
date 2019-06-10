import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Animal } from '../model/animal';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root',
})
export class AnimalService {

  constructor(private http: HttpClient) { }

  private animalUrl = "http://localhost:8080/animal";

  public getAnimais() {
    return this.http.get<Animal[]>(this.animalUrl);
  }

  public getAnimalById(id: number){
    return this.http.get<Animal>(this.animalUrl + "/" + id);
  }

  public getAnimalByTutorId(id: number){
    return this.http.get<Animal[]>(this.animalUrl + "/tutor/" + id);
  }

  public updateAnimal(animal: Animal){
    return this.http.put(this.animalUrl, animal);
  }

  public deleteAnimal(animal: Animal) {
    return this.http.delete(this.animalUrl + "/"+ animal.codigo);
  }

  public createAnimal(animal: Animal) {
    return this.http.post<Animal>(this.animalUrl, animal);
  }

}
