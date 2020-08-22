#include<iostream>
#include<algorithm>
#include<queue>
using namespace std;
int n;
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
		int answer(q.front());
		cout<<answer<<" ";
		q.pop();
		int foranswer(q.front());
		q.pop();
		q.push(foranswer);
	}
}
