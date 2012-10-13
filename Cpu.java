
public class Cpu {
	
	private Queue cpuq;
	private long max;
	private Statistics s;
	private Gui g;
	
	private Process activeP;

	public Cpu (Queue cpuq, long maxtime, Statistics s, Gui g){
		this.cpuq = cpuq;
		max = maxtime;
		this.s = s;
		this.g = g;
	}
	
	public long getMaxTime(){
		return max;
	}
	
	/**
	 * 
	 * @param t
	 */
	public void timePassed(long t){
		s.cpuQLenT += cpuq.getQueueLength() * t;
		if(cpuq.getQueueLength() > s.cpuLarLen){
			s.cpuLarLen = cpuq.getQueueLength();
		}
	}
	
	/**
	 * adding a process to the cpu queue
	 * @param p
	 */
	public void addProc(Process p){
		cpuq.insert(p);
	}
	
	/**
	 * checking if the cpu is in use
	 * returing true if it is active
	 * @return
	 */
	public boolean inUse(){
		if(activeP != null) return true;
		else return false;
	}
	
	/**
	 * returning the active process 
	 * setting active to null
	 * @return
	 */
	public Process getActive(){
		Process p = activeP;
		activeP = null;
		return p;
	}
	
	/**
	 * start method for CPU. reutring process
	 * if the queue has a value the next value is removed
	 * and set to the active cpu process
	 * gui updatet
	 * 
	 * if it is empty active is null
	 * and cpu is idle
	 * @return
	 */
	public Process start(){
		if(!cpuq.isEmpty()){
			Process p = (Process) cpuq.removeNext();
			activeP = p;
			g.setCpuActive(p);
			return p;
		}else {
			activeP = null;
			g.setCpuActive(null);
			return null;
		}
	}
}
