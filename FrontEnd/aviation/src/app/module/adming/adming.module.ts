import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdmingRoutingModule } from './adming-routing.module';
import { UserGuard } from 'src/app/guards/user-guard/user.guard';


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    AdmingRoutingModule
  ],
  providers: [UserGuard]
})
export class AdmingModule { }
