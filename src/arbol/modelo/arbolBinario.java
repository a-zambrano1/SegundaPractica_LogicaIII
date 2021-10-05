
package arbol.modelo;

import java.awt.Component;
import java.util.Stack;
import javax.swing.JOptionPane;
import java.lang.Math;

public class arbolBinario {
    private nodoArbol raiz;

    public arbolBinario (Object dato){
        this.raiz = new nodoArbol(dato);
        initComponents();
    }
    
    public arbolBinario(){
        
    }



    boolean esVacio(){
        boolean vacio = false;
        if(getRaiz() == null){
            vacio = true;
        }
        return vacio;
    }
    
    public void posOrden(nodoArbol r){
        if(r != null){
            posOrden(r.getHijoIzq());
            posOrden(r.getHijoDer());
            System.out.println(r.getDato());
        }
    }

    public void preOrden(nodoArbol r){
        if(r != null){
            System.out.println(r.getDato());
            preOrden(r.getHijoIzq());
            preOrden(r.getHijoDer());
        }
    }

    public void inorden(nodoArbol r){
        if(r!=null){
            inorden(r.getHijoIzq());
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane, r.getDato());
            inorden(r.getHijoDer());
        }
    }

    public void insertarNodo(Object dato){
        nodoArbol hoja = new nodoArbol(dato);
        if(esVacio()){
            asignaRaiz(hoja);
        }else{
            nodoArbol aux = getRaiz();
            nodoArbol padre= null;
            while(true){
               padre = aux;
               if((Integer)dato < (Integer)aux.getDato()){
                  aux = aux.getHijoIzq();
                    if(aux == null){
                        padre.setHijoIzq(hoja);
                        return;
                    }
               }else{
                   aux = aux.getHijoDer();
                   if(aux == null){
                       padre.setHijoDer(hoja);
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
        raiz.setDato(s.charAt(i));
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
    
    //Construccion por recorridos
    
    nodoArbol[] stringToVector(String g){
        nodoArbol[] nodos = new nodoArbol[g.length()];
        nodoArbol aux;
        
        int comas = 0;
        for (int i = 0; i <g.length(); i++) {
            if(String.valueOf(g.charAt(i)).equals(",")){
                comas++;
            }
        }
        
        for (int i=0; i<comas+1;i++) {
            int pos = g.indexOf(",");
            
            if (pos!=(-1)){
                aux = new nodoArbol(g.substring(0, pos));
                nodos[i]= aux;
                g=g.substring(pos+1,g.length());
            }
            else{
                aux = new nodoArbol(g);
                nodos[i]= aux;
            }
        }
        return nodos;
    }
  

    void inOrden(String g){
        nodoArbol[] nodos= stringToVector(g);
        
        if(nodos.length==1){
            this.raiz=nodos[0];
        } 
        else if(nodos.length>1){
            nodoArbol hijoIz;
            nodoArbol hijoDe;
            nodoArbol padre;
            int pos=0;

            while (pos<nodos.length) {
                if(pos+2<nodos.length){
                    hijoIz=nodos[pos];
                    padre=nodos[pos+1];
                    hijoDe=nodos[pos+2];

                    padre.setHijoIzq(hijoIz);
                    padre.setHijoDer(hijoDe);

                    pos+=4;
                }
                else if(pos+1<nodos.length){
                    hijoIz=nodos[pos];
                    padre=nodos[pos];

                    padre.setHijoIzq(hijoIz);
                }
            }
            inOrden(reduccionVector(nodos));
        }
        else{
            System.out.println("El arbol está vacio)");
        }
    }
    
    void inOrden(nodoArbol[] g){
        nodoArbol[] nodos= g;
        
        if(nodos.length==1){
            this.raiz=nodos[0];
        } 
        else if(nodos.length>1){
            nodoArbol hijoIz;
            nodoArbol hijoDe;
            nodoArbol padre;
            int pos=0;

            while (pos<nodos.length) {
                if(pos+2<nodos.length){
                    hijoIz=nodos[pos];
                    padre=nodos[pos+1];
                    hijoDe=nodos[pos+2];

                    padre.setHijoIzq(hijoIz);
                    padre.setHijoDer(hijoDe);

                    pos+=4;
                }
                else if(pos+1<nodos.length){
                    hijoIz=nodos[pos];
                    padre=nodos[pos];

                    padre.setHijoIzq(hijoIz);
                }
            }
            inOrden(reduccionVector(nodos));
        }
        else{
            System.out.println("El arbol está vacio)");
        }
    }
    void posOrden(String g){
        nodoArbol[] nodos= stringToVector(g);
        
        if(nodos.length==1){
            this.raiz=nodos[0];
        } 
        else if(nodos.length>1){
            nodoArbol hijoIz;
            nodoArbol hijoDe;
            nodoArbol padre;
            int pos=0;

            while (pos<nodos.length) {
                if(pos+2<nodos.length){
                    hijoDe=nodos[pos];
                    padre=nodos[pos+1];
                    hijoIz=nodos[pos+2];

                    padre.setHijoIzq(hijoIz);
                    padre.setHijoDer(hijoDe);

                    pos+=4;
                }
                else if(pos+1<nodos.length){
                    hijoDe=nodos[pos];
                    padre=nodos[pos];

                    padre.setHijoIzq(hijoDe);
                }
            }
            inOrden(reduccionVector(nodos));
        }
        else{
            System.out.println("El arbol está vacio)");
        }
    }
    
    void posOrden(nodoArbol[] g){
        nodoArbol[] nodos= g;
        
        if(nodos.length==1){
            this.raiz=nodos[0];
        } 
        else if(nodos.length>1){
            nodoArbol hijoIz;
            nodoArbol hijoDe;
            nodoArbol padre;
            int pos=0;

            while (pos<nodos.length) {
                if(pos+2<nodos.length){
                    hijoDe=nodos[pos];
                    padre=nodos[pos+1];
                    hijoIz=nodos[pos+2];

                    padre.setHijoIzq(hijoIz);
                    padre.setHijoDer(hijoDe);

                    pos+=4;
                }
                else if(pos+1<nodos.length){
                    hijoDe=nodos[pos];
                    padre=nodos[pos];

                    padre.setHijoIzq(hijoDe);
                }
            }
            inOrden(reduccionVector(nodos));
        }
        else{
            System.out.println("El arbol está vacio)");
        }
    }
    
    void preOrden(String g){
        nodoArbol[] nodos = stringToVector(g);
        int i = 0;
        int t= g.length()-1;
        int k=Math.round((t-i+1)/2);
        
        if(k!=0){
            if( (i+1)<nodos.length && (i+k+1)<nodos.length){
                nodos[i].setHijoIzq(nodos[i+1]);
                nodos[i].setHijoIzq(nodos[i+k+1]);
                preOrden(i+1,i+k,nodos);
                preOrden(i+k+1,t,nodos);
            }
            else if((i+1)<nodos.length){
                nodos[i].setHijoIzq(nodos[i+1]);
            }
        }
    }

void preOrden(int i, int t,nodoArbol[] nodos){
        int k=Math.round((t-i+1)/2);
        
        if(k!=0){
            if( (i+1)<nodos.length && (i+k+1)<nodos.length){
                nodos[i].setHijoIzq(nodos[i+1]);
                nodos[i].setHijoIzq(nodos[i+k+1]);
                preOrden(i+1,i+k,nodos);
                preOrden(i+k+1,t,nodos);
            }
            else if((i+1)<nodos.length){
                nodos[i].setHijoIzq(nodos[i+1]);
            }
        }
}
    
    nodoArbol[] reduccionVector(nodoArbol[] nodos){
        nodoArbol[] aux;
        int tamaño =0;
        for (int i = 0; i < nodos.length; i++) {
            if(nodos[i].getPadre()==null){
                tamaño++;
            }
        }
        
        aux =new nodoArbol[tamaño];
        
        int pos = 0;
        while (aux[tamaño-1]==null) {            
            if(nodos[pos].getPadre()==null){
                aux[pos]= nodos[pos].getPadre();
            }
            pos++;
        }
        return aux;
    }
   
    private void initComponents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the raiz
     */
    public nodoArbol getRaiz() {
        return raiz;
    }

    /**
     * @param raiz the raiz to set
     */
    public void setRaiz(nodoArbol raiz) {
        this.raiz = raiz;
    }
}    
