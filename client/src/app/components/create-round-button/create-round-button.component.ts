import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Game } from '../../models/game';

@Component({
  selector: 'app-create-round-button',
  templateUrl: './create-round-button.component.html',
  styleUrl: './create-round-button.component.css'
})
export class CreateRoundButtonComponent {
  @Input({required: true}) data!: Game;
}
