import { Adresse } from './adresse';
import { Compte } from './compte';
import { Personne } from './personne';

export class Loueur extends Personne {
  public get compte(): Compte {
    return this._compte;
  }
  public set compte(value: Compte) {
    this._compte = value;
  }
  constructor(
    _id?: number,
    _nom?: string,
    _prenom?: string,
    _adresse?: Adresse,
    private _compte: Compte = new Compte()
  ) {
    super(_id, _nom, _prenom, _adresse);
  }
}
