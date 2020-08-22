#include<iostream>
#include<algorithm>
#include<functional>
#include<queue>
#include<cmath>
using namespace std;
priority_queue<pair<int,int > >q;
int n;
int input;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	for(int i=0; i<n; i++)
	{
		cin>>input;
		if(input==0&&q.empty())
		cout<<"0\n";
		else if(input==0)
		{
			cout<<-q.top().second;
			q.pop();
			cout<<"\n";
		}
		else
		q.push(make_pair(-abs(input),-input));
	}
}
