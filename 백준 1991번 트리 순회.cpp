#include<iostream>
using namespace std;

class node{
	public:
		char left,right;
};
char z,x,c;
int n;
node node2[100];
void preorder(char a)
{
	if(a=='.')
	return;
	else
	{
		cout<<a;
		preorder(node2[a].left);
		preorder(node2[a].right);
	}
}
void inorder(char a)
{
	if(a=='.')
	return;
	else
	{
		inorder(node2[a].left);
		cout<<a;
		inorder(node2[a].right);
	}
}
void postorder(char a)
{
	if(a=='.')
	return;
	else
	{
		postorder(node2[a].left);
		postorder(node2[a].right);
		cout<<a;
	}
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	for(int i=0; i<n; i++)
	{
		cin>>z>>x>>c;
		node2[z].left=x;
		node2[z].right=c;
	}
	preorder('A');
	cout<<"\n";
	inorder('A');
	cout<<"\n";
	postorder('A');
	cout<<"\n";
}
