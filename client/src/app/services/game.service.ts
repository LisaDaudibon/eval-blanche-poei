import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Game } from '../models/game';
import { tap } from 'cypress/types/lodash';
import { Round } from '../models/round';

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

  fetchGameById (gameId : string): Observable<Game> {
    return this._httpClient.get<Game>(`/api/games/${gameId}`)
  }

  createRoundById (gameId: string): Observable<string> {
    return this._httpClient.post<string>(`/api/games/${gameId}/rounds`, {})
  }

  createGame (game: Game): Observable<Game> {
    return this._httpClient.post<Game>(`/api/games`, game)
  }
}
