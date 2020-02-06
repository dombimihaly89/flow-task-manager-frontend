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
import { UserloginComponent } from '../user/userlogin/userlogin.component';
import { LoginComponent } from '../login/login.component';
import { AuthGuard } from '../auth/auth-guard';

const routes: Routes = [
  {
    path: 'tasklist',
    component: TasklistComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'taskpost',
    component: TaskpostComponent,
    canActivate: [AuthGuard]

  },
  {
    path: 'postSolution',
    component: PostSolutionComponent,
    canActivate: [AuthGuard]

  },
  {
    path: 'postlist',
    component: PostListComponent,
    canActivate: [AuthGuard]

  },
  {
    path: 'register',
    component: UserregistrationComponent
  },
  {
    path: 'login',
    //component: UserloginComponent
    component: LoginComponent
  },
  { path: '**', redirectTo: 'tasklist' }
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
