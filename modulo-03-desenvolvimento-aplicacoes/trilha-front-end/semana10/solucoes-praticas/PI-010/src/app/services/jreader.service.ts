import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class JreaderService {

  jsonPath = '../assets/veiculos.json';

  private catSubject = new Subject<any>();
  private veiSubject = new Subject<any>();
  private propSubject = new Subject<any>();
  private listVeiculos = new Subject<string>();

  constructor(private http: HttpClient) { }

  getJsonVeiculos(): Observable<any> {
    return this.http.get(this.jsonPath);
  }

  setCategoria(categoria: any): void {
    this.catSubject.next(categoria);
  }

  getCategoria(): Observable<any> {
    return this.catSubject.asObservable();
  }

  setVeiculo(veiculo: any): void {
    this.veiSubject.next(veiculo);
  }

  getVeiculo(): Observable<any> {
    return this.veiSubject.asObservable();
  }

  setPropriedade(propriedade: any): void {
    this.propSubject.next(propriedade);
  }

  getPropriedade(): Observable<any> {
    return this.propSubject.asObservable();
  }

  setListVeiculos(veiculo: string): void {
    this.listVeiculos.next(veiculo);
  }

  getListVeiculos(): Observable<string> {
    return this.listVeiculos.asObservable();
  }

}
