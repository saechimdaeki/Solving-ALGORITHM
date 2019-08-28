#include<iostream>
#include<vector>
using namespace std;
vector<int> a(10);
vector<int> b(10);
int a_count,b_count;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	for(int i=0; i<10; i++)
	cin>>a[i];
	for(int i=0; i<10; i++)
	cin>>b[i];
	for(int i=0; i<10; i++)
	{
		if(a[i]>b[i])
		a_count++;
		else if(a[i]<b[i])
		b_count++;
		else
		;
	}
	if(a_count>b_count)
		cout<<"A";
	else if(a_count==b_count)
	cout<<"D";
	else
	cout<<"B";
}

