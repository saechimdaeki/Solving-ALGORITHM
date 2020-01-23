#include<iostream>
#include<algorithm>
#include<vector>
#define endl '\n'
using namespace std;
vector<int> v;
vector<int> answer;
int n,k;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>k;
	for(int i=1; i<=n; i++)
		v.push_back(i);
		

	int savek(k-1);
	int saven(n);
	for(int i=0; i<n; i++)
	{
		
		answer.push_back(v[savek]);
		v.erase(v.begin()+savek);
		savek+=(k-1);
		if(--saven>0)
		{
			savek%=saven;
		}
		
	}
	
	cout<<"<";
	for(int i=0; i<answer.size(); i++)
	{
		if(i==answer.size()-1)
		cout<<answer[i];
		else
		cout<<answer[i]<<", ";
	}
	cout<<">";
	
	
	
	
	
	
}
