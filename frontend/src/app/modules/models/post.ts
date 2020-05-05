import {User} from "./user";

export class Post {
  private _id: number;
  private _photo: any;
  private _text: string;
  private _date: string;
  private _place: string;
  private _user_id: number;
  private _user: User;


  get user(): User {
    return this._user;
  }

  set user(value: User) {
    this._user = value;
  }


  constructor(id: number, photo: any, text: string, date: string,
              place: string, user_id: number, user: User) {
    this._id = id;
    this._photo = photo;
    this._text = text;
    this._date = date;
    this._place = place;
    this._user_id = user_id;
    this._user = user;
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get photo(): any {
    return this._photo;
  }

  set photo(value: any) {
    this._photo = value;
  }

  get text(): string {
    return this._text;
  }

  set text(value: string) {
    this._text = value;
  }

  get date(): string {
    return this._date;
  }

  set date(value: string) {
    this._date = value;
  }

  get place(): string {
    return this._place;
  }

  set place(value: string) {
    this._place = value;
  }

  get user_id(): number {
    return this._user_id;
  }

  set user_id(value: number) {
    this._user_id = value;
  }
}
