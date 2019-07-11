#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
int l,a,b,c,d;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>l>>a>>b>>c>>d;
	int math(l-a/c);
	if(a%c!=0)
	math--;
	int lang(l-b/d);
	if(b%d!=0)
	lang--;
	cout<<min(math,lang);
}
