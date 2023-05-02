import { Component, OnInit } from '@angular/core';
import { WelcomepageComponent } from '../welcomepage/welcomepage.component';
import { SearchFlightService } from '../services/search-flight.service';
import { FlightSearch } from '../class/flight-search';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { error } from 'console';
import { HttpClient } from '@angular/common/http';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-flight-search',
  templateUrl: './flight-search.component.html',
  styleUrls: ['./flight-search.component.css']
})
export class FlightSearchComponent implements OnInit {

  // FlightDetails: FlightSearch[] = [];
  // displayedColumns: string[] = ['Id', 'leavingfrom', 'arrivingat', 'leavingdate'];
  // collapsed = true;
  // searchMode: boolean = false;
  form: any = {
    // id: null,
    leavingfrom: null
    // arrivingat: null,
    // leavingdate: null
  }
  result: any;

  constructor(private router: Router, private search: SearchFlightService, private httpClient: HttpClient,
    private route: ActivatedRoute) { }


  ngOnInit(): void {
    // this.getAllFlights();
  }


  onSubmit(): void {
    const { leavingfrom } = this.form;
    this.search.GetFlights(leavingfrom).subscribe(data => {
      console.log(data);
      this.result = data;
      // console.log(this.result);
      return this.result;
    })
  }

  // public getAllFlights() {
  //   this.service.getAllFlights().subscribe(
  //     (resp: FlightSearch[]) => {
  //       console.log(resp);
  //       this.FlightDetails = resp;
  //     }, (error: HttpErrorResponse) => {
  //       console.log(error);
  //     }
  //   );
  // }

  // doSearch(value: string) {
  //   console.log('value=${value}');
  //   this.router.navigateByUrl('/search/${value}');
  // }

  // listFlights() {
  //   this.searchMode = this.route.snapshot.paramMap.has('keyword');
  //   if (this.searchMode) {
  //     this.handleSearchFlights();
  //   }
  // }

  // handleSearchFlights() {
  //   const theKeyword: string = this.route.snapshot.paramMap.get('keyword')!;

  //   this.service.searchFlights(theKeyword).subscribe(
  //     data => {
  //       this.FlightDetails = data;
  //     }
  //   )
  // };
}
