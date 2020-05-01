import {Component} from "@angular/core";
import {PostService} from "../../services/post.service";
import {Post} from "../../../models/post";
import {UserService} from "../../services/user.service";
import {User} from "../../../models/user";

@Component({
  selector: 'wall',
  templateUrl: './wall.component.html',
  styleUrls: ['./wall.component.css']
})

export class WallComponent {


  public wallPosts: Post[];
  public users: User[];
  public usersId: number;
  public id: number = 1;
  public len: number;


  constructor(private postService: PostService, private userService: UserService) {
  }



  public ngOnInit(): void {

    this.postService.getWallPosts(this.id).subscribe((response: Post[]) => {
      this.wallPosts = response;
      this.len =this.wallPosts.length;
      console.log(this.wallPosts);

    });

  }
}
