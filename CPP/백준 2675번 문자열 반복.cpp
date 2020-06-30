#include<iostream>
using namespace std;

int main()
{
	string arr;
	int n;
	int n2;
	cin>>n;
	for(int i=0; i<n; i++)
	{
		cin>>n2>>arr;
		for(int j=0; j<arr.length(); j++)
		{
			for(int i=0; i<n2; i++)
			printf("%c",arr.at(j));
			
		
		}
			cout<<endl;
	}
}
