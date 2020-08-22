#include<iostream>
using namespace std;

int main()
{
	int a;
	cin>>a;
	int b;
	int arr[a];
	for(int i=0; i<a;i++)
	{
	for(int j=2; j<i; j++)
	{
			cin>>arr[i];
		if((arr[i]%j)==0)
		b++;
	}
}
	cout<<b;
}
