import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { Game } from '../../models/game';
import { GameService } from '../../services/game.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  $fetchedGames: Observable<Game[]>;
  $fetchedGame: Observable<Game>;

  constructor( private _gameService: GameService) { 
    this.$fetchedGames = this._gameService.$fetchGames
    this.$fetchedGame = this._gameService.fetchGameById('e40f7f5b-beda-4025-97d8-d047f5806083')
  }

  trackById ( index: number, game: Game): string {
    return game.id;
  }
}