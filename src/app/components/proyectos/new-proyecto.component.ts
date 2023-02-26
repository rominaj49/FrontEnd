import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Proyecto } from 'src/app/model/proyecto';
import { ProyectoService } from 'src/app/service/proyecto.service';


@Component({
  selector: 'app-new-proyecto',
  templateUrl: './new-proyecto.component.html',
  styleUrls: ['./new-proyecto.component.css']
})
export class NewProyectoComponent implements OnInit {

  nombre: string = " ";
  descripcion: string = " ";
  githublink: string= " ";
  pagelink: string= " ";

  constructor(private proyS: ProyectoService, private router: Router) { }

  ngOnInit(): void {
  }

  onCreate(): void{
    const proyecto = new Proyecto(this.nombre, this.descripcion, this.githublink, this.pagelink);
    this.proyS.save(proyecto).subscribe(
      data => {
        alert("proyecto creada");
        this.router.navigate(['']);
      }, err =>{
        alert("Error al añadir la proyecto");
        this.router.navigate(['']);
      }
    )
  }
  
}
