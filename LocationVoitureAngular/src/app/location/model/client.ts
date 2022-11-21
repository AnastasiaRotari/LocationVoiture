import { Adresse } from './adresse';
import { Compte } from './compte';

export class Client extends Compte {
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

  constructor(
    _id?: number,
    _nom?: string,
    _prenom?: string,
    _email?: string,
    _adresse?: Adresse,
    private _age?: number,
    private _anneePermis?: number,
    private _accident?: number
  ) {
    super(_id, _nom, _prenom, _email, _adresse);
  }
}
