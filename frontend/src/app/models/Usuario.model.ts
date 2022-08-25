export class Usuario {
  id: number
  email: string
  senha?: string
  token: string
  tipo: string
  dataCadastro?: Date
  tipoUsuario: number

  podeCandidatar: boolean;
  podeDivulgar: boolean;
}
