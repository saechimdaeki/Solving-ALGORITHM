#include<iostream>
#include<vector>
#include<algorithm>
#define endl '\n'
using namespace std;

vector<pair<int,pair<int,pair<int,int> >>> v;      // 참가국 카운트  학생번호 점수  
int n; 

bool cmp(pair<int,pair<int,pair<int,int >> >p1, pair<int,pair<int,pair<int, int> > >  p2)
{
	return p1.second.second.second>p2.second.second.second;
	
}
int cnt;
int country_cnt=1;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	v.resize(n);
	v[0].second.first=1;
	for(int i=0; i<n; i++)
	{
		cin>>v[i].first>>v[i].second.second.first>>v[i].second.second.second;
	}
	sort(v.begin(),v.end(),cmp);
	for (int i=0; i<n; i++)
	{
		if(cnt==3)
		break;
		if(v[i].first==v[i-1].first)
		{
			country_cnt++;
		}
		if(country_cnt>2)
		{
			cout<<v[i+1].first<<' '<<v[i+1].second.second.first<<endl;	
			cnt++;
			country_cnt=0;
		}else{
			cout<<v[i].first<<' '<<v[i].second.second.first<<endl;
			cnt++;
			
		}	
	}
	
	
}
