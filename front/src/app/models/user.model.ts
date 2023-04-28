import { IUser } from "./interfaces/user.interface";

export class User implements IUser{
  id: string; // UUIDs se representan como cadenas en JavaScript
  username: string;
  password: string;
  role: string;

  constructor(id: string, username: string, password: string, role: string) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.role = role;
  }
}
