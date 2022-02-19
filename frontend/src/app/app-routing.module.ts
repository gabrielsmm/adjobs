import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {path: 'inicio', loadChildren: () => import('./components/views/home/home-routing.module').then(m => m.HomeRoutingModule)},
  {path: 'login', loadChildren: () => import('./components/views/login/login-routing.module').then(m => m.LoginRoutingModule)},
  {path: 'empregos', loadChildren: () => import('./components/views/empregos/empregos-routing.module').then(m => m.EmpregosRoutingModule)},
  {path: 'estagios', loadChildren: () => import('./components/views/estagios/estagios-routing.module').then(m => m.EstagiosRoutingModule)},
  {path: 'concursos', loadChildren: () => import('./components/views/concursos/concursos-routing.module').then(m => m.ConcursosRoutingModule)},
  {path: '**', loadChildren: () => import('./components/views/home/home-routing.module').then(m => m.HomeRoutingModule)},
  {path: '', redirectTo: '/inicio', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
