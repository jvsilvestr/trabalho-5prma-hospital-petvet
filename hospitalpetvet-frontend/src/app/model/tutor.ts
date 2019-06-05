import { Animal } from './animal';

export class Tutor {
    codigo: string;
    nome: string;
    cpf: string;
    telefone: string;
    email: string;
    estado: string;
    cidade: string;
    cep: string;
    numero: string;
    complemento: string;
    animais: Array<Animal> = new Array();
}
