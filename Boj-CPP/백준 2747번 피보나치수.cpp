#include<iostream>
using namespace std;

int main()
{
	int num;
	cin>>num;
	int *arr=new int[num+1];
	
	arr[0]=0;
	arr[1]=1;
	for(int i=2; i<=num; i++)
	arr[i]=arr[i-1]+arr[i-2];
	
	cout<<arr[num];
	
}
