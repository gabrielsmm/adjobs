import { Vaga } from './vaga.model';
import { Candidato } from './Candidato.model';

export class Candidatura {
  id: number
  candidato: Candidato
  vaga: Vaga
  dataCandidatura: Date
  status: number
}
