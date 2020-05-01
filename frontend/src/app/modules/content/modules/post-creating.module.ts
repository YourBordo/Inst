import {PostCreatingComponent} from "../components/post-creating/post-creating.component";
import {AppComponent} from "../../../app.component";
import {NgModule} from "@angular/core";
import {CommonModule, DatePipe} from "@angular/common";
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [PostCreatingComponent],
    imports: [
        CommonModule,
        FormsModule
    ],
  providers: [DatePipe],
  exports: [PostCreatingComponent],
  bootstrap: [AppComponent]
})
export class PostCreatingModule { }
