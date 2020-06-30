#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

vector<long long> v;
int n;
void sorting()
{
	sort(v.begin(),v.end());
	int count(1),maxcount(0);
	long long card;
	for(int i=1; i<n;i++)
	{
		if(v[i-1] != v[i]&&maxcount<count)
		{
			maxcount=count;
			card=v[i-1];
			count=1;
		}
		else if(v[i-1]!=v[i]&&maxcount>=count)
			count=1;
			else
			count++;
	}
	if(maxcount<count)
		card=v[n-1];
		cout<<card<<endl;
}


int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	for(int i=0; i<n; i++)
	{
		long long abcdef;
		cin>>abcdef;
		v.push_back(abcdef);
		
	}
	sorting();
}
