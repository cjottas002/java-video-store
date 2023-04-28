// rental.component.ts

import { Component, OnInit } from '@angular/core';
import { Rental } from 'src/app/models/rental.model';
import { RentalService } from 'src/app/services/rental.service';

@Component({
  selector: 'app-rental',
  templateUrl: './rental.component.html',
  styleUrls: ['./rental.component.css']
})
export class RentalComponent implements OnInit {
  displayedColumns: string[] = ['id', 'user', 'movie', 'rentalDate', 'returnDate', 'available'];
  rentals: Rental[] = [];

  constructor(private rentalService: RentalService) { }

  ngOnInit(): void {
    this.rentalService.getRentals().subscribe(rentals => {
      this.rentals = rentals;
    });
  }
}
