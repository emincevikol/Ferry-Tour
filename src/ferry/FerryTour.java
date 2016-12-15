package ferry;
import java.util.*;

public class FerryTour {
	
    ///////////////////////////////////////////////////
	/////
	/////		Operating Systems - II. Project
	/////
	/////		120315013 -	M.Emin �evikol
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
	      
		System.out.println("Kafileler tamamland� A yakas�ndakiler B'ye, B yakas�ndakiler A'ya ge�mi� oldu.");
	
		inf();
		
		inf();
		
		System.out.println("Tur ba�ar�yla tamamland�.");
	    
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
		System.out.println("Feribotlar hedeflerine ula�t�.");
		System.out.println("-------------------------------------");
			 
		Thread.sleep(1000);
		System.out.println("-------------------------------------");
		ferryState[0]=0;
		ferryState[1]=0;
		System.out.println("Feribotlar yolcular�n� indiriyor.");
		System.out.println("-------------------------------------");
		
	}
	

}
	