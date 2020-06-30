#include<iostream>
using namespace std;

int dynamic[1000001][2];

/*int dp(int x)
{
	if(x==0)
	return 1;
	if(x==1)
	return 2;
	if(x==2)
	return 7;
	if(dynamic[x]!=0)
	return dynamic[x];
	int result=3*dp(x-2)+2*dp(x-1);
	
	for(int i=3; i<=x; i++)
	result +=(2*dp(x-i))%1000000007;
	
	return dynamic[x]=result %1000000007;
 } 
 *///이러면 시간초과나오므로 
 
 int dp(int x)
 {
 	dynamic[0][0]=0;
 	dynamic[1][0]=2;
 	dynamic[2][0]=7;
 	dynamic[2][1]=1;
 	for (int i=3; i<=x; i++)
 	{
 		dynamic[i][1]=(dynamic[i-1][1]+dynamic[i-3][0])%1000000007;
 		dynamic[i][0]=(3*dynamic[i-2][0]+2*dynamic[i-1][0]+2*dynamic[i][1])%1000000007;
 		
	 }
	 return dynamic[x][0];
 }
 int main()
 {
 	int n;
 	cin>>n;
 	cout<<dp(n);
 }
