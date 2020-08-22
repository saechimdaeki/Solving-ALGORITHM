#include <iostream>
#include<vector>
using namespace std;
long long S;

int num(1),count123(0);
long long sum;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
        cin >> S;
        while(true)
        {
        	sum+=num;
        	count123++;
        	if(sum>S)
        	{
        		count123-=1;
        		break;
			}
			num++;
		}
        cout << count123 << endl;
        
}
