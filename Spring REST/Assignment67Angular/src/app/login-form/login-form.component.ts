import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css'],
})
export class LoginFormComponent implements OnInit {
  API_URL = 'http://localhost:8080/login';
  data: string;

  constructor(private http: HttpClient, private router: Router) {}

  ngOnInit(): void {}

  onSubmit(form: NgForm) {
    // console.log(form.value.username);
    // console.log(form.value.password);

    let username: string = form.value.username;
    let password: string = form.value.password;

    const postString = 'name=' + username + '&password=' + password;

    return this.http.post<string>(this.API_URL, postString).subscribe((res) => {
      if (res === 'VALID_USER') {
        // redirect to login success
        this.router.navigate(['/loginSuccess']);
      } else {
        // redirect to login alert wrong username or password
        this.router.navigate(['/loginFailed']);
      }
    });
  }
}
