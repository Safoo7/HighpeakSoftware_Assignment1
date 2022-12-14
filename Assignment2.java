package com.jsp.highpeak;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Assignment2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of jobs");
		int noofJobs=scanner.nextInt();
		List<Jobs> jobList= new ArrayList<>();
		if(noofJobs<=100) {
			for(int i=0;i<noofJobs;i++) {
				System.out.println("Enter Start Time of job");
		int startTime=scanner.nextInt();
		System.out.println("Enter End time of job");
		int endTime=scanner.nextInt();
		System.out.println("Enter the profit");
		int profit=scanner.nextInt();
		jobList.add(jobDetails(startTime, endTime, profit));
			}
			//this below line we are getting list of valid jobs which has started time less than ending time
			List<Jobs> filteredList = jobList.stream().filter((e1)-> e1.getStartTime()<e1.getEndTime()).collect(Collectors.toList());
			filteredList.remove(filteredList.stream().max((e1,e2)->e1.getProfit()-e2.getProfit()).get());
			int size = filteredList.size();
			int totalProfit=0;
			for(int i=0;i<size;i++) {
				Jobs j= filteredList.get(i);
				totalProfit=totalProfit+j.getProfit();
			}
			int []arr= {size,totalProfit};
			System.out.println("No of jobs remaning ="+arr[0]);
			System.out.println("Total profit that can be earned by the employee = "+arr[1]);
			
			
		}else {
			System.out.println("no of Jobs is greater than limit");
		}
	}
	public static Jobs jobDetails(int startTime,int endTime,int profit) {
		Jobs jobs  = new Jobs();
		jobs.setStartTime(startTime);
		jobs.setEndTime(endTime);
		jobs.setProfit(profit);
		return jobs;
		
	}

}
  
class Jobs{
	private int startTime;
	private int endTime;
	private int profit;
	public int getStartTime() {
		return startTime;
	}
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	public int getEndTime() {
		return endTime;
	}
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	public int getProfit() {
		return profit;
	}
	public void setProfit(int profit) {
		this.profit=profit;
	}
}



