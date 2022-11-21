import { Adresse } from './adresse';
import { Compte } from './compte';
import { Personne } from './personne';

export class Client extends Personne {
  public get accident(): number | undefined {
    return this._accident;
  }
  public set accident(value: number | undefined) {
    this._accident = value;
  }

  public get anneePermis(): number | undefined {
    return this._anneePermis;
  }
  public set anneePermis(value: number | undefined) {
    this._anneePermis = value;
  }
  public get age(): number | undefined {
    return this._age;
  }
  public set age(value: number | undefined) {
    this._age = value;
  }
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
    private _age?: number,
    private _anneePermis?: number,

    private _accident?: number,
    private _compte: Compte = new Compte()
  ) {
    super(_id, _nom, _prenom, _adresse);
  }
}
