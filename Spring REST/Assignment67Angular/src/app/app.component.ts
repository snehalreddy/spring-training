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
    this.getData(); // emo mari.... em jaruguthundhi nuvvu em chesthunnav? Naaku antha greek and latin la undhi
  }

  getData() {
    const proxyurl = ''; //@crossorigin chudu

    return this.http.get<string>(proxyurl + this.API_URL).subscribe((res) => {
      console.log(res);
      this.data = res;
    });
  }
}
