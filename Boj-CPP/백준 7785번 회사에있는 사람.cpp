#include<iostream>
#include<algorithm>
#include<set>

using namespace std;
int n;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	set<string , greater<string> > s;
	string a, b;
	for(int i=0; i<n; i++)
	{
		cin>>a>>b;
		if(b=="enter")
		s.insert(a);
		else if(b=="leave")
		{
			s.erase(s.find(a));
		}	
	}
	set<string , greater<string> >::iterator iterate;
	for(iterate=s.begin(); iterate!=s.end(); iterate++)
	cout<<*iterate<<"\n";	
} 
