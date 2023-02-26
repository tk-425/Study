export class Shape {
  constructor(private _x: number, private _y: number) {}

  public set setX(x: number) {
    this._x = x;
  }

  public set setY(y: number) {
    this._y = y;
  }

  public get x() {
    return this._x;
  }

  public get y() {
    return this._y;
  }

  getInfo(): string {
    return `x=${this._x}, y=${this._y}`;
  }
}