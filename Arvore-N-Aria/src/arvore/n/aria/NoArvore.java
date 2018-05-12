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
public class NoArvore <T>{
    public T info;
    public NoArvore<T> primeiro;
    public NoArvore<T> proximo;
    
    public NoArvore(T info){
        this.setInfo(info);
        this.setPrimeiro(null);
        this.setProximo(null);
    }

    public void inserirFilho(NoArvore<T> sa){
        sa.setProximo(this.primeiro);
        this.setPrimeiro(sa);
    }
    
    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NoArvore getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(NoArvore primeiro) {
        this.primeiro = primeiro;
    }

    public NoArvore getProximo() {
        return proximo;
    }

    public void setProximo(NoArvore proximo) {
        this.proximo = proximo;
    }
    
    
}
