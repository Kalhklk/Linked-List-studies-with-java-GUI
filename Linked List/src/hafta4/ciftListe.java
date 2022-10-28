/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hafta4;

class cEleman{
    int icerik;
    cEleman ileri;
    cEleman geri;

    public cEleman(int icerik) {
        this.icerik = icerik;
        ileri = null;
        geri = null;
    }
    
}
public class ciftListe {
    cEleman bas;

    public ciftListe() {
        bas = null;
    }
    
    void basaEkle(cEleman yeni){
        if (bas==null) {
            bas=yeni;
        }
        else{
            yeni.ileri=bas;
            bas.geri=yeni;
            bas=yeni;
        }
    }
    void sonaEkle(cEleman yeni){
        if(bas==null)
            bas=yeni;
        else{
            cEleman tmp=bas;
            while(tmp.ileri!=null){
                tmp=tmp.ileri;                                             
            }
            tmp.ileri=yeni;
            yeni.geri=tmp;
        }
    }
    void bastanSil(){
        if (bas!=null) {
            if (bas.ileri==null) {
                bas=null;
            } else {
                bas=bas.ileri;
                bas.geri=null;
            }
        } 
    }
    String listele(){
        String s=" ";
        cEleman tmp=bas;
        while (tmp!=null) {            
            s=s+tmp.icerik+"<-->";
            tmp=tmp.ileri;
        }
        return s;
    }
    String terstenListele(){
        String s="";
        cEleman tmp=bas;
        while (tmp.ileri!=null) {            
            tmp=tmp.ileri;
        }
        while (tmp!=null) {            
            s=s+tmp.icerik+"<-->";
            tmp=tmp.geri;
            
        }
        return s;
        
        
    }
    int enBuyukBul(){
        cEleman tmp=bas;
        int enb=tmp.icerik;
        while (tmp!=null) {            
            if (tmp.icerik>enb) {
                enb=tmp.icerik;
            }
            tmp=tmp.ileri;
            
        }
        return enb;
    }
    void siraliEkle(cEleman yeni){
        if (bas==null) {
            bas=yeni;
        }
        else if (bas.icerik>=yeni.icerik) {
            yeni.ileri=bas;
            bas.geri=yeni;
            bas=yeni;
        }
        else{
            cEleman tmp=bas;
            while (tmp.ileri!=null && tmp.ileri.icerik<yeni.icerik) {                
                tmp=tmp.ileri;
            }
            yeni.ileri=tmp.ileri;
            if (tmp.ileri!=null) {
                yeni.ileri.geri=yeni;                
            }
            tmp.ileri=yeni;
            yeni.geri=tmp;
        }
    }
    
}
