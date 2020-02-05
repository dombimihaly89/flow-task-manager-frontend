import { Component, OnInit, Input } from '@angular/core';
import { PostService } from 'src/app/services/postservice/post.service';

@Component({
  selector: 'app-post-list',
  templateUrl: './post-list.component.html',
  styleUrls: ['./post-list.component.css']
})
export class PostListComponent implements OnInit {

  constructor(private postService: PostService) { }

  posts: any;

  @Input()
  task: any;

  ngOnInit() {
    this.postService.getPostById(this.task.id).subscribe(
      (data) => {
        console.log('POST', data)
        this.posts = data;
      }
    )
    console.log(this.posts);
  }

}
