#include<iostream>
using namespace std;
long long a,b;
int solve(long long n1,long long n2)
{
	if(n1>n2)return -1;
	if(n1==n2) return 1;
	int tmp1(solve(n1*2,n2));
	int tmp2(solve(n1*10+1,n2));
	if(tmp1==-1 && tmp2==-1) return -1;
	if(tmp1==-1)return tmp2+1;
	if(tmp2==-1)return tmp1+1;
	return min(tmp1,tmp2)+1;
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>a>>b;
	cout<<solve(a,b);
}
