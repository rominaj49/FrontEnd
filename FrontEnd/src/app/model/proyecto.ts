export class Proyecto {
    id: number;
    nombre: string;
    descripcion: string;
    githublink: string;
    pagelink: string;
    
    constructor(nombre:string, descripcion:string, githublink: string, pagelink: string ){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.githublink = githublink;
        this.pagelink = pagelink;
    }
}
