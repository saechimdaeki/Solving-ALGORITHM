#include<iostream>
#include<algorithm>
using namespace std;
string n;
int m;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m;
	int a=n.length();
	int number(stoi(n));
	string answer;
	if(a*number>=m)
	{
		int count123(0);
		while(true)
		{
			if(count123+a>m)
			break;
			answer+=n;
			count123+=a;
		}
		for(int i=0; i<m-count123;i++)
		answer+=n[i];
	}
	else
	{
		for(int i=0; i<number;i++)
		answer+=n;	
	}
	
	cout<<answer;
	
}
