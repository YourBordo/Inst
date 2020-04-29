import {Component} from "@angular/core";
import {PostService} from "../../services/post.service";
import {Post} from "../../../models/post";

@Component({
  selector: 'wall',
  templateUrl: './wall.component.html',
  styleUrls: ['./wall.component.css']
})

export class WallComponent {
  constructor(private postService:PostService) {}
  public wallPosts: Post[];
  public id: number = 1;

 public ngOnInit(): void {
    this.postService.getWallPosts(this.id).subscribe((response:Post[]) =>{
      this.wallPosts = response;
    });
  }

}
