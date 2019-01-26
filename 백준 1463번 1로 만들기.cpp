#include<iostream>
using namespace std;

int dynamic[1000000];

int small(int a, int b)
{
	if(a>b)
	return b;
	else
	return a;
 } 
 
 
 int main()
 {
 	int n;
 	cin>>n;
 	
 	for(int i=2; i<=n; i++)
 	{
 		dynamic[i]=dynamic[i-1]+1;
 		if(i%2==0)
 		dynamic[i]=small(dynamic[i],dynamic[i/2]+1);
 		if(i%3==0)
 		dynamic[i]=small(dynamic[i],dynamic[i/3]+1);
	 }
	 cout<<dynamic[n]<<endl;
 	
 }
