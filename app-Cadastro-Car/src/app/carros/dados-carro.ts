export interface DadosCarroForm {
  model: string;
  brand: string;
  price: number;
  description: string;
  engineVersion: string;
  city: string;
  ownerId: number;
}

export interface DetalhesCarro {
  id: number;
  model: string;
  brand: string;
  price: number;
  description: string;
  engineVersion: string;
  city: string;
  createdDate: string;
  ownerId: number;
  ownerName: string;
  ownerType: string;
  contact: string;
}
