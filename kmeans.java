import java.util.*;

class Kmeans{

	static Scanner scn = new Scanner(System.in);
	static int k,n;
	static int[] arr = new int[20];
	static int[] cluster = new int[20];
	static float[] dist = new float[20];
	static float[] k_arr = new float[10];
	static int change = 0;

public static void main(String args[]){

	System.out.println("Enter no. of elements: ");
	n = scn.nextInt();
	
	System.out.println("Enter elements");
	int i;
	for(i=0;i<n;i++)
	{
		arr[i] = scn.nextInt();
	}
	System.out.println("Enter value of K:");
	k = scn.nextInt();
	
	formCluster();
	getMeans();
	for(i=0;i<n;i++)
	{
		dist[i] = Math.abs(arr[i] - k_arr[cluster[i]-1]);
	}
	
	runKmeans();
	
}

public static void formCluster(){

	int i,j;
	int n1 = n;
	int k1 = k;
	int iter = 0;
	for (i=0;i<k;i++)
	{
		int d = n1/k1;
		for (j=iter;j<iter+d;j++)
		{
			cluster[j] = k1;
		}
		n1 = n1-d;
		k1--;
		iter = j;
	}

}

public static void getMeans(){

	int i,j;
	int k1 = k-1;
	int count=0;
	for (i=0;i<k;i++)
	{
	count=0;
		for(j=0;j<n;j++)
		{
			if (cluster[j] == k1+1)
			{
				k_arr[k1] = k_arr[k1] + arr[j];
				count++;
			}
		}
		k_arr[k1] = k_arr[k1] / count;
		k1--;
	}

}

public static void runKmeans(){

	int i,change=1,j;
	float min;
	for (int m=0;m<10;m++)
	{
		change=0;
		for(i=0;i<n;i++)
		{
		
			for (j=0;j<k;j++)
			{	
				min = Math.abs(arr[i] - k_arr[j]);
				if (min < dist[i])
				{
					//System.out.print("Hitting if");
					cluster[i] = j+1;
					change=1;
				}
			}
		
		}
		getMeans();
	
	}
	for(i=0;i<n;i++)
	{
		System.out.print(cluster[i]);
	}
	

}

}