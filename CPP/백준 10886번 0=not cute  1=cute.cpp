#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
vector <int> v;

int n;
int zero,one;
int main() 
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	v.resize(n);
	for(int i=0; i<n; i++)
	{
		cin>>v[i];
		if(v[i]==1)
		one++;
		else if(v[i]==0)
		zero++;	
	}
	if(one>zero)
	cout<<"Junhee is cute!";
	else 
	cout<<"Junhee is not cute!";
	
	
}
