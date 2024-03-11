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
  $fetchedGame: Observable<Game>;
  roundId!: string;
  roundState!:string;
  $fetchedRounds: Observable<Round[]>;
  

  constructor( private _gameService: GameService, private _roundService: RoundService, private _router: Router) { 
    this.$fetchedGames = this._gameService.$fetchGames
    this.$fetchedGame = this._gameService.fetchGameById('e40f7f5b-beda-4025-97d8-d047f5806083');
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


  // launchAGame (gameId: string) : Promise<boolean> {
  //   // let roundCreated: Round;
  //   // this._gameService.createRoundById(gameId)
  //   // this.$fetchedRound.pipe(
  //   //   tap((round) => roundCreated = round)
  //   // )
  //   let roundCreatedId: string ="";
  //   this._gameService.createRoundById(gameId)
  //     .pipe(tap((round) => roundCreatedId = round))
  //   let roundCreated: Round;
  //   this._roundService.fetchRound(roundCreatedId)
  //     .pipe(tap((round) => roundCreated = round))
    
  //   return this.router.navigateByUrl(`/api/round/${roundCreated.id}`)
  // }
}
