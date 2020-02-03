import { Task } from './task';
import { Post } from './post';

export class User {

    id : number;

    username : string;

    password : string;

    firstName : string;

    lastName : string;

    dateOfBirth : string;

    role : string;

    tasks : Task[];

    posts : Post[];

}
