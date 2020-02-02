import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { PostService } from 'src/app/services/postservice/post.service';

@Component({
  selector: 'app-post-solution',
  templateUrl: './post-solution.component.html',
  styleUrls: ['./post-solution.component.css']
})
export class PostSolutionComponent implements OnInit {

  @ViewChild('postSolution', {static: false}) 
  taskPostForm: NgForm;

  content: string;

  constructor(private postService: PostService) { }

  ngOnInit() {
    
  }

  onSubmit() {
    const data = {
      content: this.content,
      type: "SOLUTION",
      taskId: 2,
      userId: 2
    }
    console.log(data);
    this.postService.postSolution(data);
  } 
}
