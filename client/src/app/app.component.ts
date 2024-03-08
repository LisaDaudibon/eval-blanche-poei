import { Component } from '@angular/core';
import { GameService } from './services/game.service';
import { Game } from './models/game';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  $fetchedGames: Observable<Game[]>;
  constructor( private _gameService: GameService) { 
    this.$fetchedGames = this._gameService.$fetchGames
  }

  trackById ( index: string, game: Game): string {
    return game.id;
  }

}
