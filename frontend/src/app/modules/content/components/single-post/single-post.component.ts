import {Component, DoCheck, Input, OnChanges, OnInit, SimpleChanges} from "@angular/core";
import {ActivatedRoute} from "@angular/router";
import {PostService} from "../../services/post.service";
import {Post} from "../../../models/post";
import {CommentService} from "../../services/comment.service";
import {Comment} from "../../../models/comment";
import {HttpClient} from "@angular/common/http";
import {DatePipe} from "@angular/common";
import {StorageService} from "../../services/storage.service";
import {UserService} from "../../services/user.service";
import {User} from "../../../models/user";
import {forEachComment} from "tslint";
import {compareNumbers} from "@angular/compiler-cli/src/diagnostics/typescript_version";

@Component({
  selector: 'post',
  templateUrl: './single-post.component.html',
  styleUrls: ['./single-post.component.css']
})

export class SinglePostComponent implements OnInit{

  myDate = new Date();
  currentDateTime: string;
  constructor(private route: ActivatedRoute,
              private postService: PostService,
              private commentService:CommentService,
              private httpClient: HttpClient,
              private datePipe: DatePipe,
              public storageService: StorageService,
              private userService: UserService) {
  this.currentDateTime = this.datePipe.transform(this.myDate, 'yyyy-MM-dd hh:mm');}

postId: number;
  post: Post;
  comments:Comment[];
  users: User[];

  ngOnInit(): void {
  this.postId = +this.route.snapshot.params['id'];

    this.postService.getPost(this.postId).subscribe((response: Post) => {
      this.post = response;


    this.userService.getUserByPostId(this.post.id).subscribe((response: User) => {
      this.post.user = response;

    });

  });

    this.commentService.getPostComments(this.postId).subscribe((response: Comment[]) => {
      this.comments = response;

    for(let comment of this.comments )
    {
      this.userService.getUserByCommentId(comment.id).subscribe((response: User) => {
       comment.user = response;

      });
    }

    });

  }




  text: string;
  onUpload() {


    this.httpClient.post("/api/comment/",{
      text: this.text,
      date: this.currentDateTime,
      user:
        {
          id: this.storageService.getCurrentUser().id
        },
        post:
          {
            id: this.postId
          }

    }).subscribe(
      res => {},
      err => {
        console.log('Error');
      });
  this.text="";

    this.commentService.getPostComments(this.postId).subscribe((response: Comment[]) => {
      this.comments = response;});

    this.ngOnInit();

  }
}
