#include<iostream>
#include<algorithm>
#include<vector>
#include<functional>
#define endl '\n'
using namespace std;
vector<pair<int,string> > v;
vector<string> vs;
int n,m;


bool cmp(const pair<int, string> &a, const pair<int, string> &b)
{
    return a.second < b.second;
}


int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m;
	for(int i=0; i<n; i++)
	{
		string pocket;
		cin>>pocket;
		vs.push_back(pocket);
		v.push_back({i+1,pocket});	
	}
	sort(v.begin(),v.end(),cmp);
	
	for(int i=0; i<m; i++)
	{
		string s;
		cin>>s;
		
		if(s[0]>='0'&&s[0]<='9')
		{
			int tmp=stoi(s);
			cout<<vs[tmp-1]<<endl;
		}
		else{
			int left(0);
			int right(n-1);
			while(left<=right)
			{
				int mid=(left+right)/2;
				if(v[mid].second == s){
					cout<<v[mid].first<<endl;
					break;
				}
				else if(v[mid].second<s){
					left=mid+1;
				}
				else{
					right=mid-1;
				}
			}
		}
		
	}
}

