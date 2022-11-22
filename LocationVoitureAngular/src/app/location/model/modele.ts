export class Modele {
  public get annee(): string | undefined {
    return this._annee;
  }
  public set annee(value: string | undefined) {
    this._annee = value;
  }
  public get categorie(): string | undefined {
    return this._categorie;
  }
  public set categorie(value: string | undefined) {
    this._categorie = value;
  }
  public get nom(): string | undefined {
    return this._nom;
  }
  public set nom(value: string | undefined) {
    this._nom = value;
  }
  public get id(): number | undefined {
    return this._id;
  }
  public set id(value: number | undefined) {
    this._id = value;
  }

  constructor(
    private _id?: number,
    private _nom?: string,
    private _categorie?: string,
    private _annee?: string
  ) {}
}
