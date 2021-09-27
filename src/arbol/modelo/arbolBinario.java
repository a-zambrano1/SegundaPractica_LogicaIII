
package arbol.modelo;

import java.awt.Component;
import java.util.Stack;
import javax.swing.JOptionPane;


public class arbolBinario {
    private nodoArbol raiz;

    public arbolBinario (Object dato){
        this.raiz = new nodoArbol(dato);
        initComponents();
    }
    
    public arbolBinario(){
        
    }

    public nodoArbol retornaRaiz() {
        return raiz;
    }

    public void asignaRaiz(nodoArbol raiz) {
        this.raiz = raiz;
    }

    boolean esVacio(){
        boolean vacio = false;
        if(raiz == null){
            vacio = true;
        }
        return vacio;
    }
    
    public void posOrden(nodoArbol r){
        if(r != null){
            posOrden(r.retornaHizoIzq());
            posOrden(r.retornaHijoDer());
            System.out.println(r.retornaDato());
        }
    }

    public void preOrden(nodoArbol r){
        if(r != null){
            System.out.println(r.retornaDato());
            preOrden(r.retornaHizoIzq());
            preOrden(r.retornaHijoDer());
        }
    }

    public void inorden(nodoArbol r){
        if(r!=null){
            inorden(r.retornaHizoIzq());
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane, r.retornaDato());
            inorden(r.retornaHijoDer());
        }
    }

    public void insertarNodo(Object dato){
        nodoArbol hoja = new nodoArbol(dato);
        if(esVacio()){
            asignaRaiz(hoja);
        }else{
            nodoArbol aux = raiz;
            nodoArbol padre= null;
            while(true){
               padre = aux;
               if((Integer)dato < (Integer)aux.retornaDato()){
                  aux = aux.retornaHizoIzq();
                    if(aux == null){
                        padre.asignaHizoIzq(hoja);
                        return;
                    }
               }else{
                   aux = aux.retornaHijoDer();
                   if(aux == null){
                       padre.asignaHijoDer(hoja);
                       return;
                   }
               }
            }
        }
    }
    
    public void crearArbolCadena(String s){
        int n = s.length();
        int i = 2;
        nodoArbol raiz = new nodoArbol();
        raiz.asignaDato(s.charAt(i));
        for(i = 3; i < n ; i++){
            switch(s.charAt(i)){
                case '(':
                    continue;
                case ',':
                    continue;
                case ')':
                    continue;
                default:
                    int dat = Character.getNumericValue(s.charAt(i));
                    insertarNodo(dat);
            }
        }
    }

    private void initComponents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}    
