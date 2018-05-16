/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvore.n.aria;

/**
 *
 * @author gwestarb
 */
public class Arvore<T> {
    
    private NoArvore<T> raiz;
    
    public Arvore(){
        this.setRaiz(null);
    }

    public NoArvore<T> getRaiz() {
        return raiz;
    }
 
    public void setRaiz(NoArvore<T> raiz) {
        this.raiz = raiz;
    }
    
    public String toString(){
        if (this.raiz == null) {
            return "";
        }
        else{
            return obterRepresentacaoTextual(this.raiz);
        }
    }
    
    public boolean pertence(T info){
        if (this.raiz == null) {
            return false;
        }
        else{
            return pertence(this.raiz, info);
        }
        
    }
    
    private boolean pertence(NoArvore<T> no, T info) {
        if (no.getInfo().equals(info)) {
            return true;
        }
        else{
            NoArvore<T> p = no.getPrimeiro();
            while (p != null) {
                if (pertence(p, info)) {
                    return true;
                }
                p = p.getProximo();
            }
            
            return false;
        }
    }
    
    public int contarNos(){
        if (raiz == null) {
            return 0;
        }else{
            return contarNos(getRaiz());
        }
    }

    private int contarNos(NoArvore no){
        int contador = 1;
        NoArvore<T> p = no.getPrimeiro();
        while (p != null) {
            contador += contarNos(p);
            p = p.getProximo();
        }
        
        return contador;
    }
    
    public NoArvore<T> buscar(T info){
        if (getRaiz() == null) {
            return null;
        }else{
            return buscar(getRaiz(), info);
        }
    }
    
    
    private NoArvore<T> buscar(NoArvore<T> no, T info) {
        if (no.getInfo().equals(info)) {
            return no;
        }else{
            NoArvore<T> p = no.getPrimeiro();
            while (p != null) {
                
                NoArvore<T> noLocalizado = (buscar(p, info));
                if (noLocalizado != null) {
                    return noLocalizado;
                }else{
                    p = p.getProximo();
                }
                
            }
            return null;
        }
    }
    
    private String obterRepresentacaoTextual(NoArvore<T> no) {
        String s = "<";
        s += no.getInfo();
        
        NoArvore<T> p;
        p = no.getPrimeiro();
        while (p != null) {
            s += obterRepresentacaoTextual(p);
            p = p.getProximo();
        }
        
        s += ">";
        
        return s;
    }

    
}
