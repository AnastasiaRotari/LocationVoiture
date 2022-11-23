import { Annonce } from './annonce';
import { Client } from './client';

export class Location {
  public get client(): Client | undefined {
    return this._client;
  }
  public set client(value: Client | undefined) {
    this._client = value;
  }
  public get annonce(): Annonce | undefined {
    return this._annonce;
  }
  public set annonce(value: Annonce | undefined) {
    this._annonce = value;
  }
  public get assurance(): string | undefined {
    return this._assurance;
  }
  public set assurance(value: string | undefined) {
    this._assurance = value;
  }
  public get prixTotal(): number | undefined {
    return this._prixTotal;
  }
  public set prixTotal(value: number | undefined) {
    this._prixTotal = value;
  }
  public get dateFin(): Date | undefined {
    return this._dateFin;
  }
  public set dateFin(value: Date | undefined) {
    this._dateFin = value;
  }
  public get dateDebut(): Date | undefined {
    return this._dateDebut;
  }
  public set dateDebut(value: Date | undefined) {
    this._dateDebut = value;
  }
  public get id(): number | undefined {
    return this._id;
  }
  public set id(value: number | undefined) {
    this._id = value;
  }

  constructor(
    private _id?: number,
    private _dateDebut?: Date,
    private _dateFin?: Date,
    private _prixTotal?: number,
    private _assurance?: string,
    private _annonce?: Annonce,
    private _client?: Client
  ) {}
}
