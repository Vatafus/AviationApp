import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserRoutingModule } from './user-routing.module';
import { UserGuard } from 'src/app/guards/user-guard/user.guard';


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    UserRoutingModule
  ],
  providers: [UserGuard]
})
export class UserModule { }
