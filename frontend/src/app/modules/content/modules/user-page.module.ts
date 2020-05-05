import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {AppComponent} from "../../../app.component";
import {UserPageComponent} from "../components/user-page/user-page.component";
import {PostService} from "../services/post.service";

@NgModule({
  declarations: [UserPageComponent],
  imports: [
    CommonModule,
    FormsModule
  ],
  providers: [PostService],
  exports: [UserPageComponent],
  bootstrap: [AppComponent]
})
export class UserPageModule { }
