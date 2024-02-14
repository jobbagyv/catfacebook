import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HeaderComponent } from "../components/header/header.component";
import { FooterComponent } from "../components/footer/footer.component";
import { NavComponent } from "../components/nav/nav.component";
import {MatSidenavModule} from '@angular/material/sidenav';

@Component({
    selector: 'app-root',
    standalone: true,
    templateUrl: './app.component.html',
    styleUrl: './app.component.css',
    imports: [RouterOutlet, HeaderComponent, FooterComponent, NavComponent, MatSidenavModule]
})
export class AppComponent {
  title = 'angularclient';
  
}
