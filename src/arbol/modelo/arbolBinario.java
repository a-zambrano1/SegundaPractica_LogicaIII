
package arbol.modelo;

import java.awt.Component;
import java.util.Stack;
import javax.swing.JOptionPane;
import java.lang.Math;
import java.util.Random;

public class arbolBinario {
    private nodoArbol raiz;
    
    nodoArbol aux;
    
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
    
    //Construccion por recorridos
    /**
     * A partir de una entrada String g construye un vector con 
     * x cantidad de nodos contenidos en g, segun el formato planteado
     * cada nombre de nodo esta separado por comas.
     * @param g Entrada string para un arbol, cada nodo debe estar separado
     * por coma ",".
     * @return devuelve el vector de nodos construido.
     */
    private nodoArbol[] stringToVector(String g){
        g=procesaString(g);
        
        int comas = 0;
        
        for (int i = 0; i <g.length(); i++) {
            if(String.valueOf(g.charAt(i)).equals(",")){
                comas++;
            }
        }
        
        nodoArbol[] nodos = new nodoArbol[comas+1];
        nodoArbol aux;
 
        for (int i=0; i<=comas+1;i++) {
            int pos = g.indexOf(",");
            
            if (pos!=(-1)){
                aux = new nodoArbol(g.substring(0, pos));
                nodos[i]= aux;
                g=g.substring(pos+1);
            }
            else{
                aux = new nodoArbol(g);
                nodos[i]= aux;
            }
        }
        return nodos;
    }
    
    /**
     * Prepara el String ingresado para el correcto desarrollo del
     * proceso de conversion a Vector.
     * @param g
     * @return 
     */
    private String procesaString(String g){
        g.replace(" ", "");
        
        while(g.indexOf(",,")!=(-1)){
            g.replace(",,", ",");
        }
        
        while(String.valueOf(g.charAt(0)).equals(",")){
            g=g.substring(1);
        }
        
        while(String.valueOf(g.charAt(g.length())).equals(",")){
            g=g.substring(0,g.length()-1);
        }
        
        return g;
    }
  
