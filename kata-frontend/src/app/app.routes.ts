import { RouterModule, Routes } from '@angular/router';
import { KataDescriptionComponent } from './components/kata-description/kata-description.component';
import { NgModule } from '@angular/core';

export const routes: Routes = [
  { path: 'kata', component: KataDescriptionComponent },
  { path: '**', redirectTo: 'kata' }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
  })
export class AppRoutModule { }