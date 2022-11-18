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
  constructor(private _id?: number, private _email?: string) {}
}
