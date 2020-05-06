import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {AppComponent} from "../../../app.component";
import {PostComponent} from "../components/post/post.component";
import {AppRoutingModule} from "../../../app-routing.module";
import {CommentService} from "../services/comment.service";
import {PostService} from "../services/post.service";

@NgModule({
  declarations: [PostComponent],
  imports: [
    CommonModule,
    FormsModule,
    AppRoutingModule

  ],
  providers: [CommentService, PostService],
  exports: [PostComponent],
  bootstrap: [AppComponent]
})
export class PostModule { }
