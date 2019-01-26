#include <iostream>  

using namespace std;

int main(void)
{
	double a,b,c;
	
	cin >> a >> b;
	
	if(a<0 || b>10)
		return -1;
	cout.precision(11);

	c = a/b;
	cout << c;
	
	
						
}
