#include<iostream>
#include<algorithm>
using namespace std;
string s1,s2;
int cnt;
bool check;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>s1>>s2;
	for(int i=0; i<s1.length(); i++)
	{
		check=false;
		for(int j=0; j<s2.length(); j++)
		{
			if(i+j>=s1.length() || s1.at(i+j)!=s2.at(j))
			{
				check=true;
				break;
				}	
		}
		if(check==false)
		cnt++;	
	} 
	cout<<cnt;
}
