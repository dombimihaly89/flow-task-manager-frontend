import { Component, OnInit, Input } from '@angular/core';
import { PostService } from '../services/postservice/post.service';
import { DataService } from '../services/data.service';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {

  constructor(private postService: PostService, private dataService: DataService) { }


  @Input('poster')
  post: any;

  username: string;


  ngOnInit() {
    this.dataService.dataSource.subscribe(data => {
      console.log('get', data);
      this.username = data.username;
    })
  }

}
