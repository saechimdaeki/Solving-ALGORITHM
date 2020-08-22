#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int n,position[100001];
vector<int> inorder,postorder;

void solve(int ins,int ine,int posts,int poste)
{
	if(ins>ine || posts>poste)
	return;
	int root(postorder[poste]);
	cout<<root<<' ';
	int p(position[root]);
	int left=p-ins;
	solve(ins,p-1,posts,posts+left-1);
	solve(p+1,ine,posts+left,poste-1);
	
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	inorder.resize(n); postorder.resize(n);
	for(int i=0; i<n; i++)
	cin>>inorder[i];
	for(int i=0; i<n; i++)
	cin>>postorder[i];
	for(int i=0; i<n; i++)
	position[inorder[i]]=i;
	solve(0,n-1,0,n-1);
	
}
