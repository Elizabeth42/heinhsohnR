import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GestionarComicComponent } from './semillero/componentes/gestionarComic/gestionar-comic';
import { BienvenidaComponent } from './semillero/componentes/home/bienvenida-component';
import { ConsultarComicComponent} from './semillero/componentes/consultarComic/consultar-comic-component';
import {GestionarPersonaComponent} from './semillero/componentes/gestionarPersona/gestionarPersona-Component';
import {GestionarProveedorComponent} from './semillero/componentes/gestionarProveedor/gestionarProveedor-Component';

const routes: Routes = [
  { path: 'gestionar-comic', component: GestionarComicComponent },
  { path: 'bienvenida', component: BienvenidaComponent, data : null },
  { path: 'consultar-comic', component: ConsultarComicComponent, },
  { path: 'gestionar-persona', component: GestionarPersonaComponent, },
  { path: 'gestionar-proveedor', component: GestionarProveedorComponent, }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
