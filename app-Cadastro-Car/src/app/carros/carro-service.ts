import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { DadosCarroForm, DetalhesCarro } from './dados-carro';

@Injectable({
  providedIn: 'root',
})
export class CarroService {
  private http = inject(HttpClient);
  private baseUrl = 'http://localhost:8085/api/car';

  cadastrar(dados: DadosCarroForm): Observable<void> {
    return this.http.post<void>(`${this.baseUrl}/post`, dados);
  }

  listar(): Observable<DetalhesCarro[]> {
    return this.http.get<DetalhesCarro[]>(`${this.baseUrl}/posts`);
  }
}
