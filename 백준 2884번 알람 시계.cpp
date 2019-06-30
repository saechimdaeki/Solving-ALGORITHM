#include<iostream>
using namespace std;

int h,m;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>h>>m;
	h=m-45<0 ? h-1:h;
	m=m-45<0 ? m+15: m-45; 
	if(h<0)
	cout<<"23"<<" "<<m;
	else
	cout<<h<<" "<<m;
	
	
	
}
