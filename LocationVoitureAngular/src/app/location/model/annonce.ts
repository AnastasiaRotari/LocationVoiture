import { Loueur } from './loueur';
import { Modele } from './modele';

export class Annonce {
  public get disponibilite(): boolean | undefined {
    return this._disponibilite;
  }
  public set disponibilite(value: boolean | undefined) {
    this._disponibilite = value;
  }
  public get prixJour(): number | undefined {
    return this._prixJour;
  }
  public set prixJour(value: number | undefined) {
    this._prixJour = value;
  }
  public get etat(): string | undefined {
    return this._etat;
  }
  public set etat(value: string | undefined) {
    this._etat = value;
  }
  public get agence(): string | undefined {
    return this._agence;
  }
  public set agence(value: string | undefined) {
    this._agence = value;
  }
  public get kilometrage(): number | undefined {
    return this._kilometrage;
  }
  public set kilometrage(value: number | undefined) {
    this._kilometrage = value;
  }
  public get plein(): string | undefined {
    return this._plein;
  }
  public set plein(value: string | undefined) {
    this._plein = value;
  }
  public get loueur(): Loueur | undefined {
    return this._loueur;
  }
  public set loueur(value: Loueur | undefined) {
    this._loueur = value;
  }
  public get modele(): Modele | undefined {
    return this._modele;
  }
  public set modele(value: Modele | undefined) {
    this._modele = value;
  }
  public get libelle(): string | undefined {
    return this._libelle;
  }
  public set libelle(value: string | undefined) {
    this._libelle = value;
  }
  public get id(): number | undefined {
    return this._id;
  }
  public set id(value: number | undefined) {
    this._id = value;
  }
  constructor(
    private _id?: number,
    private _libelle?: string,
    private _modele?: Modele,
    private _loueur?: Loueur,
    private _plein?: string,
    private _kilometrage?: number,
    private _agence?: string,
    private _etat?: string,
    private _prixJour?: number,
    private _disponibilite?: boolean
  ) {}
}
