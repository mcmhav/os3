/**
 * This class contains a lot of public variables that can be updated
 * by other classes during a simulation, to collect information about
 * the run.
 */
public class Statistics
{
	/** The number of processes that have exited the system */
	public long nofCompletedProcesses = 0;
	public long nofCreatedProcesses = 0;
	public long cpuForce = 0;
	public long ioOper = 0;
	//average
	
	public long cpuTotT = 0;
	public long fractTimeP = 0;
	public long totalTimeSpentWaitingForMemory = 0;
	public long fractTimeW = 0;
	
	public long memoryQueueLargestLength = 0;
	public long memoryQueueLengthTime = 0; //average
	public long cpuLarLen = 0;
	public long cpuQLenT = 0; //average
	public long ioLarLen = 0;
	public long ioQLenT = 0; //average
	public long totNoTimeInRQ = 0;//average
	public long totNoTimeInIOQ = 0;//average
	//average
	//average
	
	public long ioTotT = 0;
	public long totTWaitForIO = 0;
	public long totTSpentInRQ = 0;
	public long totSysT = 0;
	
    
	/**
	 * Prints out a report summarizing all collected data about the simulation.
	 * @param simulationLength	The number of milliseconds that the simulation covered.
	 */
	public void printReport(long simulationLength) {
		System.out.println();
		System.out.println("Simulation statistics:");
		System.out.println();
		System.out.println("Number of completed processes:                                "+nofCompletedProcesses);
		System.out.println("Number of created processes:                                  "+nofCreatedProcesses);
		System.out.println("Number of (forced) process switches:                          " + cpuForce);
    	System.out.println("Number of processed I/O operations:                           " + ioOper);
    	System.out.println("Average throughput (processes per second):                    " + (float) nofCompletedProcesses / simulationLength * 1000);
		System.out.println();
		System.out.println("Total CPU time spent processing:                              " + cpuTotT + " ms");
		System.out.println("Fraction of CPU time spent processing:                        " + (float) cpuTotT / simulationLength * 100 + " %");
		System.out.println("Total CPU time spent waiting:                                 " + totalTimeSpentWaitingForMemory + " ms");
		System.out.println("Fraction of CPU time spent waiting:                           " + (float) (simulationLength - cpuTotT) / simulationLength * 100 + " %");
		System.out.println();
		System.out.println("Largest occuring memory queue length:                         "+memoryQueueLargestLength);
		System.out.println("Average memory queue length:                                  "+(float)memoryQueueLengthTime/simulationLength);
		System.out.println("Largest occuring cpu queue length:                            " + cpuLarLen);
		System.out.println("Average cpu queue length:                                     " + (float) cpuQLenT/simulationLength);
		System.out.println("Largest occuring I/O queue length:                            " + ioLarLen);
		System.out.println("Average I/O queue length:                                     " + (float) ioQLenT/simulationLength);
		if(nofCompletedProcesses > 0) {
			System.out.println("Average # of times a process has been placed in memory queue: "+1);
			System.out.println("Average # of times a process has been placed in cpu queue:    " + totNoTimeInRQ/nofCompletedProcesses);
			System.out.println("Average # of times a process has been placed in I/O queue:    " + totNoTimeInIOQ/nofCompletedProcesses);
			System.out.println();
			System.out.println("Average time spent in system per process:                     " + totSysT/nofCompletedProcesses + " ms");
			System.out.println("Average time spent waiting for memory per process:            "+ totalTimeSpentWaitingForMemory/nofCompletedProcesses+" ms");
			System.out.println("Average time spent waiting for cpu per process:               " + totTSpentInRQ/nofCompletedProcesses + " ms");
			System.out.println("Average time spent processing per process:                    " + cpuTotT/nofCompletedProcesses + " ms");
			System.out.println("Average time spent waiting for I/O per process:               " + totTWaitForIO/nofCompletedProcesses + " ms");
			System.out.println("Average time spent in I/O per process:                        " + ioTotT/nofCompletedProcesses + " ms");
		}
	}
}
