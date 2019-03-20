#include<iostream>
using namespace std;

int arr[5][4];
int sum[5];

int main()
{
	int compa(0);
	int bts(0);
	for(int i=0; i<5; i++)
	{
		for(int j=0; j<4; j++)
		{
			cin>>arr[i][j];
			sum[i]+=arr[i][j];
		}
	}	
	for(int i=0; i<5; i++)
	{
		if(sum[i]>compa)
		{
			compa=sum[i];
			bts=i+1;
		}
	}
	cout<<bts<<" "<<compa;
}
