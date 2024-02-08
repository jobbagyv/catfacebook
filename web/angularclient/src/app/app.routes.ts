import { Routes } from '@angular/router';
import { HomeComponent } from '../components/home/home.component';
import { UserProfileComponent } from '../components/user-profile/user-profile.component';

export const routes: Routes = [
    {component: HomeComponent, path: "home"}, 
    {component: UserProfileComponent, path: "profile"},
    {path:'**', redirectTo: '/home'}
];
