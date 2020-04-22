import {PostCreatingComponent} from "./components/post-creating/post-creating.component";
import {AppComponent} from "../../app.component";
import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [PostCreatingComponent],
    imports: [
        CommonModule,
        FormsModule
    ],
  providers: [],
  exports: [PostCreatingComponent],
  bootstrap: [AppComponent]
})
export class PostCreatingModule { }
