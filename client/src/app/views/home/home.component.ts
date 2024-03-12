import { Component } from '@angular/core';
import { Observable, take, tap } from 'rxjs';
import { Game } from '../../models/game';
import { GameService } from '../../services/game.service';
import { Router } from '@angular/router';
import { RoundService } from '../../services/round.service';
import { Round } from '../../models/round';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  $fetchedGames: Observable<Game[]>;
  roundId!: string;
  roundState!:string;
  $fetchedRounds: Observable<Round[]>;
  

  constructor( private _gameService: GameService, private _roundService: RoundService, private _router: Router) { 
    this.$fetchedGames = this._gameService.$fetchGames
    this.$fetchedRounds = this._roundService.$fetchRounds
  }

  trackByGameId ( index: number, game: Game): string {
    return game.id;
  }

  trackByRoundId ( index: number, round: Round): string {
    return round.id;
  }
  
  launchAGame (gameId: string): void{
    this._gameService.createRoundById(gameId).subscribe(playId => {
      this.roundId = playId;
      console.log(this.roundId);
      this._router.navigateByUrl(`rounds/${this.roundId}`);
      }
    )
  }

  redirectToRound(roundId: string): void {
    this._roundService.fetchRound(roundId).subscribe(round => {
      this.roundState = round.state;
      if (this.roundState === "ONGOING"){
        this._router.navigateByUrl(`rounds/${roundId}`)
      }
    })
  }
}
