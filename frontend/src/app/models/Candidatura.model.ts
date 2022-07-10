import { Candidato } from './Candidato.model';
import { Vaga } from './Vagas.model';

export class Candidatura {
  id: number
  candidato: Candidato
  vaga: Vaga
  dataCandidatura: Date
  status: number
}
