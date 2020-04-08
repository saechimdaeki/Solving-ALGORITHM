#include<iostream>
#define endl '\n'
using namespace std;
int n,arr[2188][2188];
int cnt[3];

bool issame(int x,int y ,int n)
{
	for(int i=x; i<x+n; i++)
		for(int j=y; j<y+n; j++)
			if(arr[x][y]!=arr[i][j])
				return false;
				
	return true;			
}


void solve(int x, int y, int n)
{
	if(issame(x,y,n))
	{
		cnt[arr[x][y]+1]++;
		return;
	}
	int m(n/3);
	for(int i=0;i<3; i++)
		for(int j=0; j<3; j++)
			solve(x+i*m,y+j*m,m);
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	for(int i=0; i<n; i++)
		for(int j=0; j<n; j++)
			cin>>arr[i][j];
	solve(0,0,n);		
	for(int i=0; i<3; i++)
	cout<<cnt[i]<<endl;
}
