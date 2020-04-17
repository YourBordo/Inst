
export class Complaint {
  private _id: bigint;
  private _status: boolean;
  private _text: string;
  private _date: string;
  private _user_id: bigint;


  constructor(id: bigint, status: boolean, text: string, date: string, user_id: bigint) {
    this._id = id;
    this._status = status;
    this._text = text;
    this._date = date;
    this._user_id = user_id;
  }

  get id(): bigint {
    return this._id;
  }

  set id(value: bigint) {
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

  get user_id(): bigint {
    return this._user_id;
  }

  set user_id(value: bigint) {
    this._user_id = value;
  }
}
