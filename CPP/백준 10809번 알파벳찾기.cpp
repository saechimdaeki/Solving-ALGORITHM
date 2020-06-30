#include<iostream>
#include<cstring> 
using namespace std;

int main()
{
	char voca[100];
	int n[26];
	int abc(0);
	cin>>voca;
	
	for(int i=0; i<26; i++)
		n[i]=-1;
		
		for(int i=0; voca[i]!='\0'; i++)
		{
			abc=voca[i] -97;
			if(n[abc]==-1)
				n[abc]=i;
		}
		for(int i=0; i<26; i++)
		cout<<n[i]<<" ";
}
