import { Cargo } from './Cargo.model';

export class Candidato {
  id?: number
  nome: string
  cep: string
  cargo: Cargo
  email: string
  senha: string
  dataCadastro: Date
  tipoUsuario: string

  constructor() {
    this.cargo = new Cargo();
  }
}
