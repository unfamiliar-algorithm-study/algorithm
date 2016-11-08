/**
 * 
 */
package timon;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.security.auth.callback.Callback;

/**
 * @author yenos
 * @date 2016. 11. 4.
 * 
 * 티몬바리스타별 음료 분배하기.
 * 
 */
public class Main {

	//스레드 풀을 이용한다.스레드풀은 몇개의 스레드를 어떻게 돌릴지에대한이야기를한다 (여기서 최소 4개 그리고 스레드가 끝나야만 다음스레드를 추가로 넣을수있도록 구성하였다)
	static ThreadPoolExecutor threadPool ;
	
	
	//음식 을 표현하기위해 임시로 상수화하였
	static final int AMERICANO = 100;
	static final int ESPRESOO = 101;
	static final int FRUIT = 102;
	static final int LATTE = 103;
	//바리스타상태 표현하기위해 임시로 상수화하였다 
	static final int BARIFRUIT= 0;
	static final int BARIDEFAULT= 1;
	static final int BARISLOWAMER= 2;
	static final int BARISLOWLATTE= 3;
	
	//현재 바리스타가 얼마나 일했는 초를 가지고있는 어레이다.
	static  ArrayList<Integer> workCount = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//
		ArrayList<Integer> orderQueue = new ArrayList<>();
		
		//임시로 주문이 아래와같이 진행된다고가정하자.

		orderQueue.add(ESPRESOO);
		orderQueue.add(AMERICANO);
		orderQueue.add(FRUIT);
		orderQueue.add(LATTE);
		orderQueue.add(ESPRESOO);
		orderQueue.add(ESPRESOO);
		orderQueue.add(AMERICANO);
		orderQueue.add(FRUIT);
		orderQueue.add(LATTE);
		orderQueue.add(ESPRESOO);
		orderQueue.add(ESPRESOO);
		orderQueue.add(AMERICANO);
		orderQueue.add(FRUIT);
		orderQueue.add(LATTE);
		orderQueue.add(ESPRESOO);
		
	
		//기본 시작전임으로 workCount를 0 초로 초기화한다. 
		workCount.add(0);
		workCount.add(0);
		workCount.add(0);
		workCount.add(0);
		
		//스레드풀을만든다. 4개의 스레드풀을 만들고타임아웃을 60으로 선언한다. 큐옵션으로 task를 순차적으로 쌓는다.즉 먼저끝난스레드다음으로 다음스레드를 얹게한다.
		threadPool = new ThreadPoolExecutor( 4, 4, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>()  );
			
		int dequeType = 0;
	
