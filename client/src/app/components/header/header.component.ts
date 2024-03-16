import { Component } from '@angular/core';
import { UserService } from '../../services/user.service';
import { BehaviorSubject } from 'rxjs';
import { User } from '../../models/user';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {
  $user: BehaviorSubject<User | null>;
  constructor(private _userService: UserService) {
    this.$user = _userService.userLogged
  }

  logout() {
    this._userService.logout()
  }

}
