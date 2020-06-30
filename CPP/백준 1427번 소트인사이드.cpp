#include<iostream>
#include<algorithm>
using namespace std;


int main()
{
	string s;
	cin>>s;
	sort(s.begin(),s.end());
	reverse(s.begin(),s.end());
	cout<<s;
	
	
}
