import { Routes } from '@angular/router';
import { Template } from './template/template';
import { CadastroUsuario } from './usuario/cadastro-usuario/cadastro-usuario';
import { CadastroCarro } from './carros/cadastro-carro/cadastro-carro';
import { ListagemCarros } from './carros/listagem-carros/listagem-carros';

export const routes: Routes = [
  {
    path: 'paginas',
    component: Template,
    children:[
      {
        path: 'cadastro-usuarios',
        component: CadastroUsuario
      },
      {
        path: 'cadastro-carros',
        component: CadastroCarro
      },
      {
        path: 'listagem-carros',
        component: ListagemCarros
      }
    ]
  }
];
