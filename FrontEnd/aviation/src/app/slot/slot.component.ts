import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-slot',
  templateUrl: './slot.component.html',
  styleUrls: ['./slot.component.css']
})
export class SlotComponent implements OnInit {

  locations$: Locations[];
  vehicles$: Vehicle[];
  sessionValue: string = "";
  slotService: any;

  constructor(
    private vehicleService: VehicleService,
    private dashboardComponent: DashboardComponent) { }

  ngOnInit() {
    this.dashboardComponent.checkLogin();
    this.loadLocations();
    this.loadVehicle();
  }


  loadVehicle() {
    return this.vehicleService.getVehicles()
      .subscribe(data => this.vehicles$ = data)
  }

}
