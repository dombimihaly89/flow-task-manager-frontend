import { Component, OnInit, Input } from '@angular/core';
import { PostService } from '../services/postservice/post.service';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {

  constructor(private postService: PostService) { }


  @Input('poster')
  post: any;

  ngOnInit() {
    
  }

}
