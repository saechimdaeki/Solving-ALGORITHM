#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int n,k;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>k;
	for(int a=0; a<=n; a++)
	{
		int b(n-a); //n:=a+b´Ï²² 
		if(a*b<k) continue;
		vector<int> cnt(b+1);
		for(int i=0; i<a; i++)
		{
			int x(min(b,k));
			cnt[x]++;
			k-=x;
		}
		for(int i=b; i>=0; i--)
		{
			for(int j=0; j<cnt[i]; j++)
			cout<<'A';
			if(i>0)
			cout<<'B';
		}
		return 0;
	}
	cout<<-1;
}
