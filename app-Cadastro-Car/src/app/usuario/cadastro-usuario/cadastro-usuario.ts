import { Component, OnInit, inject } from '@angular/core';
import {
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators
} from '@angular/forms';
import { UsuarioService } from '../usuario-service';
import { DadosUsuarioForm } from '../dados-usuario';

interface CadastroUsuarioForm {
  name: FormControl<string>;
  type: FormControl<string>;
  contactNumber: FormControl<string>;
}

@Component({
  selector: 'app-cadastro-usuario',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './cadastro-usuario.html',
  styleUrl: './cadastro-usuario.scss',
})
export class CadastroUsuario implements OnInit {
  private usuarioService = inject(UsuarioService);

  form!: FormGroup<CadastroUsuarioForm>;

  ngOnInit(): void {
    this.form = new FormGroup<CadastroUsuarioForm>({
      name: new FormControl('', {
        nonNullable: true,
        validators: [Validators.required]
      }),
      type: new FormControl('', {
        nonNullable: true,
        validators: [Validators.required]
      }),
      contactNumber: new FormControl('', {
        nonNullable: true,
        validators: [Validators.required]
      })
    });
  }

  handleSubmit(): void {
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }

    const dados: DadosUsuarioForm = this.form.getRawValue();

    this.usuarioService.cadastrar(dados).subscribe({
      next: () => {
        console.log('Usuário cadastrado com sucesso.');
        this.form.reset();
      },
      error: (erro) => {
        console.error('Erro ao cadastrar usuário:', erro);
      }
    });
  }
}
