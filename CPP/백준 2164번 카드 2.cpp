#include<iostream>
#include<queue>
#include<algorithm>
using namespace std;
int n,answer;
queue<int> q;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	for(int i=1; i<=n; i++)
	q.push(i);
	while(!q.empty())
	{
		answer=q.front();
		q.pop();
		if(!q.empty())
		{
			//q.push(answer);
			q.push(q.front());
			q.pop();	
		} 
	}
	cout<<answer;
}
