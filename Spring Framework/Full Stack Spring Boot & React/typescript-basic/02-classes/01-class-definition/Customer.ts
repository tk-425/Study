export class Customer {

  constructor(private _firstName: string, private _lastName: string) {}

  public get firstName(): string {
    return this._firstName;
  }

  public get lastName(): string {
    return this._lastName;
  }

  public set setFirstName(firstName: string) {
    this._firstName = firstName;
  }

  public set setLastName(lastName: string) {
    this._lastName = lastName;
  }
}