import { Task } from './task';
import { User } from './user';

export class Post {

  id : number;

  content : string;

  createdAt = [];

  updatedAt = [];

  deletedAt = [];

  type : string;

  task : Task;

  user : User;

  comments : Post[];
}
