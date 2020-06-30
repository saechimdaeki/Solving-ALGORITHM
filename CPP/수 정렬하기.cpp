#include<iostream>
using namespace std;

void bubblesort(int arr[],int n)
{
	int temp;
	for(int i=0;i<n;i++)
	{
		for(int j=0; j<(n-i)-1; j++)
		{
			if(arr[j]>arr[j+1])
			{
				temp=arr[j];
				arr[j]=arr[j+1];
				arr[j+1]=temp;
			}
		}
	}
 } 
 
 int main(){
 	int c;
 	cin>>c;
 	int arr[c];
 	for(int i=0;i<c;i++)
 	{
	 	cin>>arr[i];
	 	bubblesort(arr,c);
 	}
 	for(int i=1;i<=c;i++)
 	cout<<arr[i]<<endl;
 	
 }
