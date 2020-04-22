
export class Post {
  private _id: bigint;
  private _photo: any;
  private _text: string;
  private _date: string;
  private _place: string;
  private _user_id: bigint;


  constructor(id: bigint, photo: any, text: string, date: string, place: string, user_id: bigint) {
    this._id = id;
    this._photo = photo;
    this._text = text;
    this._date = date;
    this._place = place;
    this._user_id = user_id;
  }

  get id(): bigint {
    return this._id;
  }

  set id(value: bigint) {
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

  get user_id(): bigint {
    return this._user_id;
  }

  set user_id(value: bigint) {
    this._user_id = value;
  }
}
