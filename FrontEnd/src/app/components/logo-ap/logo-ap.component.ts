import { Component, OnInit } from '@angular/core';
import { CargarScriptsService } from './../../cargar-scripts.service';

@Component({
  selector: 'app-logo-ap',
  templateUrl: './logo-ap.component.html',
  styleUrls: ['./logo-ap.component.css']
})
export class LogoAPComponent implements OnInit {

  constructor( private _CargaScripts:CargarScriptsService) {

    _CargaScripts.Carga(["logores"]);
  }

  ngOnInit(): void {
  }

}
