import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserGuard } from 'src/app/guards/user-guard/user.guard';
import { WelcomepageComponent } from 'src/app/welcomepage/welcomepage.component';

const routes: Routes = [
  { path: 'welcome', component: WelcomepageComponent, canActivate: [UserGuard] }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserRoutingModule { }
