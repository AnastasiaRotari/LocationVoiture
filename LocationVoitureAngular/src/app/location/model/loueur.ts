import { Adresse } from './adresse';
import { Compte } from './compte';

export class Loueur extends Compte {
  constructor(
    _id?: number,
    _nom?: string,
    _prenom?: string,
    _email?: string,
    _adresse?: Adresse
  ) {
    super(_id, _nom, _prenom, _email, _adresse);
  }
}
