#include<iostream>
#include<stack>
#include<vector>
#define endl '\n'
using namespace std;
int n,a,b,c,sum;
vector<int> v;
stack<pair<int,int> > st;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;//a는과제유무 b과제점수 c과제소요시간 
	for(int i=0; i<n; i++)
	{
		cin>>a;
		if(a==0)
		{
			if(st.size()==0)
			continue;
			st.top().second--;
			if(st.top().second==0)
			{
				sum+=st.top().first;
				st.pop();	
			}
			continue;	
		}
		else
		{
		cin>>b>>c;
		c--;
		if(c==0)
		{
			sum+=b;
		}
		else
		st.push(make_pair(b,c));		
		}
	
		
	}
	cout<<sum;
}
