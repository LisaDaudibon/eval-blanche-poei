import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GameBoardComponent } from './views/game-board/game-board.component';
import { HomeComponent } from './views/home/home.component';
import { NewGameComponent } from './views/new-game/new-game.component';
import { LoginComponent } from './views/login/login.component';
import { AuthGuard } from './guards/auth.gard';
import { AdminComponent } from './views/admin/admin.component';

const routes: Routes = [
  {path: "", component: HomeComponent},
  {path:"rounds/:id", component: GameBoardComponent},
  {path: "login", component: LoginComponent},
  {path: "admin", component: AdminComponent},
  {path: "newgame", component: NewGameComponent},
  { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
