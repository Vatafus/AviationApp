export class Booking {
    id: number;
    pozitieX: number;
    pozitieY: number;
    nrScaun: number;

    constructor(pozX, pozY, nr) {
        this.pozitieX = pozX;
        this.pozitieY = pozY;
        this.nrScaun = nr;
    }
}
