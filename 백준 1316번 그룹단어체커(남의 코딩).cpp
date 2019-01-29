#include<iostream>
#include<cstring>
using namespace std;

int n,p[200],res;
char str[101];
int main()
{
	cin>>n;
	res=n;
	for(int i=0; i<n; i++)
	{
		memset(p,-1,sizeof(p));
		cin>>str;
		for(int j=0; str[j];j++)
		if (p[str[j]] == -1 || p[str[j]] == j - 1) p[str[j]] = j;
            else { res--; break; }
            
	}
	cout<<res;
}
