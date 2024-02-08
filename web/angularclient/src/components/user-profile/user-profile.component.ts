import { Component } from '@angular/core';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-user-profile',
  standalone: true,
  imports: [],
  templateUrl: './user-profile.component.html',
  styleUrl: './user-profile.component.css'
})
export class UserProfileComponent {

  constructor(private userService: UserService){

  }
  ngOnInit(){
    this.userService.getUser().subscribe(user=>{
      console.log(user);
    });
  }

}
