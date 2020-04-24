//import { ImageData } from './ImageModel';
import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import {PostService} from "../../services/post.service";
import {Post} from "../../../models/post";
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'post-create',
  templateUrl: './post-creating.component.html',
  styleUrls: ['./post-creating.component.css']
})

export class PostCreatingComponent {

  constructor(private httpClient: HttpClient, public _DomSanitizationService: DomSanitizer) { }

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

  private receivedImageData: Post;
  public convertedImg: any;

  onUpload() {
    console.log(this.imgURL);


    this.httpClient.post("/api/post/",{
      text: this.text,
      photo: this.imgURL
    }).subscribe(
        res => {
/*
          this.receivedImageData = <Post>res;
          this.convertedImg = this.receivedImageData.photo;
*/
        },
      err => {
        console.log('Error');
      });

  }
}
