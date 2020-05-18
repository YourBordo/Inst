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
import {UserPageModule} from "./modules/content/modules/user-page.module";
import {UserPageComponent} from "./modules/content/components/user-page/user-page.component";
import {SinglePostComponent} from "./modules/content/components/single-post/single-post.component";
import {SinglePostModule} from "./modules/content/modules/single-post.module";
import {LoginFormComponent} from "./modules/content/components/login-form/login-form.component";
import {LoginModule} from "./modules/content/modules/login.module";
import {FormsModule} from "@angular/forms";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {UserService} from "./modules/content/services/user.service";
import {APIInterceptor} from "./modules/content/services/api-interceptor";

const appRoutes: Routes =[
  { path: 'complaints', component: ComplaintsComponent},
  { path: 'create-post', component: PostCreatingComponent},
  { path: 'wall', component: WallComponent},
  { path: 'user-page/:id', component: UserPageComponent},
  { path: 'current-post/:id', component: SinglePostComponent},
  { path: 'enter', component: LoginFormComponent},


];


@NgModule({
  declarations: [AppComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HeaderModule,
    WallModule,
    ComplaintsModule,
    LoginModule,
    PostCreatingModule,
    UserPageModule,
    SinglePostModule,
    RouterModule.forRoot(appRoutes),
    FormsModule,
    HttpClientModule
  ],
  providers: [UserService, APIInterceptor, {
    provide: HTTP_INTERCEPTORS,
    useClass: APIInterceptor,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
