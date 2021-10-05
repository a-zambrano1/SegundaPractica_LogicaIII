package arbol.modelo;


public class nodoArbol {
    private nodoArbol hijoDer, hijoIzq;
    private Object dato;
    private nodoArbol padre;

    public nodoArbol(Object dato){
        this.dato = dato;
        this.hijoDer = null;
        this.hijoIzq = null;
    }
    
    public nodoArbol(){
        
    }

    /**
     * @return the hijoDer
     */
    public nodoArbol getHijoDer() {
        return hijoDer;
    }

    /**
     * @param hijoDer the hijoDer to set
     */
    public void setHijoDer(nodoArbol hijoDer) {
        this.hijoDer = hijoDer;
    }

    /**
     * @return the hijoIzq
     */
    public nodoArbol getHijoIzq() {
        return hijoIzq;
    }

    /**
     * @param hijoIzq the hijoIzq to set
     */
    public void setHijoIzq(nodoArbol hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    /**
     * @return the dato
     */
    public Object getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(Object dato) {
        this.dato = dato;
    }

    /**
     * @return the padre
     */
    public nodoArbol getPadre() {
        return padre;
    }

    /**
     * @param padre the padre to set
     */
    public void setPadre(nodoArbol padre) {
        this.padre = padre;
    }
}
