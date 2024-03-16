import { Component } from '@angular/core';
import { UserService } from '../../services/user.service';
import { Router } from '@angular/router';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ALPHA_NUMERIC_REGEXP, getTrad } from '../../models/constant';
import { catchError, of } from 'rxjs';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
})
export class LoginComponent {
  loginForm = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl(undefined, [Validators.required, Validators.minLength(8), Validators.maxLength(50), Validators.pattern(ALPHA_NUMERIC_REGEXP)]),
  })

  hide: boolean = true

  errors: string[] = []

  constructor(private _userService: UserService, private _router: Router) { }

  subscribe() {
    if (this.isFormValid()) {
      this._userService.createUser({
        username: this.loginForm.value.email!,
        password: this.loginForm.value.password!
      }).pipe(
        catchError(() => {
          this.errors= [`Les données renseignées n'ont pas permis de créer l'utilisateur`]
          return of()
        })
      ).subscribe(() => {
        this.submit()
      })
    }
  }

  async submit() {
    if (this.isFormValid()) {
      this._userService.login({
        username: this.loginForm.value.email!,
        password: this.loginForm.value.password!
      }).pipe(
        catchError(() => {
          this.errors = [`E-mail et / ou mot de passe non trouvé(s)`]
          return of()
        })
      ).subscribe(() => {
        this._router.navigateByUrl('/admin')
      })
    }
  }

  isFormValid(): boolean {
    this.errors = []

    if (this.loginForm.valid) {
      return true
    }

    // Gestion des différents cas d'erreurs de notre formulaire (requires, tooManyLetters, maxLength)
    Object.entries(this.loginForm.controls).forEach(([key, control]) => {
      if (control.errors) {
        if (Object.hasOwn(control.errors, 'required')) {
          this.errors.push(`Champ ${getTrad(key)} : le champ est obligatoire`)
        }
        if (Object.hasOwn(control.errors, 'email')) {
          this.errors.push(`Champ ${getTrad(key)} : la valeur doit être un mail valide`)
        }
        if (Object.hasOwn(control.errors, 'minlength')) {
          this.errors.push(`Champ ${getTrad(key)} : la valeur doit avoir plus de ${control.errors['minlength'].requiredLength} caractères`)
        }
        if (Object.hasOwn(control.errors, 'maxlength')) {
          this.errors.push(`Champ ${getTrad(key)} : la valeur ne doit pas avoir plus de ${control.errors['maxlength'].requiredLength} caractères`)
        }
        if (Object.hasOwn(control.errors, 'pattern')) {
          this.errors.push(`Champ ${getTrad(key)} : la valeur ne doit contenir que des lettres (pas d'accent) et des chiffres`)
        }
      }
    })
    this.loginForm.markAllAsTouched()
    return false
  }

}
