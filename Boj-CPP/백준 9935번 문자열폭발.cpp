#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
string s,dels;
bool bombcheck;
char answer[1000001];
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>s>>dels;
	int index(0);
	for(int i=0; i<s.length(); i++)
	{
		answer[index]=s[i];
		index++;
		if(answer[index-1]==dels[dels.length()-1])
		{
			if(index-dels.length()<0)
			continue;
			bombcheck=true;
			for(int j=0; j<dels.length(); j++)
			{
				if(answer[index-j-1]!=dels[dels.length()-j-1])
				{
					bombcheck=false;
					break;
				}
			}
			if(bombcheck==true)
			index-=dels.length();
		}
	}
	if(index)
		for(int i=0; i<index; i++)
		cout<<answer[i];
	else
	cout<<"FRULA";
	
} 
