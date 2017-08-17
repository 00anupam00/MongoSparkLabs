import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

import { MongoComponent } from '../mongo/mongo.component';

@Component({
  selector: 'app-app-routing',
  templateUrl: './app-routing.component.html',
  styleUrls: ['./app-routing.component.css']
})
export class AppRoutingComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
