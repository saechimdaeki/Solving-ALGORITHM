#include<iostream>
using namespace std;
int arr[10];
int main()
{	
	int a;
	int d(0),m(0),as(0);
	for(int i=0; i<8; i++)
	{
		cin>>arr[i];
		
		if(arr[i]==i+1)
		as++;
		else if(arr[i]==8-i)
		d++;
		else
		m++;
	}
	if(as==8)
	cout<<"ascending"<<endl;
	else if(d==8)
	cout<<"descending"<<endl;
	else
	cout<<"mixed"<<endl;
	
}
