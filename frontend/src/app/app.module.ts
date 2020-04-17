import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HeaderModule} from "./modules/header/header.module";
import {ComplaintsModule} from "./modules/content/complaints.module";

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HeaderModule,
    ComplaintsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
