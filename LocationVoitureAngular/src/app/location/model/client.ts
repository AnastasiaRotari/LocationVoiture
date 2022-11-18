import { Adresse } from './adresse';
import { Compte } from './compte';
import { Personne } from './personne';

export class Client extends Personne {
  public get compte(): Compte {
    return this._compte;
  }
  public set compte(value: Compte) {
    this._compte = value;
  }
  public get naissance(): Date | undefined {
    return this._naissance;
  }
  public set naissance(value: Date | undefined) {
    this._naissance = value;
  }
  constructor(
    _id?: number,
    _nom?: string,
    _prenom?: string,
    _adresse?: Adresse,
    private _naissance?: Date,
    private _compte: Compte = new Compte()
  ) {
    super(_id, _nom, _prenom, _adresse);
  }
}
