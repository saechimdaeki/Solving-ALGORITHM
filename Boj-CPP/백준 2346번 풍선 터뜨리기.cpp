#include<iostream>
#include<algorithm>
#include<queue>
#include<vector>
#define endl '\n'
using namespace std;
int n;
vector<pair<int, int > > v;
vector<int> answer;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	for(int i=0; i<n; i++)
	{
		int a;
		cin>>a;
		v.push_back({i,a});
	}
	int saved(n);
	int first123(0);
	for(int i=0; i<saved; i++)
	{
		answer.push_back(v[first123].first);
		int tmp(v[first123].second);
		if(tmp>0)
		tmp--;
		v.erase(v.begin()+first123);
		first123+=tmp;
		if((--n)==0) //<----블로그참고함 이 if문  
		{
			break;	
		}
		if(first123>=0)
		 ;
		 else
		 first123=n+first123%n;	
		first123%=n;
	}
	//cout<<endl; 
	for(int i=0; i<answer.size(); i++)
	{
		cout<<answer[i]+1<<' ';
	}
	/*
	for(int i=0; i<answer.size(); i++)
	cout<<i<<' ';
	*/
}
