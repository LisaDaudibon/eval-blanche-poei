import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../models/user';
import { BehaviorSubject, catchError, tap } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class UserService {

  readonly SESSION_TOKEN = 'SESSION'
  userLogged = new BehaviorSubject<User | null>(null)

  constructor(private _httpClient: HttpClient) {
    const savedSession = sessionStorage.getItem(this.SESSION_TOKEN)
    if (savedSession) {
      try {
        this.userLogged.next(JSON.parse(savedSession))
      } catch { }
    }
  }

  logout() {
    // clear le session storage
    sessionStorage.removeItem(this.SESSION_TOKEN)
    this.userLogged.next(null)
  }

  createUser(user: { username: string; password: string; }) {
    return this._httpClient.post<void>(`/api/users`, user)
  }

  login({ username, password }: { username: string; password: string; }) {
    // On test de se connecter avec le username / password

    const basicAuthString = btoa(`${username}:${password}`)

    return this._httpClient.post<void>(`/api/users/login`, {}, {
      headers: {
        Authorization: 'Basic ' + basicAuthString
      }
    }).pipe(
      tap(() => {
        sessionStorage.setItem(this.SESSION_TOKEN, JSON.stringify({ username, basicAuth: basicAuthString }))
        this.userLogged.next({ username, basicAuth: basicAuthString })
      }),
      catchError(error => {
        console.error(error);
        throw error
      })
    )
  }
}
