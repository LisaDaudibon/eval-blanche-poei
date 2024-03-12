
import { Component } from '@angular/core';
import { GameService } from '../../services/game.service';
import { Game } from '../../models/game';
import { Router } from '@angular/router';


@Component({
  selector: 'app-new-game',
  templateUrl: './new-game.component.html',
  styleUrl: './new-game.component.css'
})
export class NewGameComponent {
  

  constructor(private gameService: GameService, private router: Router) {

  }

  createAGame (game: Game) {
    this.gameService.createGame(game).subscribe();
    this.router.navigateByUrl("")
  }
}
