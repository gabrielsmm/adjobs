import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {path: 'inicio', loadChildren: () => import('./components/views/pagina-principal/pagina-principal-routing.module').then(m => m.PaginaPrincipalRoutingModule)},
  {path: 'login', loadChildren: () => import('./components/views/login/login-routing.module').then(m => m.LoginRoutingModule)},
  {path: '**', loadChildren: () => import('./components/views/pagina-principal/pagina-principal-routing.module').then(m => m.PaginaPrincipalRoutingModule)},
  {path: '', redirectTo: '/inicio', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
