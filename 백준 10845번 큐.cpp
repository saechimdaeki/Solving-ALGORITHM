#include<iostream>
#include<algorithm>
#include<queue>
using namespace std;

int main()
{
	int n;
	cin>>n;
	queue <int>q;
	int count(0);
	for(int i=0; i<n; i++)
	{
		string s;
		cin>>s;
		if(s=="push")
		{
			int av;
			cin>>av;
			q.push(av);	
		}
		else if(s=="pop")
		{
			if(q.size()==0)
				count =-1;
			else
			{
				count=q.front();
				q.pop();
			}
			cout<<count<<"\n";
		}
		else if(s=="empty")
		{
			if(q.size()==0)
			count=1;
			else
			count=0;
			cout<<count<<"\n";
			
		}
		else if(s=="size")
		cout<<q.size()<<"\n";
		else if(s=="front")
		{
			if(q.size()==0)
			count=-1;
			else
			count=q.front();
			cout<<count<<"\n";
		}
		else if(s=="back")
		{
			if(q.size()==0)
			count=-1;
			else
			count=q.back();
			cout<<count<<"\n";
		}
			
	}
}
