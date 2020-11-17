import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginFailedComponent } from './login-failed/login-failed.component';
import { LoginFormComponent } from './login-form/login-form.component';
import { LoginSuccessComponent } from './login-success/login-success.component';

const routes: Routes = [
  { path: 'login', component: LoginFormComponent },
  { path: 'loginSuccess', component: LoginSuccessComponent },
  { path: 'loginFailed', component: LoginFailedComponent },
  { path: '**', redirectTo: 'login' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
