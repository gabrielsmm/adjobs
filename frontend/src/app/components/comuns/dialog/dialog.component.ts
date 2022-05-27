import { LoginService } from './../../../services/login.service';
import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-dialog',
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.css']
})
export class DialogComponent implements OnInit {

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
    public loginService: LoginService) { }

  ngOnInit(): void {
  }

  openCandidatar() {
    console.log('Candidatar-se...');
  }

}
