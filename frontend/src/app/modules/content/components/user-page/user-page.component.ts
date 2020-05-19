import {Component, OnInit} from "@angular/core";
import {ActivatedRoute} from "@angular/router";
import {Post} from "../../../models/post";
import {PostService} from "../../services/post.service";
import {StorageService} from "../../services/storage.service";
import {User} from "../../../models/user";
import {UserService} from "../../services/user.service";

@Component({
  selector: 'user-page',
  templateUrl: './user-page.component.html',
  styleUrls: ['./user-page.component.css']
})

export class UserPageComponent implements OnInit{

  public posts: Post[];
  public nickname: string;
  constructor(private route: ActivatedRoute,
              private postService: PostService,
              public storageService: StorageService,
              private userService: UserService) {}


  ngOnInit(): void {
    // первый вариант вытащить параметры от роутинга
    // snapshot - параметры route на момент инициализации
    let id = +this.route.snapshot.params['id'];

    this.postService.getUserPosts(id).subscribe((response: Post[]) => {
      this.posts = response;
    });
    this.userService.getUser(id).subscribe((response: User) => {
      this.nickname = response.nickname;
    });

  }
}
