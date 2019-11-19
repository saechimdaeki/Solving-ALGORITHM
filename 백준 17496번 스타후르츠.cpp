#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
int n,t,c,p;
int sum;
int daycount;
int count123=1;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>t>>c>>p;
	while(count123<=n)
	{
		count123+=t;
		daycount++;		
	}
	daycount-=1; 
	sum=daycount*c*p;
	cout<<sum;
	
}
