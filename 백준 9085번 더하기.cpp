#include<iostream>
using namespace std;

int main()
{
	int n;
	cin>>n;
	int n2;
	int n3;
	int sum(0);
	for(int i=0; i<n; i++)
	{
		cin>>n2;
		sum=0;
		for(int j=0; j<n2; j++)
		{
			cin>>n3;
			sum+=n3;
			
		}
		cout<<sum<<endl;
	}
	
}
