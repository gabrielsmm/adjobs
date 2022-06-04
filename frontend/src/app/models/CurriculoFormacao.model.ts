import { Curriculo } from './Curriculo.model';

export class CurriculoFormacao {
  id: number
  nomeInstituicao?: string
  nivel?: number
  status?: number
  curso?: string
  mesInicio?: number
  anoInicio?: number
  mesConclusao?: number
  anoConclusao?: number
  curriculo: Curriculo
}
