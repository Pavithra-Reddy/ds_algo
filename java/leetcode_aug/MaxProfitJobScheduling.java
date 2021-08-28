package leetcode_aug;

import java.util.Arrays;

public class MaxProfitJobScheduling {

	public static void main(String[] args) {
		int[] startTime = {1,2,3,4,6};
		int[] endTime = {3,5,10,6,9};
		int[] profit = {20,20,100,70,60};
		System.out.println(jobScheduling(startTime, endTime, profit));

	}

	public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
		int n = startTime.length;
		Job jobs[] = new Job[n];
		for (int i = 0; i < n; i++) {
			jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
		}

		Arrays.sort(jobs, (a, b) -> Integer.compare(a.endTime, b.endTime));

		int max[] = new int[n];
		max[0] = jobs[0].profit;
		for (int i = 1; i < n; i++) {
			max[i] = Math.max(jobs[i].profit, max[i - 1]);
			for (int j = i - 1; j >= 0; j--) {
				if (jobs[j].endTime <= jobs[i].startTime) {
					max[i] = Math.max(max[i], jobs[i].profit + max[j]);
					break;
				}
			}
		}

		int res = Integer.MIN_VALUE;
		for (int num : max) {
			if (res < num) {
				res = num;
			}
		}
		return res;
	}
}

class Job {
	int startTime;
	int endTime;
	int profit;

	Job(int startTime, int endTime, int profit) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.profit = profit;
	}
}
