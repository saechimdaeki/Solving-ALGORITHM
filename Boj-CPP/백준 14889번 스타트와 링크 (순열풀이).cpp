#include<iostream>
#include<algorithm>
#include<vector> 
#include<cmath>
using namespace std;
int n,answer(2e9+1);
int start_team,link_team;
vector<int> all;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	vector<vector<int> > v(n,vector<int>(n));
	for(int i=0; i<n; i++)
		for(int j=0; j<n; j++)
			cin>>v[i][j];
	all.resize(n);
	for(int i=0; i<n/2; i++)
	all[i]=1;
	for(int i=n/2; i<n; i++)
	all[i]=2;
	sort(all.begin(),all.end());
	do{
		vector<int> start,link;
		for(int i=0; i<n; i++)
		{
			if(all[i]==1)
			start.push_back(i);
			else
			link.push_back(i);
		}
		start_team=0;
		link_team=0;
		for(int i=0; i<n/2; i++)
		{
			for(int j=0; j<n/2; j++)
			{
				if(i==j)
				continue;
				start_team+=v[start[i]][start[j]];
				link_team+=v[link[i]][link[j]];
			}
		}
		int teampower(abs(start_team-link_team));
		answer=min(answer,teampower);
		
	}while(next_permutation(all.begin(),all.end()));
	cout<<answer;		
			
}
