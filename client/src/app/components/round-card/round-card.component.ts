import { Component, Input } from '@angular/core';
import { Round } from '../../models/round';

@Component({
  selector: 'app-round-card',
  templateUrl: './round-card.component.html',
  styleUrl: './round-card.component.css'
})
export class RoundCardComponent {
  @Input({ required: true}) round!: Round;

  setStateInFrench(round: Round): string {
    if (round.state === "ONGOING") {
      return "EN COURS"
    } else if (round.state == "WIN") {
      return "GAGNE"
    } else {
      return "PERDU"
    }
  }
}
