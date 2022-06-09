import { LoginService } from './../../../../services/login.service';
import { EmpresaService } from './../../../../services/empresa.service';
import { Empresa } from './../../../../models/Empresa.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-minha-area',
  templateUrl: './minha-area.component.html',
  styleUrls: ['./minha-area.component.css']
})
export class MinhaAreaComponent implements OnInit {

  empresa: Empresa = new Empresa;

  constructor(private empresaService: EmpresaService,
  private loginService: LoginService) {
    this.getEmpresa();
  }

  ngOnInit(): void {
  }

  getEmpresa() {
    let _this = this;
    this.empresaService.findById(this.loginService.objUsuarioAutenticado.id).subscribe({
      next(data) {
        _this.empresa = data;
      },
      error(err) {
        console.log(err);
      },
      complete() {

      }
    });
  }

}
