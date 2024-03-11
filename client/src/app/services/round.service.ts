import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Round } from '../models/round';

@Injectable({
  providedIn: 'root'
})
export class RoundService {
  $fetchRounds: Observable<Round[]>

  constructor(private _httpClient: HttpClient) {
    this.$fetchRounds = this._httpClient.get<Round[]>(`/api/rounds`)
  }

  fetchRound (roundId: string) {
    return this._httpClient.get<Round>(`/api/rounds/${roundId}`)
  }
}
