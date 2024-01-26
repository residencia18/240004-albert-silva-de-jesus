import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BuscaApiService {

  private api = 'https://en.wikipedia.org/w/api.php?action=parse&page=Pet_door&format=json'

  constructor(private http: HttpClient) {
  }

  busca(titulo: string): Observable<any> {
    return this.http.get<any>(this.api);
  }

}