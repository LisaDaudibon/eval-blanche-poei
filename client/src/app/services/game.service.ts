import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Game } from '../models/game';
import { tap } from 'cypress/types/lodash';

@Injectable({
  providedIn: 'root'
})
export class GameService {
  $fetchGames: Observable<Game[]>

  constructor(private _httpClient: HttpClient) {
    this.$fetchGames = this._httpClient.get<Game[]>(`/api/games`)
      // .pipe(
      //   tap((games) => this.games = games)
      // )
   }
}
