import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GameBoardComponent } from './views/game-board/game-board.component';
import { HomeComponent } from './views/home/home.component';

const routes: Routes = [
  {path: "", component: HomeComponent},
  {path:"round/{id}", component: GameBoardComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
