package arbol.modelo;


public class nodoArbol {
    private nodoArbol hijoDer, hijoIzq;
    private Object dato;

    public nodoArbol retornaHijoDer() {
        return hijoDer;
    }

    public void asignaHijoDer(nodoArbol hijoDer) {
        this.hijoDer = hijoDer;
    }

    public nodoArbol retornaHizoIzq() {
        return hijoIzq;
    }

    public void asignaHizoIzq(nodoArbol hizoIzq) {
        this.hijoIzq = hizoIzq;
    }

    public Object retornaDato() {
        return dato;
    }

    public void asignaDato(Object dato) {
        this.dato = dato;
    }

    public nodoArbol(Object dato){
        this.dato = dato;
        this.hijoDer = null;
        this.hijoIzq = null;
    }
    
    public nodoArbol(){
        
    }
}
