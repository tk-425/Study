import { Shape } from './Shape';

export class Circle extends Shape {

  constructor(x: number, y: number, private _radius: number) {
    super(x, y);
  }

  public set setRadius(radius: number) {
    this._radius = radius;
  }

  public get radius() {
    return this._radius;
  }

  getInfo(): string {
    return super.getInfo() + `, radius=${this._radius}`;
  }

  calculateArea(): number {
      return Math.PI * Math.pow(this._radius, 2);
  }
}