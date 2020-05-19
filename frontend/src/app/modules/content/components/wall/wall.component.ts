import {Component, OnInit} from "@angular/core";
import {PostService} from "../../services/post.service";
import {Post} from "../../../models/post";
import {UserService} from "../../services/user.service";
import {User} from "../../../models/user";
import {StorageService} from "../../services/storage.service";

@Component({
  selector: 'wall',
  templateUrl: './wall.component.html',
  styleUrls: ['./wall.component.css']
})

export class WallComponent implements OnInit{


  public wallPosts: Post[];


  constructor(private postService: PostService,
              public storageService: StorageService,
              private userService: UserService) {}


  public ngOnInit(): void {

    this.postService.getWallPosts(this.storageService.getCurrentUser().id).subscribe((response: Post[]) => {
      this.wallPosts = response;


    for(let post of this.wallPosts ) {
      this.userService.getUserByPostId(post.id).subscribe((response: User) => {
        post.user = response;
      });
    }

  });
  }
}
