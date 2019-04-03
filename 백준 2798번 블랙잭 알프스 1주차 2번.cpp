#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
vector<int> v;
int n,m;
int bts;
void black_jack(int index,int CountOfCard ,int a2NE1)
{
	
	if(CountOfCard==3&&a2NE1<=m)
	{
		bts=max(bts,a2NE1);
		return;		
	}
	if(index>=n||CountOfCard>3||a2NE1>m)
		return;	

	black_jack(index+1,CountOfCard+1,a2NE1+v[index]);
	black_jack(index+1,CountOfCard,a2NE1);

}

int main()
{

	cin>>n>>m;
	
	for(int i=0; i<n; i++)
	{	int a;
		cin>>a;
		v.push_back(a);
	}
	black_jack(0,0,0);
	cout<<bts<<endl;	
	
}
