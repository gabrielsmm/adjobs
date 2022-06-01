import { CurriculoExperiencia } from './CurriculoExperiencia.model';
import { CurriculoFormacao } from './CurriculoFormacao.model';
import { Candidato } from './Candidato.model';

export interface Curriculo {
  id: number,
  candidato: Candidato,
  nome: string,
  resumo?: string,
  telefone?: string,
  telefoneCelular?: string,
  dataNascimento?: Date,
  estadoCivil?: number,
  sexo?: number,
  cep?: string,
  estado?: string,
  cidade?: string,
  bairro?: string,
  rua?: string,
  numero?: string,
  complemento?: string,
  pessoaComDeficiencia?: boolean,
  formacoes?: CurriculoFormacao[],
  experiencias?: CurriculoExperiencia[]
  linkedIn?: string,
  facebook?: string,
  instagram?: string,
  site?: string;
}
