export class Experiencia {
    id?: number;
    nombreE: string;
    descripcionE: string;
    empresaE: string;
    fechaE: string;

    constructor(nombreE: string, descripcionE: string, empresaE: string, fechaE: string) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.empresaE = empresaE;
        this.fechaE = fechaE;
    }
}
