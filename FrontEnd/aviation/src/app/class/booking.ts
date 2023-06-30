import { Boardingpass } from "./boardingpass";
import { FlightSearch } from "./flight-search";
import { User } from "./user";

export class Booking {
    id: number;
    user: User;
    flight: FlightSearch;
    boardingPasses: Boardingpass[];
    leavingFrom: string;
    arrivingAt: string;
    leavingDate: Date;
    canceled: boolean;
}
