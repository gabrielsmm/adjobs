export interface CurriculoExperiencia {
  id: number,
  nomeEmpresa?: string,
  cargo?: string,
  salario?: number,
  mesInicio?: number,
  anoInicio?: number,
  mesConclusao?: number,
  anoConclusao?: number,
  atual?: boolean,
  descricao?: string;
}