    /**
     * A partir de una entrada String g construye un arbol binario
     * con base en el recorrido in orden expresado en g 
     * @param g recorrido in orden del arbol ingresado. Cada
     * nodo debe estar separado por coma.
     */
    public void inOrden(String g){
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
                    padre=nodos[pos+1];

                    padre.setHijoIzq(hijoIz);
                }
            }
            inOrden(reduccionVector(nodos));
        }
        else{
            System.out.println("El arbol está vacio)");
        }
    }
    
    /**
     * A partir de una entrada nodoArbol[] g construye un arbol binario
     * con base en el recorrido in orden expresado en g.
     * @param g 
     */
    private void inOrden(nodoArbol[] g){
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
                    padre=nodos[pos+1];

                    padre.setHijoIzq(hijoIz);
                }
            }
            inOrden(reduccionVector(nodos));
        }
        else{
            System.out.println("El arbol está vacio)");
        }
    }
    
    /**
     * A partir de una entrada String g construye un arbol binario
     * con base en el recorrido pos orden expresado en g.
     * @param g 
     */
    public void posOrden(String g){
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
                    padre=nodos[pos+1];

                    padre.setHijoIzq(hijoDe);
                }
            }
            inOrden(reduccionVector(nodos));
        }
        else{
            System.out.println("El arbol está vacio)");
        }
    }
    
    /**
     * A partir de una entrada nodoArbol[] g construye un arbol binario
     * con base en el recorrido pos orden expresado en g.
     * @param g 
     */
    private void posOrden(nodoArbol[] g){
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
                    padre=nodos[pos+1];

                    padre.setHijoIzq(hijoDe);
                }
            }
            inOrden(reduccionVector(nodos));
        }
        else{
            System.out.println("El arbol está vacio)");
        }
    }
    
    /**
     * A partir de una entrada String g construye un arbol binario
     * con base en el recorrido pre orden expresado en g.
     * @param g 
     */
    public void preOrden(String g){
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
    
    /**
     * A partir de una entrada nodoArbol[] nodos, un parametro de inicio i
     * y un parametro de fin t construye un arbol binario con base en el 
     * recorrido pos orden expresado en el vector.
     * @param i posicion de inicio en el vector
     * @param t posicion de fin en le vector
     * @param nodos vector con los nodos del arbol
     */
    private void preOrden(int i, int t,nodoArbol[] nodos){
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
    /**
     * Contruye un vector nuevo en el que almacena solo los nodos aun sin 
     * procesar.
     * @param nodos Vector con nodos.
     * @return 
     */
    private nodoArbol[] reduccionVector(nodoArbol[] nodos){
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
                aux[pos]= nodos[pos];
            }
            pos++;
        }
        return aux;
    }
    
    /**
     * Vector booleanos para controlar que por cada nodo se habilitan dos
     * posiciones para conectar sus hijos
     * @param vetor Vector booleano que controla posiciones disponibles
     * @param in Inicio para organizar las posiciones disponibles
     * @param n  Final hasta donde se organiza las posiciones disponibles
     */
    public void disponibilidad(boolean[] vetor, int in, int n){
        for(int i=in; i<= n; i++){
            vetor[i] = true;
        }
    }
    /**
     * Creamos un vector de nodos para controlar
     * la conexion con sus hijos aleatoriamente
     * @param datos Vector de nodos donde estan los datos ingresados por el usuario
     * @return Vector de nodos con las posiciones de hijos y padres
     */
    public nodoArbol[] arbolCompleto(nodoArbol[] datos){
        Random rnd = new Random();
        nodoArbol[] arbol = new nodoArbol[(int) (Math.pow(2, datos.length)-1)];
        boolean[] espaciosDisponibles = new boolean[arbol.length];
        arbol[0] = datos[0];
        disponibilidad(espaciosDisponibles,1, 2);
        for(int i=1; i<datos.length; i++){
            while(true){
                int pos = rnd.nextInt(2*(i-1)+2);
                if(espaciosDisponibles[pos] == true){
                    arbol[pos] = datos [i];
                    disponibilidad(espaciosDisponibles,2*pos+1,2*pos+2);
                    espaciosDisponibles[pos] = false;
                    break;
                }
            }
        }
        return arbol;
    }
    
    /**
     * Creamos un árbol totalmente aleatorio
     * a partir de una cadena ingresada por el usuario
     * @param s Cadena ingresada por el usuario
     */
    public void aleatorioDatos(String s){
        if(s == ""){
            //IMPRESION DE CADENA VACÍA
        }
        nodoArbol[] datos = stringToVector(s);
        nodoArbol[] arbolCompleto = arbolCompleto(datos);
        nodoArbol aux = null;
        this.setRaiz(datos[0]);
        for(int i=1; i< arbolCompleto.length; i++) {
            if(arbolCompleto[i] != null){
                aux = arbolCompleto[i];
                if (i == 1) {
                    this.raiz.setHijoIzq(aux);
                    aux.setPadre(this.raiz);
                } else if (i == 2) {
                    this.raiz.setHijoDer(aux);
                    aux.setPadre(this.raiz);
                } else if (i % 2 == 0) {
                    arbolCompleto[(i / 2) - 1].setHijoDer(aux);
                    aux.setPadre(arbolCompleto[(i / 2) - 1]);
                } else {
                    arbolCompleto[i / 2].setHijoIzq(aux);
                    aux.setPadre(arbolCompleto[i / 2]);
                }
            }else{
                continue;
            }
        }
    }
    /**
     * Generamos un vector de nodos, donde cada nodo contiene una letra
     * del abecedario aleatoria
     * @param n Tamaño del árbol inicial
     * @return Vector de nodos
     */
    public nodoArbol[] generarDatosAleatorios(int n) {
        String[] abc = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        nodoArbol[] nodos = new nodoArbol[n];
        nodoArbol aux;
        Random rnd = new Random();
        for(int i=0; i< n; i++){
            while(true){
                int alea = rnd.nextInt(26);
                if(abc[alea] != null){
                    aux = new nodoArbol(abc[alea]);
                    nodos[i] = aux;
                    abc[alea] = null;
                    break;
                }
            }
        }
        return nodos;
    }
    
    /**
     * Creamos árbol aleatorio a partir de un
     * vector de nodos con datos del abecedario
     * @param n 
     */
    public void aleatorioPorTamaño(int n){
        if(n<=0){
            System.out.println("Tamaño del árbol es vacío. No se creará ninguno.");
            return;
        }
        if(n>=26){
            System.out.println("Exceso de tamaño. Error");
            return;
        }
        nodoArbol[] datos = generarDatosAleatorios(n);
        nodoArbol[] arbolCompleto = arbolCompleto(datos);
        nodoArbol aux = null;
        this.setRaiz(datos[0]);
        for(int i=1; i< arbolCompleto.length; i++) {
            if(arbolCompleto[i] != null){
                aux = arbolCompleto[i];
                if (i == 1) {
                    this.raiz.setHijoIzq(aux);
                    aux.setPadre(this.raiz);
                } else if (i == 2) {
                    this.raiz.setHijoDer(aux);
                    aux.setPadre(this.raiz);
                } else if (i % 2 == 0) {
                    arbolCompleto[(i / 2) - 1].setHijoDer(aux);
                    aux.setPadre(arbolCompleto[(i / 2) - 1]);
                } else {
                    arbolCompleto[i / 2].setHijoIzq(aux);
                    aux.setPadre(arbolCompleto[i / 2]);
                }
            }else{
                continue;
            }
        }
        //inorden(this.raiz);
    }
    
    public void nodito(nodoArbol x, String dato){
        if(x != null){
            if(dato.compareTo(x.getDato().toString()) == 0){
                this.aux = x;
                return;
            }
            nodito(x.getHijoIzq(),dato);
            nodito(x.getHijoDer(), dato);
        }

    }

    public nodoArbol llamado(nodoArbol x, String dato){
        this.aux = null;
        nodito(x,dato);
        return this.aux;
}

    public int contarHijos(nodoArbol x, String dato){
        nodoArbol aux = llamado(x,dato);
        int hijos=0;
        if(aux.getHijoIzq() != null){
            hijos=hijos+1;
        }
        if(aux.getHijoDer() != null){
            hijos=hijos+1;
        }
        return hijos;
}

    public String elPadre(nodoArbol x, String dato) {
        String mensaje;
        nodoArbol aux = llamado(x,dato);
        if(aux.getPadre() == null){
            mensaje = "Es la raíz. No tiene papá.";
            return mensaje;
        }
        mensaje = "El padre del nodo " + dato + " es " + aux.getPadre().getDato();
        return mensaje;
}

    public String abuelo(nodoArbol x, String dato){
        String mensaje;
        nodoArbol aux = llamado(x,dato);
        if(aux.getPadre() == null){
            mensaje = "Es la raíz. No tiene abuelo";
            return mensaje;
        }
        if(aux.getPadre().getPadre() == null){
            mensaje = "No tiene abuelo.";
            return mensaje;
        }
        mensaje = "El abuelo del nodo " + dato + " es " + aux.getPadre().getPadre().getDato();
        return mensaje;
}

    public String hermanito(nodoArbol x, String dato){
        String mensaje;
        nodoArbol aux = llamado(x,dato);
        if(aux == this.raiz){
            mensaje="no tiene hermanos.";
            return mensaje;
        }
        if(aux.getPadre().getHijoIzq() == aux){
            if(aux.getPadre().getHijoDer() != null){
                mensaje = (String) aux.getPadre().getHijoDer().getDato();
                return mensaje;
            }
        }else{
            if(aux.getPadre().getHijoIzq() != null){
                mensaje = (String) aux.getPadre().getHijoIzq().getDato();
                return mensaje;
            }
        }
        return mensaje = "no tiene.";
}

    public String tio(nodoArbol x, String dato){
        String mensaje;
        nodoArbol aux = llamado(x,dato);
        if(aux.getPadre() == null){
            mensaje = "El nodo es la raíz. No tiene tío.";
            return mensaje;
        }
        if(aux.getPadre() == this.raiz){
            mensaje="El papá del nodo es la raíz. La raíz no tiene hermanos.";
            return mensaje;
        }
        mensaje = "El tio del nodo "+dato+" es "+ hermanito(aux.getPadre(),(String) aux.getPadre().getDato());
        return mensaje;
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
