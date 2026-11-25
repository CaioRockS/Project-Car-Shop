import { AsyncPipe } from '@angular/common';
import { Component, inject, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { CarroService } from '../carro-service';
import { DetalhesCarro } from '../dados-carro';

@Component({
  selector: 'app-listagem-carros',
  standalone: true,
  imports: [AsyncPipe],
  templateUrl: './listagem-carros.html',
  styleUrl: './listagem-carros.scss',
})
export class ListagemCarros implements OnInit {
  private service = inject(CarroService);

  listagem$!: Observable<DetalhesCarro[]>;

  ngOnInit(): void {
    this.listarCarros();
  }

  listarCarros(): void {
    this.listagem$ = this.service.listar();
  }
}
