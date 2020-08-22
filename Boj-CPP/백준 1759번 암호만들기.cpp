#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;
int n,m;

bool check(string &password)
{
	int jaum(0),moum(0);
	for(char x:password)
	{
		if(x=='a' || x=='e' ||x=='i' || x=='o' ||x=='u')
		moum+=1;
		else
		jaum+=1;
	}
	return jaum>=2 && moum >=1;
}

void go(int n, vector<char> &alpha, string password, int i)
{
	if(password.length()==n)
	{
		if(check(password))
		cout<<password<<"\n";
		return;
	}
	if(i==alpha.size())
	return;
	go(n,alpha,password+alpha[i],i+1);
	go(n,alpha,password,i+1);
	
}
vector <char> v;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m;
	v.resize(m);
	for(int i=0; i<m; i++)
	cin>>v[i];
	
	sort(v.begin(),v.end());
	go(n,v,"",0);
	
}
