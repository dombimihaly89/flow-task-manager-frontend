import { Component, OnInit, ViewChild, Input } from '@angular/core';
import { NgForm } from '@angular/forms';
import { PostService } from 'src/app/services/postservice/post.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-post-solution',
  templateUrl: './post-solution.component.html',
  styleUrls: ['./post-solution.component.css']
})
export class PostSolutionComponent implements OnInit {

  @ViewChild('postSolution', {static: false}) 
  taskPostForm: NgForm;

  content: string;

  constructor(private postService: PostService, private activatedRoute: ActivatedRoute) { }

  taskId: number = 0;

  ngOnInit() {
    this.activatedRoute.queryParams.subscribe(params => {
      console.log('param1', params.taskId);
      console.log('param2', params);
      this.taskId = params.taskId;
    });
  }

  onSubmit() {
    const data = {
      content: this.content,
      type: "SOLUTION",
      taskId: this.taskId,
      userId: 1
    }
    console.log(data);
    this.postService.postSolution(data);
  } 
}
