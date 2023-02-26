import { Shape } from "./Shape";

export class Rectangle extends Shape {

  constructor(x: number, y: number, private _width: number, private _length: number) {
    super(x, y);
  }

  public set setWidth(width: number) {
    this._width = width;
  }

  public set setLength(length: number) {
    this._length = length;
  }

  public get width() {
    return this._width;
  }

  public get length() {
    return this._length;
  }

  getInfo(): string {
      return super.getInfo() + `, width=${this._width}, length=${this._length}`;
  }
}