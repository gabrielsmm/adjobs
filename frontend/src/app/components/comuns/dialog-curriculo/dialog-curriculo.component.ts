import { Curriculo } from './../../../models/Curriculo.model';
import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';

import { LoginService } from './../../../services/login.service';

@Component({
  selector: 'app-dialog-curriculo',
  templateUrl: './dialog-curriculo.component.html',
  styleUrls: ['./dialog-curriculo.component.css']
})
export class DialogCurriculoComponent implements OnInit {

  constructor(@Inject(MAT_DIALOG_DATA) public data: Curriculo,
    public loginService: LoginService) { }

  ngOnInit(): void {
  }

  openCandidatar() {
    console.log('Candidatar-se...');
  }

}
