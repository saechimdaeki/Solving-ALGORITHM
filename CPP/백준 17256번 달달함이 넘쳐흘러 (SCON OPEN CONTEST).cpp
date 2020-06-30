#include<iostream>
#include<algorithm>
using namespace std;

class cake{
	public:
		int x,y,z;
	cake(int x,int y,int z)
	{
		this->x=x;
		this->y=y;
		this->z=z;
	}
};

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	
	int a,b,c;
	cin>>a>>b>>c;
	cake c1(a,b,c);
	cin>>a>>b>>c;
	cake c2(a,b,c);
	
	cout<<c2.x-c1.z<<" "<<c2.y/c1.y<<" "<<c2.z-c1.x;
	
	
}
