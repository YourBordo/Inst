import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import {Post} from "../../../models/post";
import {DatePipe} from "@angular/common";

@Component({
  selector: 'post-create',
  templateUrl: './post-creating.component.html',
  styleUrls: ['./post-creating.component.css']
})

export class PostCreatingComponent {
  private receivedImageData: Post;

  myDate = new Date();
  currentDateTime: string;
  constructor(private datePipe: DatePipe, private httpClient: HttpClient){
    this.currentDateTime = this.datePipe.transform(this.myDate, 'yyyy-MM-dd hh:mm');}

  public selectedFile;
  public text: string;
  public imgURL: any;

  public  onFileChanged(event) {
    console.log(event);
    this.selectedFile = event.target.files[0];

    // Below part is used to display the selected image
    let reader = new FileReader();
    reader.readAsDataURL(event.target.files[0]);
    reader.onload = (event2) => {
      this.imgURL = reader.result;
    };

  }

  public convertedImg: any;

  onUpload() {
   // console.log(this.imgURL);

    this.httpClient.post("/api/post/",{
      text: this.text,
      photo: this.imgURL,
      date: this.currentDateTime
    }).subscribe(
        res => {

          this.receivedImageData = <Post>res;
          this.convertedImg = this.receivedImageData.photo;

        },
      err => {
        console.log('Error');
      });

  }
}
