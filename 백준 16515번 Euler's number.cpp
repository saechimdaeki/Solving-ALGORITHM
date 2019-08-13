#include<iostream>
using namespace std;
int n;
double arr[10001];
void dp(double n1)
{
	arr[0]=1;
	arr[1]=1;
	for(int i=2; i<=n1; i++)
		arr[i]=i*arr[i-1];
}
double sum;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	cout.precision(16);
	dp(n);
	for(int i=0; i<=n; i++)
	{
		sum+=(double)(1/arr[i]);
	}
	cout<<fixed<<(double)sum;
}
