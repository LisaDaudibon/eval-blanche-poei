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
  roundId!: string;

  constructor( private _gameService: GameService, private _roundService: RoundService, private _router: Router) { 
    this.$fetchedGames = this._gameService.$fetchGames
    this.$fetchedGame = this._gameService.fetchGameById('e40f7f5b-beda-4025-97d8-d047f5806083')
  }

  trackByGameId ( index: number, game: Game): string {
    return game.id;
  }
  launchAGame (gameId: string): void{
    this._gameService.createRoundById(gameId).subscribe(playId => {
      this.roundId = playId;
      console.log(this.roundId);
      this._router.navigateByUrl(`rounds/${this.roundId}`);
      }
    )
  }
}
