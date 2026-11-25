import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { DadosUsuarioForm } from './dados-usuario';

@Injectable({
  providedIn: 'root',
})
export class UsuarioService {
  private http = inject(HttpClient);
  private url = 'http://localhost:8085/owner';

  cadastrar(dados: DadosUsuarioForm): Observable<void> {
    return this.http.post<void>(this.url, dados);
  }
}
