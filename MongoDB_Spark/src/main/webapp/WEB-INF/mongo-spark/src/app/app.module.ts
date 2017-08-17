import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { MongoComponent } from './mongo/mongo.component';
import { MongoInfoComponent } from './mongo-info/mongo-info.component';
import { AppRoutingComponent } from './app-routing/app-routing.component';
import { MaterialModule, MdList, MdListItem } from '@angular/material'

@NgModule({
  declarations: [
    AppComponent,
    MongoComponent,
    MongoInfoComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
