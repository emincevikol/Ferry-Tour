package ferry;
import java.util.*;

public class FerryTour {
	
    ///////////////////////////////////////////////////
	/////
	/////		Operating Systems - II. Project
	/////
	/////		120315013 -	M.Emin Çevikol
	/////		120316018 -	Sefa Hezer
	/////
	/////
	///////////////////////////////////////////////////

	public static Vehicle[] Vehicle;
    static int ferryState[]={0,0}; 
    static int car=10;
    static int minibus=8;
    static int truck=8;
    static int ferryCapacity=minibus+car+truck;

	public static void main(String[] args) throws InterruptedException {
      
       
		Vehicle = new Vehicle[ferryCapacity];
       
        for (int i = 0; i < car; i++) {
        	Vehicle[i] = new Vehicle(i,"car",0);
        }
        for (int i = car; i < car+minibus; i++) {
        	Vehicle[i] = new Vehicle(i,"minibus",0);
        }
        for (int i = minibus+car; i < ferryCapacity; i++) {
        	Vehicle[i] = new Vehicle(i,"truck",0);
 
        }
        for (int i = 0; i < ferryCapacity; i++) {
        	Vehicle[i].start();
        }
        
        inf();
		
		inf();
	      
		System.out.println("Kafileler tamamlandý A yakasýndakiler B'ye, B yakasýndakiler A'ya geçmiþ oldu.");
	
		inf();
		
		inf();
		
		System.out.println("Tur baþarýyla tamamlandý.");
	    
	}
	public static void inf() throws InterruptedException{
		Thread.sleep(200);
		System.out.println("-------------------------------------");
		Thread.sleep(1200);
		System.out.println("-------------------------------------");
		System.out.printf("1.Feribot:%d  2.Feribot:%d\n",+ferryState[0],+ferryState[1]);
		System.out.println("-------------------------------------");
		       
		Thread.sleep(1000);
		System.out.println("-------------------------------------");
		System.out.println("Feribotlar hedeflerine ulaþtý.");
		System.out.println("-------------------------------------");
			 
		Thread.sleep(1000);
		System.out.println("-------------------------------------");
		ferryState[0]=0;
		ferryState[1]=0;
		System.out.println("Feribotlar yolcularýný indiriyor.");
		System.out.println("-------------------------------------");
		
	}
	

}
	