#include<iostream>
#include<queue>
#include<vector>
#include<functional>
#include<utility>
#define endl '\n'
using namespace std; 
typedef pair<int, int> pi; 
int t;
bool check[1000000];
priority_queue<pi> pqmax;//maxheap
priority_queue<pi, vector<pi>, greater<pi> > pqmin; //minheap
void clearmaxheap(priority_queue<pair<int, int> > & q)
{
	priority_queue<pair<int, int> > empty;
	swap(q, empty);
}
void clearminheap(priority_queue<pi, vector<pi>, greater<pi> > &q)
{
	priority_queue<pi, vector<pi>, greater<pi>> empty;
	swap(q,empty);
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>t;
	while(t--)
	{
		clearmaxheap(pqmax);
		clearminheap(pqmin);
		int k;
		cin>>k;
		for(int i=0; i<k; i++)
		{
			char c;
			int num;
			cin>>c>>num;
			if(c=='I')
			{
				pqmax.push(make_pair(num,i));
				pqmin.push(make_pair(num,i));
				check[i]=true;
			}
			else if(c=='D')
			{
				if(pqmin.empty() || pqmax.empty())
					continue;
				if(num== -1 )
				{
					while(pqmin.empty()==0 && check[pqmin.top().second]==false)
						pqmin.pop();
					
					if(pqmin.empty()==false)
					{
						check[pqmin.top().second]=false;
						pqmin.pop();
					}
				}
				else if (num == 1)
				{
					while(pqmax.empty()==0 && check[pqmax.top().second]==false)
						pqmax.pop();
					
					if(pqmax.empty()==0)
					{
						check[pqmax.top().second]=false;
						pqmax.pop();
					}
				}
			}
			while(pqmax.empty()==0 && check[pqmax.top().second]==false)
				pqmax.pop();
			while(pqmin.empty()==0 && check[pqmin.top().second]==false)
				pqmin.pop();
			
		}
		if(pqmax.empty() && pqmin.empty())
		cout<<"EMPTY"<<endl;
		else
		cout<<pqmax.top().first<<' '<<pqmin.top().first<<endl;
	}
}
