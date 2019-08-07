#include<iostream>
using namespace std;
int dynamic[50001];
int n;
void dp()
{
	dynamic[0]=1;dynamic[1]=1;dynamic[2]=2;
	for(int i=3; i<=n; i++)
	dynamic[i]=(dynamic[i-1]+dynamic[i-3])%1000000009;
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	dp();
	cout<<dynamic[n-1]%1000000009;
}

