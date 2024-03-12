import { Component } from '@angular/core';
import { RoundService } from '../../services/round.service';
import { ActivatedRoute } from '@angular/router';
import { Round } from '../../models/round';
import { Subscription, take } from 'rxjs';

const AZERTY_KEYBOARD = ['A', 'Z', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'Q', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'W', 'X', 'C', 'V', 'B', 'N']
@Component({
  selector: 'app-game-board',
  templateUrl: './game-board.component.html',
  styleUrl: './game-board.component.css'
})
export class GameBoardComponent {
  private _paramsSubscription: Subscription;
  private _roundId!: string;
  round?: Round;


  firstRowKeyboard: string[] = AZERTY_KEYBOARD.slice(0, 10);
  secondRowKeyboard: string[] = AZERTY_KEYBOARD.slice(10, 19);
  thirdRowKeyboard: string[] = AZERTY_KEYBOARD.slice(20, 26);

  constructor( private _roundService: RoundService, private _activatedRoute: ActivatedRoute) {
    this._paramsSubscription = this._activatedRoute.paramMap.subscribe(paramMap => {
      this._roundId = paramMap.get('id')!;
      this._roundService.fetchRound(this._roundId).pipe(take(1)).subscribe(round => this.round = round)
    })
  }
  
  sendFetchedLetter(letter: string) {
    this._roundService.postLettersToRound(this._roundId, letter).subscribe(round => this.round = round)
  }

  ngOnDestroy(): void {
    this._paramsSubscription.unsubscribe()
  }
}
