import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {AppComponent} from "../../../app.component";
import {SinglePostComponent} from "../components/single-post/single-post.component";
import {AppRoutingModule} from "../../../app-routing.module";
import {CommentService} from "../services/comment.service";
import {PostService} from "../services/post.service";

@NgModule({
  declarations: [SinglePostComponent],
  imports: [
    CommonModule,
    FormsModule,
    AppRoutingModule

  ],
  providers: [CommentService, PostService],
  exports: [SinglePostComponent],
  bootstrap: [AppComponent]
})
export class SinglePostModule { }
