public class War{
	public static void main(String[] args)throws Exception{
		General g=new General("曹操");
		Soldier s=new Soldier("典韦",15);
		int count=0;
		while(count<3){
			s.eat();
			count++;
			System.out.println("第"+count+"进攻");
			try{
				g.direct(s);
			}catch (HurmException e) {			
				System.out.println(e.getMessage());
				s.blood=15;
				if(count==3){
					System.out.println("战役结束");
					break;
				}				
			}catch (GoDieException e) {//e=new GoDieException()
				System.out.println(e.getMessage());										
				throw e;//throw new GoDieException();									
			}
		}		
	}
}
abstract class Junren{
	abstract void eat()throws Exception;
}
class Soldier extends Junren{
	String name;
	int blood;

	public Soldier(String name,int blood){
		this.name=name;
		this.blood=blood;
	}
	public void fightWar(){
		System.out.println("打仗");
		for (int i=0; i<15; i++) {
			blood=blood-1;
		}
		if(blood>0&&blood<6){
			throw new HurmException("士兵受重伤了");
		}
		if(blood<=0){
			throw new GoDieException("士兵牺牲了");
		}
	}
	public void eat()throws Exception{
		System.out.println("吃饭");
	}
}

class General{
	String name;

	public General(String name){
		this.name=name;
	}
	public void direct(Soldier s){
		s.fightWar();
	}	
}
class GoDieException extends RuntimeException{
	public GoDieException(String msg){
		super(msg);
	}
}
class HurmException extends RuntimeException{
	public HurmException(String msg){
		super(msg);
	}
}