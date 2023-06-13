import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateflightComponent } from 'src/app/Admin/CreateFlight/createflight/createflight.component';
import { DashboardComponent } from 'src/app/Admin/Dashboard/dashboard/dashboard.component';
import { UpdateflightComponent } from 'src/app/Admin/UpdateFlight/updateflight/updateflight.component';
import { User } from 'src/app/class/user';
import { AdminGuard } from 'src/app/guards/admin-guard/admin.guard';
import { UserGuard } from 'src/app/guards/user-guard/user.guard';

const routes: Routes = [
  { path: 'dashboard', component: DashboardComponent },
  { path: 'update-flight/:id', component: UpdateflightComponent },
  { path: 'addFlight', component: CreateflightComponent }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdmingRoutingModule { }
