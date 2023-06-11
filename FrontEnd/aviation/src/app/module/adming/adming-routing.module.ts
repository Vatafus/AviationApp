import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from 'src/app/Admin/Dashboard/dashboard/dashboard.component';
import { AdminGuard } from 'src/app/guards/guards/admin-guard/admin.guard';

const routes: Routes = [
  { path: 'dashboard', component: DashboardComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdmingRoutingModule { }
