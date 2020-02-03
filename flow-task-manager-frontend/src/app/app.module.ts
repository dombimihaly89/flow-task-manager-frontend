import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { HttpClientModule } from '@angular/common/http';
import {MatInputModule} from '@angular/material/input';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HeaderComponent } from './header/header.component';
import { TaskComponent } from './task/task.component';
import { TasklistComponent } from './task/tasklist/tasklist.component';
import { TaskpostComponent } from './task/taskpost/taskpost.component';
import { LoginComponent } from './login/login.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { LayoutModule } from '@angular/cdk/layout';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AppRoutingModule } from './app-rooting/app-rooting.module';
import {MatFormFieldModule} from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material';
import { FormsModule } from '@angular/forms';
import { PostComponent } from './post/post.component';
import { PostSolutionComponent } from './post/post-solution/post-solution.component';
import { PostListComponent } from './post/post-list/post-list.component';
import { UserComponent } from './user/user.component';
import { UserregistrationComponent } from './user/userregistration/userregistration.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    TaskComponent,
    TasklistComponent,
    TaskpostComponent,
    LoginComponent,
    NavBarComponent,
    DashboardComponent,
    PostComponent,
    PostSolutionComponent,
    PostListComponent,
    UserComponent,
    UserregistrationComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatButtonModule,
    HttpClientModule,
    MatInputModule,
    LayoutModule,
    MatToolbarModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    AppRoutingModule,
    MatFormFieldModule,
    MatSelectModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
