import { Empresa } from './Empresa.model';
import { TipoContratacao } from './TipoContratacao.model';

export interface Vaga{
  id: number,
  nome: string,
  tipo: TipoContratacao,
  quantidade: number,
  salario: number,
  localizacao: string,
  expiracao: Date,
  empresa: Empresa
}
