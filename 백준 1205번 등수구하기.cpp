#include<iostream>
#include<algorithm>
#include<vector>
#include<functional>
using namespace std;

int n;
vector <int> v;
int yujin,p;
int rank1(1),yujinp(1);
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin>>n>>yujin>>p;
	v.resize(n);
	for(int i=0; i<n; i++)
	{
		cin>>v[i];
		if(v[i]>yujin)
		rank1++;
		if(v[i]>=yujin)
		yujinp++;
	}
	if(rank1>yujinp)
	cout<<"-1";
	else if(yujinp>p)
	cout<<"-1";
	else
	cout<<rank1;
	
	
}

