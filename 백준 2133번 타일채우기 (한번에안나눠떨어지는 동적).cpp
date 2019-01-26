#include<iostream>
using namespace std;

int dynamic[1001];

int dp(int x)
{
	if(x==0)
	return 1;
	if(x==1)
	return 0;
	if(x==2)
	return 3;
	if(dynamic[x]!=0)
	return dynamic[x];
	
	int result=3*dp(x-2);//일단 값을 저장함
	
	for(int i=3; i<=x; i++)
	{
		if(i%2==0)
		result+=2*dp(x-i);
	 } 
	 return dynamic[x]=result;
 } 
 
 int main()
 {
 	int a;
 	cin>>a;
 	cout<<dp(a);
 }
