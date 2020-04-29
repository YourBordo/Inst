import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HeaderModule} from "./modules/header/header.module";
import {ComplaintsModule} from "./modules/content/modules/complaints.module";
import {RouterModule, Routes} from "@angular/router";
import {ComplaintsComponent} from "./modules/content/components/complaints/complaints.component";
import {PostCreatingComponent} from "./modules/content/components/post-creating/post-creating.component";
import {PostCreatingModule} from "./modules/content/modules/post-creating.module";
import {WallModule} from "./modules/content/modules/wall.module";
import {WallComponent} from "./modules/content/components/wall/wall.component";

const appRoutes: Routes =[
  { path: 'complaints', component: ComplaintsComponent},
  { path: 'create-post', component: PostCreatingComponent},
  { path: 'wall', component: WallComponent}

];


@NgModule({
  declarations: [AppComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HeaderModule,WallModule,
    ComplaintsModule, PostCreatingModule, RouterModule.forRoot(appRoutes)
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
