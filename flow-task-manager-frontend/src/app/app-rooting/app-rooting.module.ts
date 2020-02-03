import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from '../dashboard/dashboard.component'
import { NavBarComponent } from '../nav-bar/nav-bar.component';
import { TasklistComponent } from '../task/tasklist/tasklist.component';
import { TaskComponent } from '../task/task.component';
import { TaskpostComponent } from '../task/taskpost/taskpost.component';
import { PostSolutionComponent } from '../post/post-solution/post-solution.component';
import { PostListComponent } from '../post/post-list/post-list.component';
import { UserregistrationComponent } from '../user/userregistration/userregistration.component';

const routes: Routes = [
  {
    path: 'tasklist',
    component: TasklistComponent
  },
  {
    path: 'taskpost',
    component: TaskpostComponent
  },
  {
    path: 'postSolution',
    component: PostSolutionComponent
  },
  {
    path: 'postlist',
    component: PostListComponent
  },
  {
    path: 'userregistration',
    component: UserregistrationComponent
  }
];

@NgModule({
    imports: [
        RouterModule.forRoot(routes)
    ],
    exports: [
        RouterModule
    ],
    declarations: []
})
export class AppRoutingModule { }
