import { PaginaPrincipalComponent } from './components/views/pagina-principal/pagina-principal.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {path: 'inicio', loadChildren: () => import('./components/views/pagina-principal/pagina-principal-routing.module').then(m => m.PaginaPrincipalRoutingModule)},
  {path: 'login', loadChildren: () => import('./components/views/login/login-routing.module').then(m => m.LoginRoutingModule)},
  {path: '', redirectTo: '/inicio', pathMatch: 'full'},
  {path: '**', component: PaginaPrincipalComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
