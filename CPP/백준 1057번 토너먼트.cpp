#include<iostream>
#include<algorithm>
using namespace std;

int n,m;
int jimin,hansoo;
int round2(1);



int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>jimin>>hansoo;
	m=n;
	for(int i=0; i<n; i++)
	{
		if((jimin+1)/2 ==(hansoo+1)/2)
			break;
		jimin=(jimin+1)/2;
		hansoo=(hansoo+1)/2;
		round2++;
		m/=2;
	}
	if(!m)
	cout<<"-1";
	
	cout<<round2<<"\n";		
}
