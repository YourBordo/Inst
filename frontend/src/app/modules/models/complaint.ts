
export class Complaint {
  private _id: number;
  private _status: boolean;
  private _text: string;
  private _date: string;
  private _user_id: number;


  constructor(id: number, status: boolean, text: string, date: string, user_id: number) {
    this._id = id;
    this._status = status;
    this._text = text;
    this._date = date;
    this._user_id = user_id;
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get status(): boolean {
    return this._status;
  }

  set status(value: boolean) {
    this._status = value;
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

  get user_id(): number {
    return this._user_id;
  }

  set user_id(value: number) {
    this._user_id = value;
  }
}
