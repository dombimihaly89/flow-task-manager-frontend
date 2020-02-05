import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

import { simpleUser } from './simple-user';

@Injectable()
export class DataService {

  public dataSource = new BehaviorSubject<simpleUser>(null);

  constructor() { }
  
}
