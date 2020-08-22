#include<iostream>
#include<queue>
#include<algorithm>
#define endl '\n'
using namespace std;
queue<int> q;
int t;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>t;
	for(int i=0; i<t; i++)
	{
		string s;
		cin>>s;
		if(s=="push")
		{
			int a;
			cin>>a;
			q.push(a);
		}else if (s=="front")
		{
			if(q.empty())
			cout<<-1<<endl;
			else
			cout<<q.front()<<endl;
		}else if(s=="back")
		{
			if(q.empty())
			cout<<-1<<endl;
			else
			cout<<q.back()<<endl;
		 }else if(s=="size")
		 {
		 	cout<<q.size()<<endl;
		 }else if(s=="pop")
		 {
		 	if(q.empty())
		 	cout<<-1<<endl;
		 	else
		 	{
			int b(q.front());
		 	q.pop();
		 	cout<<b<<endl; 		
			}
		
		 }else if (s=="empty")
		 {
		 	if(q.empty())
		 	cout<<1<<endl;
		 	else
		 	cout<<0<<endl;
		 }
	}
}
