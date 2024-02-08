import { Component } from '@angular/core';
import { CatService } from '../../services/cat.service';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

  constructor(private catService: CatService){}
  ngOnInit(){
    this.catService.getCats().subscribe(cats=>{
      console.log(cats);
    });
  }
}