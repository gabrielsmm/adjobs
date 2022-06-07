import { AuthGuard } from './guards/auth.guard';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {path: 'inicio', loadChildren: () => import('./components/views/home/home-routing.module').then(m => m.HomeRoutingModule)},
  {path: 'cadastro', loadChildren: () => import('./components/views/cadastro/cadastro-routing.module').then(m => m.CadastroRoutingModule)},
  {path: 'login', loadChildren: () => import('./components/views/login/login-routing.module').then(m => m.LoginRoutingModule)},
  {path: 'empregos', loadChildren: () => import('./components/views/empregos/empregos-routing.module').then(m => m.EmpregosRoutingModule)},
  {path: 'candidato', loadChildren: () => import('./components/views/area-candidato/area-candidato-routing.module').then(m => m.AreaCandidatoRoutingModule), canActivate: [AuthGuard]},
  {path: 'empresa', loadChildren: () => import('./components/views/area-empresa/area-empresa-routing.module').then(m => m.AreaEmpresaRoutingModule), canActivate: [AuthGuard]},

  {path: 'estagios', loadChildren: () => import('./components/views/estagios/estagios-routing.module').then(m => m.EstagiosRoutingModule), canActivate: [AuthGuard]},
  {path: 'concursos', loadChildren: () => import('./components/views/concursos/concursos-routing.module').then(m => m.ConcursosRoutingModule), canActivate: [AuthGuard]},
  {path: '**', loadChildren: () => import('./components/views/home/home-routing.module').then(m => m.HomeRoutingModule)},
  {path: '', redirectTo: '/inicio', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
