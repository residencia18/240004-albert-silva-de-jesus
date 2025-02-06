import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, map, throwError } from 'rxjs';
import { type_atendimento } from '../../types/atendimento';

@Injectable({
  providedIn: 'root'
})
export class CrudService {

  constructor(private http: HttpClient) { }

  addAtendimento(newAtendimento: type_atendimento) {

    this.http.post('https://residenciatic18-pet-shop-default-rtdb.firebaseio.com/posts.json', newAtendimento)
      .pipe(
        catchError(error => {
          console.error(error);
          alert('Ocorreu um erro ao buscar o atendimento. Por favor, tente novamente.');
          return throwError(error);
        })
      ).subscribe(responseData => {
        console.log(responseData);
        alert('Atendimento cadastrado com sucesso!');
      });
  }

  getAtendimento() {

    return this.http.get<{ [key: string]: type_atendimento }>('https://residenciatic18-pet-shop-default-rtdb.firebaseio.com/posts.json',
      {
        params: new HttpParams().set('print', 'pretty')
      }
    ).pipe(
      catchError(error => {
        console.error(error);
        alert('Ocorreu um erro ao buscar o atendimento. Por favor, tente novamente.');
        return throwError(error);
      }), map((responseData: { [x: string]: any; }) => {
        // Convertendo o objeto de resposta em um array de objetos
        if (responseData) {
          return Object.keys(responseData).map(key => ({ id: key, ...responseData[key] }));
        } else {
          return [];
        }
      })
    )

  }

  getAtendimentoById(atend_id: string) {

    return this.http.get<type_atendimento>(`https://residenciatic18-pet-shop-default-rtdb.firebaseio.com/posts/${atend_id}.json`,
      {
        params: new HttpParams().set('print', 'pretty')
      }
    ).pipe(
      catchError(error => {
        console.error(error);
        alert('Ocorreu um erro ao buscar o atendimento. Por favor, tente novamente.');
        return throwError(error);
      }),
      map((responseData: type_atendimento) => {
        // Convertendo o objeto de resposta em um array de objetos

        return responseData as type_atendimento;

      })
    )

  }

  apagarTodosAtendimentos() {
    return this.http.delete('https://residenciatic18-pet-shop-default-rtdb.firebaseio.com/posts.json');
  }

  apagarAtendimentoById(atendimentoId: string) {
    const url = `https://residenciatic18-pet-shop-default-rtdb.firebaseio.com/posts/${atendimentoId}.json`;
    this.http.delete(url).pipe(
      catchError(error => {
        console.error(error);
        alert('Ocorreu um erro ao excluir o atendimento. Por favor, tente novamente.');
        return throwError(error);
      })
    ).subscribe(responseData => {
      alert('Atendimento excluído com sucesso!');
      setTimeout(() => {

        window.location.reload()
      }, 3000)
    });
  }


  editarAtendimento(id: string, newAtendimento: type_atendimento) {
    return this.http.put(`https://residenciatic18-pet-shop-default-rtdb.firebaseio.com/posts/${id}.json`, newAtendimento, { observe: 'response' })
      .pipe(
        catchError(error => {
          console.error(error);
          alert('Ocorreu um erro ao editar o atendimento. Por favor, tente novamente.');
          return throwError(error);
        })
      ).subscribe(responseData => {
        console.log(responseData);
        alert('Atendimento editado com sucesso!');
      });
  }

}