
export class Educacion {

    id?: number;
    nombreE: string;
    //ponemos lo que esta en entity yo agregue instituto
    institutoE: string;
    descripcionE: string;

    constructor(nombreE: string, institutoE: string, descripcionE: string) {
        this.nombreE = nombreE;
        this.institutoE =  institutoE;
        this.descripcionE = descripcionE;
    }

}
