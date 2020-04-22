//import { ImageData } from './ImageModel';
import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import {PostService} from "../../services/post.service";
import {Post} from "../../../models/post";

@Component({
  selector: 'post-create',
  templateUrl: './post-creating.component.html',
  styleUrls: ['./post-creating.component.css']
})

export class PostCreatingComponent {
  constructor(private httpClient: HttpClient) { }


  title = 'ImageUploaderFrontEnd';

  public selectedFile;
  public text: string;
  imgURL: any;
  receivedImageData: any;
  base64Data: any;
  convertedImage: any;

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

  onUpload() {
/*
    const uploadData = new FormData();
    uploadData.append('myFile', this.selectedFile, this.selectedFile.name);


    this.httpClient.post('api/post', uploadData)
      .subscribe(
        res => {console.log(res);
          this.receivedImageData = res;
          this.base64Data = this.receivedImageData.pic;
          this.convertedImage = 'data:image/jpeg;base64,' + this.base64Data; },
        err => console.log('Error Occured duringng saving: ' + err)
      );

*/
  }
}
