import { Empresa } from './Empresa.model';

export class Vaga{
  id: number
  nome: string
  tipo: number
  quantidade: number
  salario: number
  localizacao: string
  dataCadastro: Date
  dataAlteracao: Date
  descricao: string
  beneficios: string
  requisitos: string
  empresa: Empresa
  status: number
  qtdCandidatos: number;
}
