import {Component, DoCheck, Input, OnChanges, OnInit, SimpleChanges} from "@angular/core";
import {ActivatedRoute} from "@angular/router";
import {PostService} from "../../services/post.service";
import {Post} from "../../../models/post";
import {CommentService} from "../../services/comment.service";
import {Comment} from "../../../models/comment";
import {HttpClient} from "@angular/common/http";
import {DatePipe} from "@angular/common";

@Component({
  selector: 'post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})

export class PostComponent implements OnInit, DoCheck{
  public CURRENT_ID: number = 1;

  myDate = new Date();
  currentDateTime: string;
  constructor(private route: ActivatedRoute,
              private postService: PostService,
              private commentService:CommentService,
              private httpClient: HttpClient,
              private datePipe: DatePipe) {
  this.currentDateTime = this.datePipe.transform(this.myDate, 'yyyy-MM-dd hh:mm');}

postId: number;
  post: Post;
  comments:Comment[];

  ngOnInit(): void {
  this.postId = +this.route.snapshot.params['id'];

    this.postService.getPost(this.postId).subscribe((response: Post) => {
      this.post = response;
    });

    this.commentService.getPostComments(this.postId).subscribe((response: Comment[]) => {
      this.comments = response;

    });


  }

  ngDoCheck(): void {
    this.commentService.getPostComments(this.postId).subscribe((response: Comment[]) => {
      this.comments = response;

    });

  }

  text: string;
  onUpload() {


    this.httpClient.post("/api/comment/",{
      text: this.text,
      date: this.currentDateTime,
      user:
        {
          id: this.CURRENT_ID
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
this.ngDoCheck();
  }
}
