import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginComponent } from '../login/login.component';
import { CargarScriptsService } from './../../cargar-scripts.service';

@Component({
  selector: 'app-logo-ap',
  templateUrl: './logo-ap.component.html',
  styleUrls: ['./logo-ap.component.css']
})
export class LogoAPComponent implements OnInit {

  constructor( private _CargaScripts:CargarScriptsService, private router:Router) {

    _CargaScripts.Carga(["logores"]);
  }
 
  ngOnInit(): void {
  }

    login(){
      this.router.navigate(['/login'])
    }

}
