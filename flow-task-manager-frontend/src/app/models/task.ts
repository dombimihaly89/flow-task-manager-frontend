import { User } from './user';
import { Post } from './post';

export class Task {

    constructor(

    id : number,

    type : string,

    title : string,

    content : string,

    difficulty : string,

    createdAt : number[],

    updatedAt : number[],

    deletedAt : number[],

    ratings : number[],

    mentorName : string,

    userIds : number,

    postIds : number
    ){};

    id : number;

    type : string;

    title : string;

    content : string;

    difficulty : string;

    createdAt : number[];

    updatedAt : number[];

    deletedAt : number[];

    ratings : number[];

    mentorName : string;

    userIds : number;

    postIds : number
}
