import {Component, OnInit} from "@angular/core";
import {PostService} from "../../services/post.service";
import {Post} from "../../../models/post";
import {UserService} from "../../services/user.service";
import {User} from "../../../models/user";

@Component({
  selector: 'wall',
  templateUrl: './wall.component.html',
  styleUrls: ['./wall.component.css']
})

export class WallComponent implements OnInit{


  public wallPosts: Post[];
  public CURRENT_ID: number = 1;
  public len: number;


  constructor(private postService: PostService) {}


  public ngOnInit(): void {

    this.postService.getWallPosts(this.CURRENT_ID).subscribe((response: Post[]) => {
      this.wallPosts = response;
      this.len =this.wallPosts.length;
      console.log(this.wallPosts);

    });

  }
}
