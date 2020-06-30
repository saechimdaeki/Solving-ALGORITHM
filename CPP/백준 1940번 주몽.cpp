#include<iostream>
#include<vector>
using namespace std;
vector<int> v;
bool check[15000];
int n,m;
int cnt;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m;
	for(int i=0; i<n; i++)
	{
		int a;
		cin>>a;
		v.push_back(a);
	}
	for(int i=0; i<n; i++)
	{
		for(int j=i; j<n; j++)
		{
			if(check==false)
			{
				if(v[i]+v[j]==m)
				{
					check[i]=check[j]=true;
				}	
			}
			else 
			;
		}
	}
	cout<<cnt;
}
