import { Adresse } from './adresse';

export class Compte {
  public get email(): string | undefined {
    return this._email;
  }
  public set email(value: string | undefined) {
    this._email = value;
  }
  public get id(): number | undefined {
    return this._id;
  }
  public set id(value: number | undefined) {
    this._id = value;
  }
  public get adresse(): Adresse | undefined {
    if (!this._adresse) {
      this._adresse = new Adresse();
    }
    return this._adresse;
  }
  public set adresse(value: Adresse | undefined) {
    this._adresse = value;
  }
  public get prenom(): string | undefined {
    return this._prenom;
  }
  public set prenom(value: string | undefined) {
    this._prenom = value;
  }
  public get nom(): string | undefined {
    return this._nom;
  }
  public set nom(value: string | undefined) {
    this._nom = value;
  }

  constructor(
    private _id?: number,
    private _email?: string,
    private _nom?: string,
    private _prenom?: string,
    private _adresse?: Adresse
  ) {}
}