		//orderQuee는 arraylist이기때문에 0번째를 뽑아내고 while마지막에서 0번째를 삭제해줘 큐와같이사용되는데
		//큐에 아무것도 없기전까지 계속 와일문을 돌게된다.
		while(orderQueue.size()!=0){
			System.out.println("run");

			//디큐로 뽑아온 음료 타입이다.
			dequeType =orderQueue.get(0);
			
		//만약 뽑아온것이 과일이다.
		if(dequeType == FRUIT){
			//그럼 과일주스 바리가 노는지 확인하고 놀고있으면 넣어주고 아니면 가장 초가 적은곳으로.. 
			if(workCount.get(BARIFRUIT)==0){
//				System.out.println("과일바리스타[EMPTY] ==> 과일을 우선처리합니다 ");
				bariFruit(dequeType);
			}else{
				//여기서 가장 적은초인 곳으로 넘겨주면된다.
				int smallCount = workCount.get(0);
				int smallIndex=0;
				for(int i=1;i<4;i++){

					if(smallCount>workCount.get(i)){
						smallIndex = i;
					}
					
				}
				//가장적은 인덱스를 찾아 해당 음료를실행시킨다.
				getSmallestPeople(smallIndex,dequeType);
				
			}
		}
		// 빠져나오데이터가 아메리카노일경우.
		else if(dequeType==AMERICANO){
			//슬로우 아메리카노 바리스타가 놀고있다..
			if(workCount.get(BARISLOWAMER)==0){
				//남초가 가장작은 곳에 넣어주기만하면된다. 단 가장작은곳이 슬로우아메리카노바리스타가 받지만 않으면된다.
				int smallCount = workCount.get(0);
				int smallIndex=0;
				for(int i=1;i<4;i++){

					if(i==BARISLOWAMER){
					}else{
						if(smallCount>workCount.get(i)){
							smallIndex = i;
						}	
					}
				}
				getSmallestPeople(smallIndex,dequeType);
				
				
			
			//슬로우 아메리카노가 일을하고있다.
			}else{
				
				//여기서 가장  적은 곳으로 넘겨주기만하면된다.
				
				int smallCount = workCount.get(0);
				int smallIndex=0;
				for(int i=1;i<4;i++){

					if(i==BARISLOWAMER){
						
					}else{
						if(smallCount>workCount.get(i)){
							smallIndex = i;
						}	
					}
					
				}
				//헌데가장 작은값이 슬로우 아메리카노바리스타 타임이랑 동타일수있따. 
				//이런경우 슬로우아메리카노바리스타에게일을 맡겨서는안될것이다.
				if(workCount.get(smallIndex)==workCount.get(BARISLOWAMER)){
					getSmallestPeople(smallIndex,dequeType);

					//동타가 아니고 슬로아바리스타가 더작을경우 슬로바리스타를 이용할것이다.					
				}else if(workCount.get(smallIndex)>workCount.get(BARISLOWAMER)){
					getSmallestPeople(BARISLOWAMER,dequeType);	
					//아무조건에 맞지안흔다면 그냥 런해주면된
				}else{
					getSmallestPeople(smallIndex,dequeType);
				}
				
				
			}
			
		}
		//라테일경우.
		else if(dequeType==LATTE){
			//라테가 차여있지 않는다
			if(workCount.get(BARISLOWLATTE)==0){
				
				int smallCount = workCount.get(0);
				int smallIndex=0;
				for(int i=1;i<4;i++){
						//바리슬로우면 smallIndex에 영향을 주지않는다.
					if(i==BARISLOWLATTE){
						
					}else{
						if(smallCount>workCount.get(i)){
							smallIndex = i;
						}	
					}
				}
				getSmallestPeople(smallIndex,dequeType);
				
				
			}else{
				//아메리카노랑 마찬가지이다.
				int smallCount = workCount.get(0);
				int smallIndex=0;
				for(int i=1;i<4;i++){

					if(i==BARISLOWLATTE){
						
					}else{
						if(smallCount>workCount.get(i)){
							smallIndex = i;
						}	
					}
					
				}
				//헌데가장 작은값이 슬로우 아메리카노바리스타 타임이랑 동타일수있따. 
				//이런경우 슬로우아메리카노바리스타에게일을 맡겨서는안될것이다.
				if(workCount.get(smallIndex)==workCount.get(BARISLOWLATTE)){
					getSmallestPeople(smallIndex,dequeType);

					//동타가 아니고 슬로아바리스타가 더작을경우 슬로바리스타를 이용할것이다.					
				}else if(workCount.get(smallIndex)>workCount.get(BARISLOWLATTE)){
					getSmallestPeople(BARISLOWLATTE,dequeType);	
					//아무조건에 맞지안흔다면 그냥 런해주면된
				}else{
					getSmallestPeople(smallIndex,dequeType);
				}

			}
			
			//에스프레소는 조건이없기때문에아무곳에 넘겨줘도된
		}else if(dequeType==ESPRESOO){
			//여기서 가장 적은가 적은 곳으로 넘겨주면된다.
			int smallCount = workCount.get(0);
			int smallIndex=0;
			for(int i=1;i<4;i++){

				if(smallCount>workCount.get(i)){
					smallIndex = i;
				}
				
			}
			getSmallestPeople(smallIndex,dequeType);			
		}
			orderQueue.remove(0);
    		
			try {
				Thread.sleep( 1000 );
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
	}
	
	//가장작은 사람인 i가 해당 입무를 수행한다.
	public static void getSmallestPeople(int i,int dequeType){
			if(i==BARIDEFAULT){
				bariDefault(dequeType);
			}else if(i==BARIFRUIT){
				bariFruit(dequeType);
			}else if(i==BARISLOWAMER){
				bariSlowAmeri(dequeType);
			}else if(i==BARISLOWLATTE){
				bariSlowLatte(dequeType);
			}
			
		
	}
	public static void bariFruit(int type){
		
		threadPool.execute( new Runnable()
        {
            public void run()
            {
            	System.out.println("과일  바리스타가 " + type+"을 처리합니다.");

//                System.out.println( System.currentTimeMillis()+" Thread " + Thread.currentThread().getName() + " Start" );
                

            	//과일바리스타의 물건이들어왔을떄의 걸리는시간이다.
                try{
                	if(type==ESPRESOO){
                    	workCount.set(BARIFRUIT, 2);
                		Thread.sleep( 2000 );
                	}else if(type==AMERICANO){
                		workCount.set(BARIFRUIT, 3);
                		Thread.sleep( 3000 );
                	}else if(type==FRUIT){
                		workCount.set(BARIFRUIT, 4);
                		Thread.sleep( 4000 );	
                	}else if(type==LATTE){
                		workCount.set(BARIFRUIT, 4);
                		Thread.sleep( 4000 );
                	}
                	
                	
                } catch( Exception e ) {} 
                
//                System.out.println( System.currentTimeMillis()+" Thread " + Thread.currentThread().getName() + " End" );
                workCount.set(BARIFRUIT, 0);
            }
        } );
	}
	public static void bariSlowAmeri(int type){
		
		threadPool.execute( new Runnable()
        {
            public void run()
            {
            	System.out.println("슬로우아메리카 바리스타가 " + type+"을 처리합니다.");
            	
            	
//                System.out.println( System.currentTimeMillis()+" Thread " + Thread.currentThread().getName() + " Start" );
                
                try{ 
                	if(type==ESPRESOO){
                		workCount.set(BARISLOWAMER, 2);
                		Thread.sleep( 2000 );
                	}else if(type==AMERICANO){
                		workCount.set(BARISLOWAMER, 4);
                		Thread.sleep( 4000 );
                	}else if(type==FRUIT){
                		workCount.set(BARISLOWAMER, 5);
                		Thread.sleep( 5000 );	
                	}else if(type==LATTE){
                		workCount.set(BARISLOWAMER, 4);
                		Thread.sleep( 4000 );
                	}
                	
                	} catch( Exception e ) {} 
                
//                System.out.println( System.currentTimeMillis()+" Thread " + Thread.currentThread().getName() + " End" );
                workCount.set(BARISLOWAMER, 0);
            }
        } );
	}
	
	public static void bariDefault(int type){
		threadPool.execute( new Runnable()
        {
            public void run()
            {
            	System.out.println("디폴트 바리스타가 " + type+"을 처리합니다.");
//                System.out.println( System.currentTimeMillis()+" Thread " + Thread.currentThread().getName() + " Start" );
                
                try{ 
                	if(type==ESPRESOO){
                		workCount.set(BARIDEFAULT, 2);
                		Thread.sleep( 2000 );
                	}else if(type==AMERICANO){
                		workCount.set(BARIDEFAULT, 3);
                		Thread.sleep( 3000 );
                	}else if(type==FRUIT){
                		workCount.set(BARIDEFAULT, 5);
                		Thread.sleep( 5000 );	
                	}else if(type==LATTE){
                		workCount.set(BARIDEFAULT, 4);
                		Thread.sleep( 4000 );
                	}
                	
                	} catch( Exception e ) {} 
                
//                System.out.println( System.currentTimeMillis()+" Thread " + Thread.currentThread().getName() + " End" );
                workCount.set(BARIDEFAULT, 0);
            }
        } );
	}
		

	public static void bariSlowLatte(int type){
		threadPool.execute( new Runnable()
        {
            public void run()
            {
            	System.out.println("슬로우라테 바리스타가 " + type+"을 처리합니다.");
            	
//                System.out.println( System.currentTimeMillis()+" Thread " + Thread.currentThread().getName() + " Start" );
                
                try{ 
                	if(type==ESPRESOO){
                		workCount.set(BARISLOWLATTE, 2);
                		Thread.sleep( 2000 );
                	}else if(type==AMERICANO){
                		workCount.set(BARISLOWLATTE, 3);

                		Thread.sleep( 3000 );
                	}else if(type==FRUIT){
                		workCount.set(BARISLOWLATTE, 5);
                		Thread.sleep( 5000 );	
                	}else if(type==LATTE){
                		workCount.set(BARISLOWLATTE, 5);
                		Thread.sleep( 5000 );
                	}
                	
                	} catch( Exception e ) {} 
                
//                System.out.println( System.currentTimeMillis()+" Thread " + Thread.currentThread().getName() + " End" );
                workCount.set(BARISLOWLATTE, 0);
            }
        } );
	}
}
