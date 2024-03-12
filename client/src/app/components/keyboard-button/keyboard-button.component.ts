import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-keyboard-button',
  templateUrl: './keyboard-button.component.html',
  styleUrl: './keyboard-button.component.css'
})
export class KeyBoardButtonComponent {
  @Input({ required : true }) letter! : string
  @Output() onChooseLetter = new EventEmitter<string>()

  letterTried() {
    this.onChooseLetter.emit(this.letter)
  }
}
