import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { GameBoardComponent } from './views/game-board/game-board.component';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './components/header/header.component';
import { HomeComponent } from './views/home/home.component';
import { CreateRoundButtonComponent } from './components/create-round-button/create-round-button.component';
import { KeyBoardButtonComponent } from './components/keyboard-button/keyboard-button.component';
import { RoundCardComponent } from './components/round-card/round-card.component';
import { CreateGameComponent } from './components/create-game/create-game.component';
import { ReactiveFormsModule } from '@angular/forms';
import { NewGameComponent } from './views/new-game/new-game.component';

@NgModule({
  declarations: [
    AppComponent,
    GameBoardComponent,
    HeaderComponent,
    HomeComponent,
    CreateRoundButtonComponent,
    KeyBoardButtonComponent,
    RoundCardComponent,
    CreateGameComponent,
    NewGameComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CommonModule,
    HttpClientModule, 
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
