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
        if (no.getInfo() == info) {
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
        return contarNos(raiz);
    }

    private int contarNos(NoArvore no){
        int contador = 1;
        NoArvore<T> aux = no.getPrimeiro();
        
        
        while (aux != null) {
            contador += contarNos(aux.getProximo());
            aux = aux.getProximo();
        }
        
        return contador;
    }
    private String obterRepresentacaoTextual(NoArvore<T> no) {
        String s = "<";
        NoArvore<T> p = no.getPrimeiro();
        s = s + no.info;
        
        while (p != null) {
            s = s + obterRepresentacaoTextual(p);
            p = p.getProximo();
        }
        
        s = s + ">";
        
        return s;
    }

    
    
}
