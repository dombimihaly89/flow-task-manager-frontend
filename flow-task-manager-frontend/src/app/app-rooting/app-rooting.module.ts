import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from '../dashboard/dashboard.component'
import { NavBarComponent } from '../nav-bar/nav-bar.component';
import { TasklistComponent } from '../task/tasklist/tasklist.component';
import { TaskComponent } from '../task/task.component';

const routes: Routes = [
  {
    path: 'tasklist',
    component: TasklistComponent
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
