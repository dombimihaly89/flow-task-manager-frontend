import { Component, OnInit } from '@angular/core';
import { PostService } from '../services/postservice/post.service';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {

  constructor(private postService: PostService) { }

  posts: any;

  ngOnInit() {
    this.postService.getPostById(1).subscribe(
      (data) => {
        this.posts = data;
      }
    )
    console.log(this.posts);
  }

}
