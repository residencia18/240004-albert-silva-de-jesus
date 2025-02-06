import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BuscaApiService {

  private resultadoApi: any;

  constructor(private http: HttpClient) {
  }

  setResultadoApi(resultado: any): void {
    this.resultadoApi = resultado;
  }

  buscaService(titulo: string): Observable<any> {
    return this.http.get<any>(`https://en.wikipedia.org/w/api.php?action=parse&page=${titulo}&format=json&origin=*`);
  }

}