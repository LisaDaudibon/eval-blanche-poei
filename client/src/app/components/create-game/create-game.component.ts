import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Game } from '../../models/game';

@Component({
  selector: 'app-create-game',
  templateUrl: './create-game.component.html',
  styleUrl: './create-game.component.css'
})
export class CreateGameComponent {
  gameCreationForm: FormGroup;
  

  @Output() onCreateGame = new EventEmitter<Game>()

  constructor(private _fb: FormBuilder) {
    this.gameCreationForm = this._fb.group({
      wordToGuess: this._fb.control('', [Validators.required]),
      description: this._fb.control('')
    })
  }

  createGame() {
    this.onCreateGame.emit(this.gameCreationForm.value)
  }

  get wordToGuess () {
    return this.gameCreationForm.get("wordToGuess")!;
  }
}
