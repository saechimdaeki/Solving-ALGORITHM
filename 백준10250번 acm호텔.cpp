#include<iostream>
using namespace std;


int main()
{
	int for1;
	cin>>for1;
	
	for(int i=0; i<for1; i++)
	{
		int h,w,n;
		cin>>h>>w>>n;
		
		n--;
		printf("%d%02d\n",n%h+1, n/h+1);	
	}
	

	
}
