import { Component, OnInit, inject } from '@angular/core';
import {
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators
} from '@angular/forms';
import { CarroService } from '../carro-service';
import { DadosCarroForm } from '../dados-carro';

interface CadastroCarroForm {
  model: FormControl<string>;
  brand: FormControl<string>;
  price: FormControl<number>;
  description: FormControl<string>;
  engineVersion: FormControl<string>;
  city: FormControl<string>;
  ownerId: FormControl<number>;
}

@Component({
  selector: 'app-cadastro-carro',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './cadastro-carro.html',
  styleUrl: './cadastro-carro.scss',
})
export class CadastroCarro implements OnInit {
  private carroService = inject(CarroService);

  form!: FormGroup<CadastroCarroForm>;

  ngOnInit(): void {
    this.form = new FormGroup<CadastroCarroForm>({
      model: new FormControl('', {
        nonNullable: true,
        validators: [Validators.required]
      }),
      brand: new FormControl('', {
        nonNullable: true,
        validators: [Validators.required]
      }),
      price: new FormControl(0, {
        nonNullable: true,
        validators: [Validators.required, Validators.min(0.01)]
      }),
      description: new FormControl('', {
        nonNullable: true,
        validators: [Validators.required]
      }),
      engineVersion: new FormControl('', {
        nonNullable: true,
        validators: [Validators.required]
      }),
      city: new FormControl('', {
        nonNullable: true,
        validators: [Validators.required]
      }),
      ownerId: new FormControl(0, {
        nonNullable: true,
        validators: [Validators.required, Validators.min(1)]
      })
    });
  }

  handleSubmit(): void {
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }


    const dados: DadosCarroForm = this.form.getRawValue();


    this.carroService.cadastrar(dados).subscribe({
      next: () => {
        console.log('Carro cadastrado com sucesso.');
        this.form.reset();
      },
      error: (erro) => {
        console.error('Erro ao cadastrar o carro:', erro);
      }
    });
  }
}
