import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {AppComponent} from "../../../app.component";
import {WallComponent} from "../components/wall/wall.component";
import {PostService} from "../services/post.service";
@NgModule({
  declarations: [WallComponent],
  imports: [
    CommonModule,
    FormsModule
  ],
  providers: [PostService],
  exports: [WallComponent],
  bootstrap: [AppComponent]
})
export class WallModule { }
