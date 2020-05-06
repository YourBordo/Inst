import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {AppComponent} from "../../../app.component";
import {WallComponent} from "../components/wall/wall.component";
import {PostService} from "../services/post.service";
import {UserService} from "../services/user.service";
import {RouterModule} from "@angular/router";


@NgModule({
  declarations: [WallComponent],
    imports: [
        CommonModule,
        FormsModule,
        RouterModule
    ],
  providers: [PostService, UserService],
  exports: [WallComponent],
  bootstrap: [AppComponent]
})
export class WallModule { }
