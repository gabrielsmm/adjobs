import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-dialog-confirmacao',
  templateUrl: './dialog-confirmacao.component.html',
  styleUrls: ['./dialog-confirmacao.component.css']
})
export class DialogConfirmacaoComponent implements OnInit {

  public confirmMessage: string;

  constructor(public dialogRef: MatDialogRef<DialogConfirmacaoComponent>) { }

  ngOnInit(): void {
  }

}
