
public class IO {

	private Queue ioq;
	private Statistics s;
	private long avgIo;
	private Gui g;
	
	private Process activeP;
	
	public IO(Queue ioq, Statistics s, long avgIo, Gui g){
		this.ioq = ioq;
		this.s = s;
		this.g = g;
		this.avgIo = avgIo;
		activeP = null;
	}
	
	/**
	 * setting time passeds
	 * @param t
	 */
	public void timePassed(long t){
		s.ioQLenT += ioq.getQueueLength() * t;
		if(ioq.getQueueLength() > s.ioLarLen){
			s.ioLarLen = ioq.getQueueLength();
		}
 	}
	
//	public void addProcess(Process p){
//		ioq.insert(p);
//		if(activeP == null) start();
//	}
//	
//	public boolean ioB(){
//		if(activeP == null) return true;
//		return false;
//	}
	
	/**
	 * adding a new a new process to the IO queue
	 * if there is no active process there is started one
	 * 
	 * uses the booleans in the simulators class
	 * @param p
	 * @return
	 */
	public boolean addProcess(Process p) {
		ioq.insert(p);
		if (activeP == null) {
			start();
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * if the IO queue is empty there is no process to return
	 * else returning the next process in the queue.
	 * updating the gui.
	 * @return
	 */
	public Process start(){
		if(ioq.isEmpty()){
			return null;
		}
		Process p = (Process) ioq.removeNext();
		activeP = p;
		g.setIoActive(p);
		return p;
	}
	
	/**
	 * returning the active process
	 * and setting the active to 0
	 */
	public Process getProc(){
		Process p = activeP;
		activeP = null;
		g.setIoActive(null);
		return p;
	}
	
	/**
	 * generating average IO time based on the user input
	 * @return
	 */
	public long getAvgIo() {
		return (long) (Math.random() * (avgIo * 2) + avgIo / 2);
	}
}
