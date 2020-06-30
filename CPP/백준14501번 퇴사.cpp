#include<iostream>
#include<algorithm>
#include<vector>
#define endl '\n'
using namespace std;
int n,answer;
int t[16],p[16];
void quit(int day, int sum)
{
	if(day==n+1)
	{
		answer=max(answer,sum);
		return;
	}
	if(day>n+1)
	return;
	quit(day+1,sum);
	quit(day+t[day-1],sum+p[day-1]);
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	for(int i=0; i<n; i++)
	cin>>t[i]>>p[i];
	quit(1,0);
	cout<<answer;
	return 0;
}
