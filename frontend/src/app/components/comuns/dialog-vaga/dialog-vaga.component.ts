import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';

import { LoginService } from '../../../services/login.service';

@Component({
  selector: 'app-dialog-vaga',
  templateUrl: './dialog-vaga.component.html',
  styleUrls: ['./dialog-vaga.component.css']
})
export class DialogVagaComponent implements OnInit {

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
    public loginService: LoginService) { }

  ngOnInit(): void {
  }

  openCandidatar() {
    console.log('Candidatar-se...');
  }

}