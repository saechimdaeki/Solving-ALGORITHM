#include<iostream>
#include<queue>
#include<algorithm>
#include<vector>
#include<functional>
using namespace std;

int n;
int input;
//vector<int> v;
priority_queue <int, vector<int>, greater<int> > q;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	for(int i=0; i<n; i++)
	{
		cin>>input;
		if(input==0 && q.empty())
		cout<<"0\n";
		else if(input ==0)
		{
			cout<<q.top();	
			q.pop();
			cout<<"\n";
		}
		else
		q.push(input);
	}
}
