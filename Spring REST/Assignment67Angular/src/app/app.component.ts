import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  API_URL = 'http://localhost:8080/HelloREST/payroll';
  data: string;

  constructor(private http: HttpClient) {}

  onSubmit(form: NgForm) {
    // console.log(form);
    console.log('From getData:', this.getData());
    console.log('From fetchData:', this.fetchData());
  }

  getData() {
    return this.http.get<string>(this.API_URL).subscribe((res) => {
      console.log(res);
      this.data = res;
    });
  }

  fetchData() {
    return fetch(this.API_URL)
      .then((res) => res.json())
      .then((res) => console.log());
  }
}
