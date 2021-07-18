/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NTLAHLA W
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // TODO code application logic here
 
         //create subject
         NewsSite eNCASubj = new NewsSite("eNCA");
         NewsSite isolezweSubj = new NewsSite("Isolezwe");

         //create observers
         Observer zukisaObs1 = new Subscriber("Zukisa");
         Observer musaObs1 = new Subscriber("Musa");
         Observer lundiObs = new Subscriber("Lundi");
         Observer zukisaObs2 = new Subscriber("Zukisa");
         Observer musaObs2 = new Subscriber("Musa");

         //register observers to the subject
         eNCASubj.register(zukisaObs1);
         eNCASubj.register(musaObs1);
         eNCASubj.register(lundiObs);
         isolezweSubj.register(zukisaObs2);
         isolezweSubj.register(musaObs2);
         //attach observers to subject
         zukisaObs1.setSubject(eNCASubj);
         musaObs1.setSubject(eNCASubj);
         lundiObs.setSubject(eNCASubj);
         zukisaObs2.setSubject(isolezweSubj);
         musaObs2.setSubject(isolezweSubj);
         //now send message to subject
         eNCASubj.publishLatestNewsHeadline("Zuma sentenced to jail");
         isolezweSubj.publishLatestNewsHeadline("UZuma ejele");
         eNCASubj.publishLatestNewsHeadline("JACOB ZUMA JAILED");
         isolezweSubj.publishLatestNewsHeadline("Bawu-6 asebeshonile babe ngu-219 asebeboshiwe kusuka izibhelu");
        // TODO code application logic here 
    }
    
}
