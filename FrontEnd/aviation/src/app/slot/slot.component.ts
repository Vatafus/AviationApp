import { Component, OnInit } from '@angular/core';
import { Sits } from '../class/sits';
import { SitsServiceService } from '../services/sits-service.service';

@Component({
  selector: 'app-slot',
  templateUrl: './slot.component.html',
  styleUrls: ['./slot.component.css']
})
export class SlotComponent implements OnInit {

  sits$: Sits[];
  sessionValue: string = "";
  slotService: any;

  constructor(
    private sitsService: SitsServiceService) { }

  ngOnInit() {
    this.loadSits();
  }


  loadSits() {
    return this.sitsService.getSits()
      .subscribe(data => this.sits$ = data)
  }

}
