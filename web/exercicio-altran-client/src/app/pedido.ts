import { ItemCarrinho } from './itemCarrinho';
import { Usuario } from './usuario';

export class Pedido {
    id: string;
    items: ItemCarrinho[];
    usuario: Usuario;

}