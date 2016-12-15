package ferry;
import java.util.*;
public class Vehicle extends Thread implements Runnable {
	
	public  String type,port;
	public  int count;
	public  int portState=0;
	Random r = new Random();
	
	public Vehicle(int count,String type,int portState) {
		this.type = type;
		this.count=count;
		this.portState=portState;	// port state �ift say� ise yaka �zerinde, tek say� ise feribotta demektir.
	}
	
	public void run(){
		
		initialize(); //initialize randomly distribute to the ports and tolls.
			wait(1000);
		forward();
			wait(2000);
		forward();
			wait(2000);
		backward();
			wait(2000);
		backward();
	}
	
	public void initialize(){
		try{
			int t=r.nextInt(999)%2, k=r.nextInt(999)%2;
				
			switch (t){
				case 0:
					port="A";
					if(k==1){
						System.out.printf("%s yakas�nda %d. %s 1. gi�eden biletini ald�\n",port, count,type);
					}
					else if(k==0){
						System.out.printf("%s yakas�nda %d. %s 2. gi�eden biletini ald�\n",port, count,type);			
					}
					break;
					
				case 1:
					port="B";
					if(k==1){
						System.out.printf("%s yakas�nda %d. %s 3. gi�eden biletini ald�\n",port, count,type);
					}
					else if(k==0){
						System.out.printf("%s yakas�nda %d. %s 4. gi�eden biletini ald�\n",port, count,type);
					}	
					break;
		
				default:
					System.out.println("Hata!!");
					break;
			}
		}
		catch (Exception e) {
	        throw new IllegalStateException(e);
	    }
	}
		
	public void forward(){
		getFerry(port,0);  //Ara�lar feribota biner, port state 1 artt�r�l�r.
		wait(1000);
		startTour();
		endTour();		//Ara�lar feribotan iner, port state 1 artt�r�l�r.
	}
	
	public void backward(){
		getFerry(port,2);
		wait(1000);
		startTour();
		endTour();
	}
	
	public void getFerry(String port,int j){
		if(portState==j){
			int i=-1;
			if(port=="A")
				i=0;
			if(port=="B")
				i=1;
			
				if(type=="car"&&FerryTour.ferryState[i]<20){
					FerryTour.ferryState[i]+=1;
					System.out.printf("+%s yakas�nda %d. %s feribota bindi\n",port,count,type);
					portState++;
			
				}
				else if(type=="minibus" && FerryTour.ferryState[i]+2<20){
					FerryTour.ferryState[i]+=2;
					System.out.printf("+%s yakas�nda %d. %s feribota bindi\n",port,count,type);
					portState++;
				}
				else if(type=="truck" && FerryTour.ferryState[i]+3<20){
					FerryTour.ferryState[i]+=3;
					System.out.printf("+%s yakas�nda %d. %s feribota bindi\n",port,count,type);
					portState++;
				}
				else{
					wait(200);
					System.out.printf("-%s yakas�ndaki %d. %s i�in feribotta yer kalmad�\n",port,count,type);	
				}
		}
	}

	public void startTour(){
		if(portState==1 || portState==3 ){
		switch(port){
			case "A":
				System.out.printf("%d. %s %s feribotuyla yola ��kt�\n",count,type,port );
				port="B";
				break;
			case "B":
				System.out.printf("%d. %s %s feribotuyla yola ��kt�\n",count,type,port );
				port="A";
				break;
			default:
				break;
			}
		}
		else{
			wait(200);
			System.out.printf("%d. %s %s Yakas�nda bekliyor\n",count,type,port );
		}
	}

	public void endTour(){
		if(portState==1 || portState==3)
			portState++;
	}
	
	public static void wait(int i){
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
